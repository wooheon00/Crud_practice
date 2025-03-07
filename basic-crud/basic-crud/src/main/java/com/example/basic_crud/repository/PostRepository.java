package com.example.basic_crud.repository;

import com.example.basic_crud.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    void delete(Post post);
    List<Post> findAll();
    Optional<Post> findById(Long id);

}