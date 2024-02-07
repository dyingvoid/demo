package com.example.demo.service;

import com.example.demo.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {
    private ArrayList<Post> posts = new ArrayList<>();
    private Long counter = 0L;

    public ArrayList<Post> listAllPosts()
    {
        return posts;
    }

    public void create(String text){
        posts.add(new Post(counter, text, new Date()));
        counter++;
    }
}
