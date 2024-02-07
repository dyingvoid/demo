package com.example.demo.service;

import com.example.demo.domain.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public Iterable<Post> listAllPosts()
    {
        return postRepository.findAll();
    }

    public void create(String text){
        Post entity = new Post();
        entity.setText(text);

        postRepository.save(entity);
    }
}
