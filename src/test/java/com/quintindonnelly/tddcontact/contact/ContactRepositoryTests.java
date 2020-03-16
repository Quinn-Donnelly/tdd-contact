package com.quintindonnelly.tddcontact.contact;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@DataMongoTest
public class ContactRepositoryTests {

  @Autowired
  private ContactRepository contactRepository;

  @Test
  public void getContactByFirstNameWithoutLastName() throws Exception {
    Flux<Contact> contactFlux = this.contactRepository.deleteAll().thenMany(
        Flux.just("Quintin Donnelly quinndonnelly@gmail.com", "Tisha Ooppapan tisha@gmail.com")
            .map(information -> {
              String[] args = information.split(" ");
              return new Contact(null, args[0], args[1], args[2]);
            }).flatMap(this.contactRepository::save)
    ).thenMany(this.contactRepository.findAllByFirstNameOrLastName("Quintin", null));


    StepVerifier
        .create(contactFlux)
        .expectNextCount(1)
        .verifyComplete();
  }

  @Test
  void getContactByLastNameWithoutFirstName() throws Exception {
    Flux<Contact> contactFlux = this.contactRepository.deleteAll().thenMany(
        Flux.just("Quintin Donnelly quinndonnelly@gmail.com", "Tisha Ooppapan tisha@gmail.com")
            .map(information -> {
              String[] args = information.split(" ");
              return new Contact(null, args[0], args[1], args[2]);
            }).flatMap(this.contactRepository::save)
            .thenMany(this.contactRepository.findAllByFirstNameOrLastName(null, "Donnelly")));

    StepVerifier
        .create(contactFlux)
        .expectNextCount(1)
        .verifyComplete();
  }


}
