package com.likebookapp.controller;

import com.likebookapp.model.dto.AddPostDTO;
import com.likebookapp.service.post.PostService;
import com.likebookapp.util.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Controller
public class PostController {
    private final LoggedUser loggedUser;

    private final PostService postService;

    @Autowired
    public PostController(LoggedUser loggedUser, PostService postService) {
        this.loggedUser = loggedUser;
        this.postService = postService;
    }

    @GetMapping("/post/add")
    public String addPost() {
        if (!this.loggedUser.isLogged()) {
            return "redirect:/user/login";
        }

        return "post-add";
    }

    @PostMapping("/post/add")
    public String addPostConfirm(@Valid AddPostDTO addPostDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("addPostDTO", addPostDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addPostDTO", bindingResult);

            return "redirect:/post/add";
        }

        this.postService.addPost(addPostDTO);

        return "redirect:/";
    }

    @GetMapping("/post/remove/{id}")
    public String removePost(@PathVariable Long id) {
        if (!this.loggedUser.isLogged()) {
            return "redirect:/user/login";
        }

        this.postService.removePost(id);

        return "redirect:/home";
    }

    @Transactional
    @GetMapping("/post/like/{id}")
    public String likePost(@PathVariable Long id) {
        if (!this.loggedUser.isLogged()) {
            return "redirect:/user/login";
        }

        this.postService.likePost(id);

        return "redirect:/home";
    }

    @ModelAttribute
    private AddPostDTO addPostDTO() {
        return new AddPostDTO();
    }
}
