package vn.iotstar.service;

import vn.iotstar.entity.User;
import vn.iotstar.input.UserInput;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(UserInput input);
    User updateUser(Long id, UserInput input);
    boolean deleteUser(Long id);
    List<User> findAllUsers();
    Optional<User> findUserById(Long id);
}