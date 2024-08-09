
package br.com.cicerodev.dasafio_todolist_simplify.entity
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import org.springframework.data.annotation.Id
@Entity
@Table(name="todos")
data class Todo(
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long;
    var nome: String = ""
    var descricao: String = ""
    var realizado: Boolean = false
    var prioridade: Int = 0
)

