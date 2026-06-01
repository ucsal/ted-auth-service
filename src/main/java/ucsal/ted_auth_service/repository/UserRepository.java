package ucsal.ted_auth_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ucsal.ted_auth_service.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}