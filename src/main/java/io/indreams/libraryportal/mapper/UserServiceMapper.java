package io.indreams.libraryportal.mapper;

import io.indreams.libraryportal.exception.InvalidUserException;
import io.indreams.libraryportal.model.UserDAO;
import io.indreams.libraryportal.model.UserDTO;
import io.indreams.libraryportal.model.UserEntity;
import io.indreams.libraryportal.repository.UserRepository;
import io.indreams.libraryportal.util.Constants;
import io.indreams.libraryportal.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserServiceMapper {

    @Autowired
    private UserRepository userRepository;

    public UserEntity getUser(String userName) {
        UserEntity userEntity = null;
        Optional<UserDAO> user = userRepository.findUserDAOByUserName(userName);
        if (user.isPresent()) {
            UserDAO userDao = user.get();
            userEntity = UserUtil.getUserEntity(userDao);
        }
        return userEntity;
    }

    public List<UserEntity> getAllUsers() {
        List<UserEntity> userEntityList = new ArrayList<UserEntity>();
        Iterable<UserDAO> result = userRepository.findAll();
//        result.forEach();
        return userEntityList;
    }

    public void addUser(UserDTO userDTO) {
        Optional<UserDAO> user = userRepository.findUserDAOByContactNumber(userDTO.getContactNumber());
        if (user.isPresent())
            throw new InvalidUserException(Constants.USER_ALERADY_EXISTS);
        Optional<UserDAO> userForName = userRepository.findUserDAOByUserName(userDTO.getUserName());
        if(userForName.isPresent()){
            throw new InvalidUserException(Constants.USERNAME_EXISTS);
        }
        UserDAO userDao = UserUtil.getUserDAO(userDTO);
        userRepository.save(userDao);
    }
}
