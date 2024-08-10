
package br.com.cicerodev.dasafio_todolist_simplify.entity
import jakarta.persistence.*

@Table(name="todos")
@Entity
data class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    var nome: String = "",
    var descricao: String = "",
    var realizado: Boolean = false,
    var prioridade: Int = 0
) {
    constructor(nome: String, descricao: String, realizado: Boolean, prioridade: Int) : this(0, nome, descricao, realizado, prioridade)


}

