package vn.iotstart.service;

import java.util.List;
import java.util.Optional;

import vn.iotstart.entity.User;
import vn.iotstart.input.UserInput;
import vn.iotstart.dto.UserDTO;

public interface UserService {
    // Cho GraphQL
    User createUser(UserInput input);
    User updateUser(Long id, UserInput input);
    boolean deleteUser(Long id);
    List<User> findAllUsers();
    Optional<User> findUserById(Long id);

    User create(UserDTO dto);
}
