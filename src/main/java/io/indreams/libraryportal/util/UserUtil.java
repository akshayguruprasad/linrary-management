package io.indreams.libraryportal.util;

import io.indreams.libraryportal.model.UserDAO;
import io.indreams.libraryportal.model.UserDTO;
import io.indreams.libraryportal.model.UserEntity;

import java.util.Optional;

public class UserUtil {
    public static UserEntity getUserEntity(UserDAO userDao) {
        UserEntity userEntity = null;
        if (userDao.isActive()) {
            userEntity = new UserEntity();
            userEntity.setAge(userDao.getAge());
            userEntity.setBloodType(userDao.getBloodType());
            userEntity.setFirstName(userDao.getFirstName());
            userEntity.setLastName(userDao.getLastName());
            userEntity.setUserName(userDao.getUserName());

        }
        return userEntity;
    }

    public static UserDAO getUserDAO(UserDTO userDTO) {
        UserDAO userDAO = new UserDAO();
        userDAO.setAge(userDTO.getAge());
        userDAO.setBloodType(userDTO.getBloodType());
        userDAO.setContactNumber(userDTO.getContactNumber());
        userDAO.setEmailId(userDTO.getEmailId());
        userDAO.setFirstName(userDTO.getFirstName());
        userDAO.setLastName(userDTO.getLastName());
        userDAO.setUserName(userDTO.getUserName());
        return userDAO;
    }
}
