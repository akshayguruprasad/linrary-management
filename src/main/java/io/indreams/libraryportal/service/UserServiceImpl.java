package io.indreams.libraryportal.service;

import io.indreams.libraryportal.exception.InvalidUserException;
import io.indreams.libraryportal.mapper.UserServiceMapper;
import io.indreams.libraryportal.model.UserDTO;
import io.indreams.libraryportal.model.UserEntity;
import io.indreams.libraryportal.util.Constants;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserServiceMapper userServiceMapper;

    @Override
    public UserEntity getUser(String userName) {
        UserEntity user = userServiceMapper.getUser(userName);
        if (user == null)
            throw new InvalidUserException(Constants.INVALID_USER_EXCEPTION);
        return user;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userServiceMapper.getAllUsers();
    }

    @Override
    public void addUser(UserDTO userDTO) {
        userServiceMapper.addUser(userDTO);
    }
}
