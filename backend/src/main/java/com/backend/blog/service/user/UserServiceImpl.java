package com.backend.blog.service.user;

import com.backend.blog.dto.user.UserRequestDTO;
import com.backend.blog.dto.user.UserResponseDTO;
import com.backend.blog.mapper.UserMapper;
import com.backend.blog.model.User;
import com.backend.blog.repository.UserRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRespository respository;

    @Autowired
    public UserServiceImpl(UserRespository respository){
        this.respository = respository;
    }

    @Override
    public Integer createUser(UserRequestDTO request) {

        if (!request.password().equals(request.confirm_password())){
            log.error("Password does not matches.");
            throw new RuntimeException("The password doesn't matches.");
        }

        UserMapper mapper = new UserMapper();

        User user = mapper.toUser(request);

        user = respository.save(user);
        return user.getId();
    }

    @Override
    public UserResponseDTO getUser(Integer id) {
        User user = respository.findById(id).orElseThrow(() -> {
            log.error("User not found.");
            return new RuntimeException("User not found.");
        });

        UserMapper mapper = new UserMapper();

        return mapper.toResponseDTO(user);
    }
}
