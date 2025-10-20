package com.backend.blog.dto.user;

public record UserRequestDTO(String name, String last_name, String email, String password, String confirm_password) {
}
