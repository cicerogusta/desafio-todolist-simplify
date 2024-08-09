package br.com.cicerodev.repository

import br.com.cicerodev.dasafio_todolist_simplify.entity.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<Todo, Long>