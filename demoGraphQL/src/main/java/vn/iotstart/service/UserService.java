package vn.iotstart.service;

import java.util.List;
import java.util.Optional;
import vn.iotstart.entity.User;
import vn.iotstart.input.UserInput;

public interface UserService {
    User createUser(UserInput input);
    User updateUser(Long id, UserInput input);
    boolean deleteUser(Long id);
    List<User> findAllUsers();
    Optional<User> findUserById(Long id);
}
