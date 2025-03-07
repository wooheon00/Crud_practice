package com.example.basic_crud.service;

import com.example.basic_crud.entity.Comment;
import com.example.basic_crud.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void registerComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> findCommentsByPostId(Long postId) {
        return commentRepository.findByPost_Id(postId);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public void deleteCommentByPostId(Long postId) {
        commentRepository.deleteByPost_Id(postId);
    }

    @Override
    public void deleteCommentById(Long commentId) {
        commentRepository.deleteById(commentId);
    }


}
