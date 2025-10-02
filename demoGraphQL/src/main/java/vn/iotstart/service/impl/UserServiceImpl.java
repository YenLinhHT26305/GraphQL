package vn.iotstart.service.impl;
import vn.iotstart.entity.User;
import vn.iotstart.input.UserInput;
import vn.iotstart.repository.UserRepository;
import vn.iotstart.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

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

