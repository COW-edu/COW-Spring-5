package practice.crudapi.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.crudapi.user.entity.User;

import java.util.List;

public interface JpaUserRepository extends JpaRepository<User, Long> {
    List<User> findByUsername(String username);
}
