package io.github.cursodsousa.arquiteturaspring.todos.repository;

import io.github.cursodsousa.arquiteturaspring.todos.entities.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

    public boolean existsByDescription(String description);
}
