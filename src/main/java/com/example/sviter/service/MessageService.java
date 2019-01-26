package com.example.sviter.service;


import com.example.sviter.domain.MyMassage;
import com.example.sviter.domain.User;
import com.example.sviter.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public Page<MyMassage> messageList(Pageable pageable, String filter) {
        if (filter != null && !filter.isEmpty()) {
            return messageRepository.findByTag(filter, pageable);
        } else {
            return messageRepository.findAll(pageable);
           // return messageRepository.findAll(pageable, user);
        }
    }

    public Page<MyMassage> messageListForUser(Pageable pageable, User currentUser, User author) {
        return messageRepository.findByUser(pageable, author);
    }
}