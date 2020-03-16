package com.quintindonnelly.tddcontact.contact;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ContactRepository extends ReactiveMongoRepository<Contact, String> {
  Flux<Contact> findAllByFirstNameOrLastName(String firstName, String lastName);
}
