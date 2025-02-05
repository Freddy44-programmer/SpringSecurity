package codewithfreddy.SpringSecurity.service.impl;



import codewithfreddy.SpringSecurity.repository.UserRepository;
import codewithfreddy.SpringSecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImp  implements UserService {

    private  final UserRepository userRepository;


        @Override
        public UserDetailsService userDetailsService() {
            return username -> userRepository.findByEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        };
    }

