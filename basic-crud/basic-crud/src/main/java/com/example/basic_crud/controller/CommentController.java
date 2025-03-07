package com.example.basic_crud.controller;


import com.example.basic_crud.entity.Comment;
import com.example.basic_crud.entity.Member;
import com.example.basic_crud.service.CommentService;
import com.example.basic_crud.service.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CommentController {

    private final CommentService commentService;
    private final PostService postService;


    @Autowired
    public CommentController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }


    @PostMapping("/check/comment")
    public String checkPost(
            @RequestParam("commentContent") String commentContent,
            @RequestParam("postId") Long postId,
            @RequestParam("memberId") Long memberId,
            HttpSession session)
    {
        if(memberId == null) return "redirect:/member/login";

        Comment newComment = new Comment(postService.findPostById(postId).get(), (Member) session.getAttribute("member"), commentContent);
        commentService.registerComment(newComment);

        return "redirect:/post/" + postId;
    }

    @PostMapping("/delete/comment")
    public String deletePost(@RequestParam("commentId") Long commentId,
                             @RequestParam("postId") Long postId)
    {
        commentService.deleteCommentById(commentId);
        return "redirect:/post/" + postId;
    }

    @GetMapping("/debug/comment")
    public String debugComment(Model model) {
        List<Comment> comments = commentService.findAll();
        model.addAttribute("comments", comments);
        return "debug-comment";
    }


}
