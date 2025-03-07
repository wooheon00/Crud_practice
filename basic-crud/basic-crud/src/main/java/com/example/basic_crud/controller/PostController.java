package com.example.basic_crud.controller;


import com.example.basic_crud.entity.Comment;
import com.example.basic_crud.entity.Member;
import com.example.basic_crud.entity.Post;
import com.example.basic_crud.service.CommentService;
import com.example.basic_crud.service.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private final CommentService commentService;
    private final PostService postService;

    @Autowired
    public PostController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }


    @GetMapping("/post/{id}")
    public String getPostDetail(@PathVariable("id") Long id, Model model) {

        List<Comment> nowComments = commentService.findCommentsByPostId(id);

        model.addAttribute("post", postService.findPostById(id).get());
        model.addAttribute("comments", nowComments);

        return "post-detail";
    }


    @GetMapping("/post/list")
    public String showPosts(HttpSession session,
                              Model model)
    {
        List<Post> posts = postService.getAllPost();
        model.addAttribute("posts", posts);
        return "post-showing";
    }


    @GetMapping("/post/writing")
    public String writingPost(HttpSession session,
                           Model model)
    {
        Member member = (Member) session.getAttribute("member");
        if (member == null) {
            return "redirect:/members/login";
        }

        model.addAttribute("member", member);
        return "post-writing";
    }


    @PostMapping("/check/post")
    public String checkPost(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            HttpSession session)
    {

        Member writer = (Member) session.getAttribute("member");
        Post newPost = new Post(writer, title, content);
        postService.registerPost(newPost);
        return "redirect:/post/list";
    }

    @PostMapping("/delete/post")
    public String deletePost(
            @RequestParam("postId") Long postId,
            HttpSession session)
    {
        postService.deletePost(postService.findPostById(postId).get());
        commentService.deleteCommentByPostId(postId);

        return "redirect:/post/list";
    }


    @GetMapping("/debug/post")
    public String debugPost(Model model) {
        List<Post> posts = postService.getAllPost();
        model.addAttribute("posts", posts);
        return "debug-post";
    }


}
