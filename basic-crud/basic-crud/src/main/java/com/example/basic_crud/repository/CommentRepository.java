package com.example.basic_crud.repository;

import com.example.basic_crud.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPost_Id(Long postId);
    List<Comment> findAll();

    void delete(Comment comment);
    void deleteByPost_Id(Long postId);
    void deleteById(Long commentId);
}