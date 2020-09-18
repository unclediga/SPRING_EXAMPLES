package ru.unclediga.letscode.repo;

import org.springframework.data.repository.CrudRepository;
import ru.unclediga.letscode.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
