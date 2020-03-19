package io.indreams.libraryportal.service;

import io.indreams.libraryportal.model.UserDTO;
import io.indreams.libraryportal.model.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity getUser(String userName);
    List<UserEntity> getAllUsers();
    void addUser(UserDTO userDTO);
}
