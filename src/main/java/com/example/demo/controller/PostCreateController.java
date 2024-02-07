package com.example.demo.controller;

import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PostCreateController {
    private final PostService service;

    @Autowired
    public PostCreateController(PostService service,
                                PostRepository postRepository)
    {
        this.service = service;
    }

    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String create(Model model){
        return "create";
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public String doCreate(@ModelAttribute("text") String text){
        service.create(text);
        return "redirect:/";
    }
}
