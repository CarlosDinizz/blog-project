package com.backend.blog.exception.post;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(String message) {
        super(message);
    }

    public PostNotFoundException() {
        super("User not found.");
    }
}
