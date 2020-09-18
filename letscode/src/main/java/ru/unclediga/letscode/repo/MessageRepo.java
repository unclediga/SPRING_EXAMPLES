package ru.unclediga.letscode.repo;

import org.springframework.data.repository.CrudRepository;
import ru.unclediga.letscode.domain.Message;

public interface MessageRepo extends CrudRepository<Message, Long> {
}
