package codewithfreddy.SpringSecurity.repository;


import codewithfreddy.SpringSecurity.entity.User;
import codewithfreddy.SpringSecurity.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByEmail(String email);

    User findByRole(Role role);
}
