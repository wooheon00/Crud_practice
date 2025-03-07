package com.example.basic_crud.repository;

import com.example.basic_crud.entity.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;


/*
public class LocalPostRepository implements PostRepository{

    private final List<Post> posts = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public void save(Post post) {
        post.setId(idGenerator.getAndIncrement());
        posts.add(post);
    }

    @Override
    public void delete(Post post) {
        posts.remove(post);
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public List<Post> findPostByTitle(String title){

        List<Post> findPosts = new ArrayList<>();

        for(Post post : posts){
            if(post.getTitle().contains(title)){
                findPosts.add(post);
            }
        }
        return findPosts;
    }

    @Override
    public Optional<Post> findPostById(Long id) {
        Optional<Post> findPost = Optional.empty();
        for(Post post : posts){
            if(post.getId() == id){
                findPost = Optional.of(post);
            }
        }
        return findPost;
    }

    @Override
    public void deleteByMemberId(Long id) {
        posts.removeIf(post -> post.getMember().getId().equals(id));
    }
}
*/