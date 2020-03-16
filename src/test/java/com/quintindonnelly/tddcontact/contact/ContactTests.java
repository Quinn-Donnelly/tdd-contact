package com.quintindonnelly.tddcontact.contact;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactTests {

  @Test
  public void testConstructionAllArg() throws Exception {
    Contact contact = new Contact(null, "Quintin", "Donnelly", "quinndonnelly@gmail.com");
    Assertions.assertThat(contact.getId()).isEqualTo(null);
    Assertions.assertThat(contact.getFirstName()).isEqualTo("Quintin");
    Assertions.assertThat(contact.getLastName()).isEqualTo("Donnelly");
    Assertions.assertThat(contact.getEmail()).isEqualTo("quinndonnelly@gmail.com");
  }

  @Test
  public void testConstructionNoArg() throws Exception {
    Contact contact = new Contact();
    Assertions.assertThat(contact.getId()).isEqualTo(null);
    Assertions.assertThat(contact.getFirstName()).isEqualTo(null);
    Assertions.assertThat(contact.getLastName()).isEqualTo(null);
    Assertions.assertThat(contact.getEmail()).isEqualTo(null);
  }

  @Test
  public void testGenerateRequiredMethods() throws Exception {
    Contact contact = new Contact();
    Assertions.assertThat(contact.toString()).isNotNull();
    Assertions.assertThat(contact.hashCode()).isNotNull();
  }
}
