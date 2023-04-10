package com.likebookapp.service.post;

import com.likebookapp.model.dto.AddPostDTO;
import com.likebookapp.model.entity.PostEntity;

import java.util.Set;

public interface PostService {
    void addPost(AddPostDTO addPostDTO);

    Set<PostEntity> getPostsFromCurrentUser(Long id);

    Set<PostEntity> getPostsFromOtherUsers(Long id);

    void removePost(Long id);

    void likePost(Long id);

    PostEntity getPostWithId(Long id);
}
