package vn.iotstart.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import vn.iotstart.entity.User;
import vn.iotstart.input.UserInput;
import vn.iotstart.dto.UserDTO;
import vn.iotstart.repository.UserRepository;
import vn.iotstart.security.Role;
import vn.iotstart.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // ==================== CRUD cho GraphQL ====================

    @Override
    public User createUser(UserInput input) {
        User user = new User();
        user.setFullname(input.getFullname());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setPhone(input.getPhone());
        user.getRoles().add(Role.USER);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, UserInput input) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy user có id=" + id));
        user.setFullname(input.getFullname());
        user.setEmail(input.getEmail());
        user.setPhone(input.getPhone());
        if (input.getPassword() != null && !input.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(input.getPassword()));
        }
        return userRepository.save(user);
    }

    @Override
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    // ==================== Tích hợp cho Thymeleaf ====================

    /** Tạo user từ form nhập liệu (UserDTO) */
    public User create(UserDTO dto) {
        User user = new User();
        user.setFullname(dto.getFullname());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setPhone(dto.getPhone());
        user.getRoles().add(Role.USER);
        return userRepository.save(user);
    }
}
