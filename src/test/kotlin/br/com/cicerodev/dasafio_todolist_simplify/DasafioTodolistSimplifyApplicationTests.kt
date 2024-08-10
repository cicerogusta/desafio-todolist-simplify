package br.com.cicerodev.dasafio_todolist_simplify

import br.com.cicerodev.dasafio_todolist_simplify.entity.Todo
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DasafioTodolistSimplifyApplicationTests {
    @Autowired
    private lateinit var webTestClient: WebTestClient

    @Test
    fun testCreateTodoSuccess() {
        val todo = Todo("todo 1", "desc todo 1", false, 1)

        webTestClient.post()
            .uri("/todos")
            .bodyValue(todo)
            .exchange()
            .expectStatus().isOk.expectBody()
            .jsonPath("$").isArray
            .jsonPath("$.length()").isEqualTo(1)
            .jsonPath("$[0].nome").isEqualTo(todo.nome)
            .jsonPath("$[0].descricao").isEqualTo(todo.descricao)
            .jsonPath("$[0].realizado").isEqualTo(todo.realizado)
            .jsonPath("$[0].prioridade").isEqualTo(todo.prioridade)

    }

    @Test
    fun testCreateTodoFailure() {
        webTestClient.post()
            .uri("/todos")
            .bodyValue(Todo(nome = "", descricao = "", realizado = false, prioridade = 0 ))
            .exchange()
            .expectStatus().isBadRequest

    }

}
