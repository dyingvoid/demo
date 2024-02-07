package com.example.demo.service;

import com.example.demo.domain.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class LikesService {
    private final PostService postService;
    private final PostRepository postRepository;

    @Autowired
    public LikesService(PostService postService,
                        PostRepository postRepository)
    {
        this.postService = postService;
        this.postRepository = postRepository;
    }

    public int like(Long id)
    {
        Optional<Post> foundPost = StreamSupport.stream(
                postService.listAllPosts().spliterator(), false
        ).filter(element -> Objects.equals(element.getId(), id)).findFirst();

        if(foundPost.isPresent()) {
            Post post = foundPost.get();
            post.setLikes(post.getLikes() + 1);
            postRepository.save(post);

            return post.getLikes();
        }

        return 0;
    }
}
