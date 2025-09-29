package vn.iotstar.service.impl;

import vn.iotstar.entity.User;
import vn.iotstar.input.UserInput;
import vn.iotstar.repository.UserRepository;
import vn.iotstar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(UserInput input) {
        User user = new User();
        user.setFullname(input.getFullname());
        user.setEmail(input.getEmail());
        user.setPassword(input.getPassword());
        user.setPhone(input.getPhone());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, UserInput input) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (input.getFullname() != null) user.setFullname(input.getFullname());
            if (input.getEmail() != null) user.setEmail(input.getEmail());
            if (input.getPassword() != null) user.setPassword(input.getPassword());
            if (input.getPhone() != null) user.setPhone(input.getPhone());
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }
}