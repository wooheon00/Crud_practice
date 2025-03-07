package com.example.basic_crud.repository;

import com.example.basic_crud.entity.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/*
public class LocalCommentRepository implements CommentRepository{

    private final List<Comment> comments = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public void save(Comment comment) {
        comment.setId(idGenerator.getAndIncrement());
        comments.add(comment);
    }

    @Override
    public List<Comment> findByPostId(Long postId) {
        List<Comment> findComments = new ArrayList<>();
        for(Comment comment : comments){
            if(postId.equals(comment.getPost().getId())){
                findComments.add(comment);
            }
        }
        return findComments;
    }

    @Override
    public List<Comment> findByMemberId(Long memberId) {
        List<Comment> findComments = new ArrayList<>();
        for(Comment comment : comments){
            if(comment.getMember().getId().equals(memberId)){
                findComments.add(comment);
            }
        }
        return findComments;
    }

    @Override
    public void delete(Comment comment) {
        comments.remove(comment);
    }

    @Override
    public List<Comment> findAll() {
        return comments;
    }

    @Override
    public void deleteByPostId(Long postId) {
        comments.removeIf(comment -> comment.getPost().getId().equals(postId));
    }

    @Override
    public void deleteById(Long commentId) {
        for(Comment comment : comments){
            if(comment.getId().equals(commentId)){
                comments.remove(comment);
                break;
            }
        }
    }

    @Override
    public void deleteByMemberId(Long memberId) {
        comments.removeIf(comment -> comment.getMember().getId().equals(memberId));
    }

}


 */