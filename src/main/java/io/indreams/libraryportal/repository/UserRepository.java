package io.indreams.libraryportal.repository;

import io.indreams.libraryportal.model.UserDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserDAO,String> {

    Optional<UserDAO> findUserDAOByUserName(String userName);

    Optional<UserDAO> findUserDAOByContactNumber(String contactNumber);
}
