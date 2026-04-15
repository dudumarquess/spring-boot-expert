package io.github.cursodsousa.arquiteturaspring.todos.service;

import io.github.cursodsousa.arquiteturaspring.todos.MailSender;
import io.github.cursodsousa.arquiteturaspring.todos.TodoValidator;
import io.github.cursodsousa.arquiteturaspring.todos.dto.TodoDto;
import io.github.cursodsousa.arquiteturaspring.todos.entities.TodoEntity;
import io.github.cursodsousa.arquiteturaspring.todos.repository.TodoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final TodoValidator todoValidator;
    private final MailSender mailSender;

    public TodoService(TodoRepository todoRepository, TodoValidator todoValidator, MailSender mailSender) {
        this.todoRepository = todoRepository;
        this.todoValidator = todoValidator;
        this.mailSender = mailSender;
    }

    public TodoDto save(TodoDto todoDto) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setDescription(todoDto.description());
        if (todoDto.done() == null) {
            todoEntity.setDone(false);
        } else {
            todoEntity.setDone(todoDto.done());
        }
        todoValidator.validate(todoEntity);
        TodoEntity savedEntity = todoRepository.save(todoEntity);

        return new TodoDto(savedEntity.getId(), savedEntity.getDescription(), savedEntity.getDone());
    }


    public TodoDto updateTodoStatus(Long id) {
        TodoEntity todoEntity = todoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        todoEntity.setDone(!todoEntity.getDone());
        TodoEntity savedEntity = todoRepository.save(todoEntity);
        return new TodoDto(savedEntity.getId(), savedEntity.getDescription(), savedEntity.getDone());
    }
}
