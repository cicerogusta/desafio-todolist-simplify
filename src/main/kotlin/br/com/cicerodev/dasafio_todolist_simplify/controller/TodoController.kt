package br.com.cicerodev.desafio_todolist_simplify.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import br.com.cicerodev.desafio_todolist_simplify.service.TodoService
import br.com.cicerodev.dasafio_todolist_simplify.entity.Todo

@RestController
@RequestMapping("/todos")
class TodoController(private val todoService:TodoService) {

    fun create(todo: Todo): List<Todo> {
        todoService.create(todo)
        return list()

    }

    fun list(): List<Todo> {
       
        return todoService.list()
        
    }

    fun update(todo:Todo): List<Todo> {
       todoService.update(todo)
        return list()
        
    }

    fun delete(id: Long): List<Todo> {
        todoService.delete(id)
        return list()
        
    }

}