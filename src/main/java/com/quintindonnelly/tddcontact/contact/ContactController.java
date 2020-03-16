package com.quintindonnelly.tddcontact.contact;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class ContactController {
  @Bean
  RouterFunction<ServerResponse> contacts(ContactRepository contactRepository) {
    return route()
        .GET("/contact", serverRequest -> ok().body(contactRepository.findAll(), Contact.class))
        .build();
  }
}
