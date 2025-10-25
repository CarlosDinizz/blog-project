package com.backend.blog.exception;

import com.backend.blog.dto.response.Response;
import com.backend.blog.exception.post.PostNotFoundException;
import com.backend.blog.exception.user.InvalidPasswordException;
import com.backend.blog.exception.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Response> handleUserNotFound(UserNotFoundException exception){
        Response response = new Response(
                false,
                exception.getMessage(),
                null,
                HttpStatus.NOT_FOUND.value()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<Response> handlePostNotFound(PostNotFoundException exception) {
        Response response = new Response(
                false,
                exception.getMessage(),
                null,
                HttpStatus.NOT_FOUND.value()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<Response> handleInvalidPassword(InvalidPasswordException exception){
        Response response =  new Response(
                false,
                exception.getMessage(),
                null,
                HttpStatus.BAD_REQUEST.value()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Response> handleNoResourceFoundException(NoResourceFoundException exception){
        Response response =  new Response(
                false,
                exception.getMessage(),
                null,
                exception.getStatusCode().value()
        );
        return ResponseEntity.status(exception.getStatusCode()).body(response);
    }
}
