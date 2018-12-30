package com.example.sviter.controller;

import com.example.sviter.domain.MyMassage;
import com.example.sviter.domain.User;
import com.example.sviter.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;


import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    public MainController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/")
    public String greeting(Map<String, Object> model){
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model){
        Iterable<MyMassage> messages = messageRepository.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag,
            Map<String, Object> model) {
        MyMassage message = new MyMassage(text, tag, user);
        messageRepository.save(message);
        Iterable<MyMassage> messages = messageRepository.findAll();
        model.put("messages", messages);

        return "main";
    }
    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        Iterable<MyMassage> message;
        if(filter != null && !filter.isEmpty()) {
            message = messageRepository.findByTag(filter);
        }else{
            message = messageRepository.findAll();
        }
        model.put("messages", message);
        return "main";
    }
}
