package com.backend.blog.dto.post;

import java.time.LocalDate;

public record PostUndetailedResponseDTO(Integer id, String title, String content) {
}
