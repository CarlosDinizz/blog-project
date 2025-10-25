package com.backend.blog.service.post;

import com.backend.blog.dto.post.PostRequest;
import com.backend.blog.dto.post.PostResponseDTO;
import com.backend.blog.dto.post.PostUndetailedResponseDTO;

import java.util.List;

public interface PostService {

    void createPost(Integer userId, PostRequest request);
    PostResponseDTO getPostById(Integer id);
    List<PostUndetailedResponseDTO> findAllByUserId(Integer userId);
}
