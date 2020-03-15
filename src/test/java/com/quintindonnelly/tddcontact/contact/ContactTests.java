package com.quintindonnelly.tddcontact.contact;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactTests {

  @Test
  public void testConstruction() throws Exception {
    Contact contact = new Contact("Quintin", "Donnelly", "quinndonnelly@gmail.com");
    Assertions.assertThat(contact.getFirstName()).isEqualTo("Quintin");
    Assertions.assertThat(contact.getLastName()).isEqualTo("Donnelly");
    Assertions.assertThat(contact.getEmail()).isEqualTo("quinndonnelly@gmail.com");
  }
}
