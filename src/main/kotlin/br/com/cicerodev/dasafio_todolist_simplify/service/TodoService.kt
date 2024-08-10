package br.com.cicerodev.dasafio_todolist_simplify.service

import org.springframework.stereotype.Service
import org.springframework.data.domain.Sort
import br.com.cicerodev.dasafio_todolist_simplify.entity.Todo
import br.com.cicerodev.dasafio_todolist_simplify.repository.TodoRepository

@Service
class TodoService(private val todoRepository: TodoRepository) {

    fun create(todo: Todo): List<Todo> {
        todoRepository.save(todo)
        return list()

    }

    fun list(): List<Todo> {
       val sort = Sort.by("prioridade").descending().and(Sort.by("nome").ascending()) 
        return todoRepository.findAll(sort)
        
    }

    fun update(todo:Todo): List<Todo> {
        todoRepository.save(todo)
        return list()
        
    }

    fun delete(id: Long): List<Todo> {
        todoRepository.deleteById(id)
        return list()
        
    }

}