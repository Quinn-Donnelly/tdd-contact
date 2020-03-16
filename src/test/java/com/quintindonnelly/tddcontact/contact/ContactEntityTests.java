package com.quintindonnelly.tddcontact.contact;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@DataMongoTest
public class ContactEntityTests {

  @Autowired
  private ReactiveMongoTemplate template;

  @Test
  public void mappingTest() throws Exception {
    Contact contact = new Contact(null, "Quintin", "Donnelly", "quinndonnelly@gmail.com");
    Mono<Contact> save = this.template.save(contact);
    StepVerifier
        .create(save)
        .expectNextMatches(savedContact ->
          savedContact.getId() != null &&
              savedContact.getEmail().equalsIgnoreCase("quinndonnelly@gmail.com") &&
              savedContact.getFirstName().equalsIgnoreCase("Quintin") &&
              savedContact.getLastName().equalsIgnoreCase("Donnelly")
        )
        .verifyComplete();
  }
}
