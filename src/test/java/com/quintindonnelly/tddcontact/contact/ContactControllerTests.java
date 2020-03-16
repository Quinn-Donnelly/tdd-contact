package com.quintindonnelly.tddcontact.contact;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

@WebFluxTest(ContactController.class)
public class ContactControllerTests {

  @MockBean
  private ContactRepository contactRepository;

  @Autowired
  private WebTestClient client;

  @Test
  public void routes() throws Exception {
    Mockito.when(this.contactRepository.findAll())
        .thenReturn(Flux.just(
            new Contact("1", "Quintin", "Donnelly", "quinndonnelly@gmail.com"),
            new Contact("2", "Tisha", "Ooppapan", "tisha@gmail.com")
        ));

    this.client
        .get()
        .uri("/contact")
        .exchange()
        .expectStatus().isOk()
        .expectHeader().contentType(MediaType.APPLICATION_JSON)
        .expectBody().jsonPath("@.[0].firstName").isEqualTo("Quintin");
  }
}
