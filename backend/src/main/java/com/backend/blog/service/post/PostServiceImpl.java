package com.backend.blog.service.post;

import com.backend.blog.dto.post.PostRequest;
import com.backend.blog.dto.post.PostResponseDTO;
import com.backend.blog.dto.post.PostUndetailedResponseDTO;
import com.backend.blog.exception.post.PostNotFoundException;
import com.backend.blog.exception.user.UserNotFoundException;
import com.backend.blog.mapper.PostMapper;
import com.backend.blog.model.Post;
import com.backend.blog.model.User;
import com.backend.blog.repository.PostRepository;
import com.backend.blog.repository.UserRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class PostServiceImpl implements PostService{

    private PostRepository repository;
    private UserRespository userRespository;

    @Autowired
    public PostServiceImpl(PostRepository repository, UserRespository userRespository) {
        this.repository = repository;
        this.userRespository = userRespository;
    }

    @Override
    public void createPost(Integer userId, PostRequest request) {
        User user = userRespository.findById(userId).orElseThrow(() -> {
            log.info("User not found.");
            return new UserNotFoundException();
        });

        Post post = new Post();
        post.setTitle(request.title());
        post.setContent(request.content());
        post.setCreation_date(LocalDateTime.now());
        post.setAuthor(user);
        repository.save(post);
    }

    @Override
    public PostResponseDTO getPostById(Integer id) {
        Post post = repository.findById(id).orElseThrow(() -> {
            log.info("Post not found.");
            return new PostNotFoundException("Post not found");
        });
        return PostMapper.toPostResponseDTO(post);
    }

    @Override
    public List<PostUndetailedResponseDTO> findAllByUserId(Integer userId) {
        List<Post> postsByAuthor = repository.findAllByAuthorId(userId);
        if (postsByAuthor.isEmpty()){
            log.error("Posts not found.");
            throw new PostNotFoundException("Posts not found.");
        }
        return PostMapper.toListPostUndetailedResponseDTO(postsByAuthor);
    }
}
