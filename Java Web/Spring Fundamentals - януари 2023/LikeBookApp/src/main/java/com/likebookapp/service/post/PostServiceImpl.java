package com.likebookapp.service.post;

import com.likebookapp.model.dto.AddPostDTO;
import com.likebookapp.model.entity.PostEntity;
import com.likebookapp.model.entity.UserEntity;
import com.likebookapp.repository.PostRepository;
import com.likebookapp.service.mood.MoodService;
import com.likebookapp.service.user.UserService;
import com.likebookapp.util.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    private final LoggedUser loggedUser;

    private final UserService userService;

    private final MoodService moodService;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, LoggedUser loggedUser, UserService userService, MoodService moodService) {
        this.postRepository = postRepository;
        this.loggedUser = loggedUser;
        this.userService = userService;
        this.moodService = moodService;
    }

    @Override
    public void addPost(AddPostDTO addPostDTO) {
        PostEntity post = new PostEntity();

        post.setContent(addPostDTO.getContent());

        post.setMood(this.moodService.findMood(addPostDTO.getMood()));

        post.setCreator(this.userService.findByUsername(loggedUser.getUsername()));

        this.postRepository.save(post);
    }

    @Override
    public Set<PostEntity> getPostsFromCurrentUser(Long id) {
        return this.postRepository.findAllByCreator_Id(id);
    }

    @Override
    public Set<PostEntity> getPostsFromOtherUsers(Long id) {
        return this.postRepository.findAllByCreator_IdIsNot(id);
    }

    @Transactional
    @Override
    public void removePost(Long id) {
        PostEntity post = this.postRepository.getById(id);

        post.getLikedBy().forEach(userEntity -> {
            userEntity.removeLike(post);
        });

        this.postRepository.deleteById(id);
    }

    @Override
    public void likePost(Long id) {
        UserEntity user = this.userService.findByUsername(loggedUser.getUsername());

        PostEntity post = this.postRepository.getById(id);

        user.likePost(post);
    }

    @Override
    public PostEntity getPostWithId(Long id) {
        return this.postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Post with this id was not found!"));
    }
}
