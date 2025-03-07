package com.example.basic_crud.service;

import com.example.basic_crud.entity.Comment;
import com.example.basic_crud.entity.Member;

import java.util.List;

public interface CommentService {

    void registerComment(Comment comment);
    List<Comment> findCommentsByPostId(Long postId);
    List<Comment> findAll();
    void deleteCommentByPostId(Long postId);
    void deleteCommentById(Long commentId);

}
