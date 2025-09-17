package com.ftms.Service;

import com.ftms.DTO.UserRequestDTO;
import com.ftms.DTO.UserResponseDTO;
import com.ftms.Mapper.UserMapper;
import com.ftms.Repo.UserRepo;
import com.ftms.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    public UserService(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    public UserResponseDTO saveUser(UserRequestDTO userRequestDTO) {
        User user = userMapper.toEntity(userRequestDTO);
        User savedUser = userRepo.save(user);
        return userMapper.toDTO(savedUser);
    }
    
    public List<User> fetchAllUser() {
        List<User> userList = userRepo.findAll();
        return userList;
    }
}
