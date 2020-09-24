package ru.unclediga.letscode.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.unclediga.letscode.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
    public User findByUsername(String username);
}
