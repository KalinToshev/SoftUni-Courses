package com.likebookapp.controller;

import com.likebookapp.model.entity.PostEntity;
import com.likebookapp.model.entity.UserEntity;
import com.likebookapp.service.post.PostService;
import com.likebookapp.service.user.UserService;
import com.likebookapp.util.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
public class HomeController {
    private final LoggedUser loggedUser;

    private final UserService userService;

    private final PostService postService;

    @Autowired
    public HomeController(LoggedUser loggedUser, UserService userService, PostService postService) {
        this.loggedUser = loggedUser;
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping("/")
    public String index() {
        if (this.loggedUser.isLogged()) {
            return "redirect:/home";
        }

        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        if (!this.loggedUser.isLogged()) {
            return "redirect:/";
        }

        UserEntity user = this.userService.findByUsername(loggedUser.getUsername());

        model.addAttribute("currentUser", user);

        Set<PostEntity> postsFromCurrentUser = this.postService.getPostsFromCurrentUser(this.loggedUser.getId());

        model.addAttribute("userPosts", postsFromCurrentUser);

        Set<PostEntity> postsFromOtherUsers = this.postService.getPostsFromOtherUsers(this.loggedUser.getId());

        model.addAttribute("otherUsersPosts", postsFromOtherUsers);

        return "home";
    }
}
