package com.backend.blog.dto.post;

import com.backend.blog.dto.user.UserUndetailedDTO;

import java.time.LocalDate;

public record PostResponseDTO(Integer id, String title, String content, LocalDate date, UserUndetailedDTO author) {
}
