package com.backend.blog.controller;

import com.backend.blog.dto.post.PostRequest;
import com.backend.blog.dto.post.PostResponseDTO;
import com.backend.blog.dto.post.PostUndetailedResponseDTO;
import com.backend.blog.dto.response.Response;
import com.backend.blog.service.post.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@Slf4j
public class PostController {

    private PostService service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getPostById(@PathVariable Integer id){
        log.info("GET: /api/v1/posts/" + id);
        PostResponseDTO responseDTO = service.getPostById(id);
        Response response = new Response(
                true,
                "Posts has been found.",
                responseDTO,
                HttpStatus.OK.value()
        );
        log.info("Posts has been found.");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Response> findAllPostsByUserId(@PathVariable Integer id){
        log.info("GET: /api/v1/users/" + id);
        List<PostUndetailedResponseDTO> posts = service.findAllByUserId(id);
        Response response = new Response(
                true,
                "Posts has been found.",
                posts,
                HttpStatus.OK.value()
        );
        log.info("Posts has been found.");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/users/{id}")
    public ResponseEntity<Response> createPost(@PathVariable Integer id, @RequestBody PostRequest request){
        log.info("POST: /api/v1/users/" + id);
        service.createPost(id, request);
        log.info("Post has been created.");
        Response response = new Response(
                true,
                "Post has been created.",
                null,
                HttpStatus.CREATED.value()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
