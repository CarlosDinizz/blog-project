package com.backend.blog.dto.response;

public record Response(
        Boolean success,
        String message,
        Object data,
        Integer status_code
) {
}
