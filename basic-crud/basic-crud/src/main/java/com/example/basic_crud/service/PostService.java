package com.example.basic_crud.service;

import com.example.basic_crud.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    void registerPost(Post post);
    void deletePost(Post post);
    List<Post> getAllPost();
    Optional<Post> findPostById(Long id);

}
