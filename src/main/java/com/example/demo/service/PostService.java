package com.example.demo.service;

import com.example.demo.model.Post;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    public Post[] listAllPosts()
    {

        return new Post[]{
                new Post("Zero", 0),
                new Post("First", 228),
                new Post("Second", 322)
        };
    }
}
