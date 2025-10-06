package vn.iotstart.service.impl;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import vn.iotstart.entity.User;
import vn.iotstart.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy email: " + email));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword()) // mật khẩu mã hoá trong DB
                .authorities(
                	    user.getRoles().stream()
                	        .map(r -> new SimpleGrantedAuthority("ROLE_" + r.name()))
                	        .collect(Collectors.toList())
                	)
                .build();
    }
}
