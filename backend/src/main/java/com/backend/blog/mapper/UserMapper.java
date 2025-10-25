package com.backend.blog.mapper;

import com.backend.blog.dto.user.UserRequestDTO;
import com.backend.blog.dto.user.UserResponseDTO;
import com.backend.blog.dto.user.UserUndetailedDTO;
import com.backend.blog.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserMapper {

    public User toUser(UserRequestDTO dto){
        User user = new User();
        user.setName(dto.name());
        user.setLastName(dto.last_name());
        user.setPassword(dto.password());
        user.setEmail(dto.email());
        return user;
    }

    public UserResponseDTO toResponseDTO(User user){
        return new UserResponseDTO(
                user.getName(),
                user.getLastName(),
                user.getEmail()
        );
    }

    public static UserUndetailedDTO toUserUndetailedDTO(User user){
        return new UserUndetailedDTO(
                user.getId(),
                user.getName()
        );
    }
}
