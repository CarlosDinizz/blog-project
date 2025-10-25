package com.backend.blog.mapper;

import com.backend.blog.dto.post.PostResponseDTO;
import com.backend.blog.dto.post.PostUndetailedResponseDTO;
import com.backend.blog.dto.user.UserUndetailedDTO;
import com.backend.blog.model.Post;
import com.backend.blog.model.User;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class PostMapper {

    public static PostResponseDTO toPostResponseDTO(Post post){
        UserUndetailedDTO userUndetailedDTO = UserMapper.toUserUndetailedDTO(post.getAuthor());
        return new PostResponseDTO(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getCreation_date().toLocalDate(),
                userUndetailedDTO
        );
    }

    public static PostUndetailedResponseDTO toPostUndetailedResponseDTO(Post post){
        return new PostUndetailedResponseDTO(
                post.getId(),
                post.getTitle(),
                post.getContent()
        );
    }

    public static List<PostUndetailedResponseDTO> toListPostUndetailedResponseDTO(List<Post> postsByAuthor) {
        return postsByAuthor.stream().map(PostMapper::toPostUndetailedResponseDTO).toList();
    }

}
