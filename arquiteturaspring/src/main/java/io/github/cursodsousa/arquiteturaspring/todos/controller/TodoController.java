package io.github.cursodsousa.arquiteturaspring.todos.controller;

import io.github.cursodsousa.arquiteturaspring.todos.dto.TodoDto;
import io.github.cursodsousa.arquiteturaspring.todos.service.TodoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public TodoDto createTodo(@RequestBody TodoDto todoDto) {
        return todoService.save(todoDto);
    }

    @PostMapping("update/{id}")
    public TodoDto updateTodoStatus(@PathVariable Long id) {
        try {
             return todoService.updateTodoStatus(id);
         } catch (EntityNotFoundException e) {
            return new TodoDto(id, "Todo não encontrado", false);
        } catch (Exception e) {
             return new TodoDto(id, "Erro ao atualizar status", false);
         }
    }
}
