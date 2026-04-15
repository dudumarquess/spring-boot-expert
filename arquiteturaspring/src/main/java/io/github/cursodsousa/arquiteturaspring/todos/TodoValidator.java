package io.github.cursodsousa.arquiteturaspring.todos;

import io.github.cursodsousa.arquiteturaspring.todos.entities.TodoEntity;
import io.github.cursodsousa.arquiteturaspring.todos.repository.TodoRepository;
import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private final TodoRepository todoRepository;

    public TodoValidator(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public boolean validate(TodoEntity todoEntity) {
        if (todoEntity.getDescription() == null || todoEntity.getDescription().isBlank()) {
            throw new IllegalArgumentException("Description cannot be null or blank");
        }
        if (todoRepository.existsByDescription(todoEntity.getDescription())) {
            throw new IllegalArgumentException("Todo with description " + todoEntity.getDescription() + " already exists");
        }
        return true;
    }
}
