package com.example.sviter.domain.dto.util;


import com.example.sviter.domain.User;

public abstract class MessageHelper {
    public static String getAuthorName(User author) {
        return author != null ? author.getUsername() : "<none>";
    }
}