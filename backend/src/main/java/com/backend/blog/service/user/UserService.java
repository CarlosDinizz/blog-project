package com.backend.blog.service.user;

import com.backend.blog.dto.user.UserRequestDTO;
import com.backend.blog.dto.user.UserResponseDTO;

public interface UserService {

    Integer createUser(UserRequestDTO request);
    UserResponseDTO getUser(Integer id);
}
