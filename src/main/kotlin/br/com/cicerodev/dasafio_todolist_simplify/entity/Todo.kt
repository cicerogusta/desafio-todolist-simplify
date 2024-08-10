package br.com.cicerodev.dasafio_todolist_simplify.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "todos")
class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @field:NotBlank
    var nome: String = "",
    @field:NotBlank
    var descricao: String = "",
    var realizado: Boolean = false,
    var prioridade: Int = 0
) {

    constructor(nome: String, descricao: String, realizado: Boolean, prioridade: Int) : this(
        0,
        nome,
        descricao,
        realizado,
        prioridade
    )
}
