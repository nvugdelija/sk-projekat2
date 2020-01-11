package rs.raf.service1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.raf.service1.domain.User;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    Optional<User> findByEmailAndPassword (String email, String password);

    Optional<User> findByEmail(String email);

}
