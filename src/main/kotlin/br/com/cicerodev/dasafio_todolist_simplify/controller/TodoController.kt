package br.com.cicerodev.dasafio_todolist_simplify.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import br.com.cicerodev.dasafio_todolist_simplify.service.TodoService
import br.com.cicerodev.dasafio_todolist_simplify.entity.Todo

@RestController
@RequestMapping("/todos")
class TodoController(private val todoService: TodoService) {

    @PostMapping
    fun create(@RequestBody todo: Todo): List<Todo> {
        todoService.create(todo)
        return list()

    }

    @GetMapping
    fun list(): List<Todo> {
       
        return todoService.list()
        
    }
    
    @PutMapping
    fun update(@RequestBody todo:Todo): List<Todo> {
       todoService.update(todo)
        return list()
        
    }

    @DeleteMapping("{id}")
    fun delete( @PathVariable("id") id: Long): List<Todo> {
        todoService.delete(id)
        return list()
        
    }

}