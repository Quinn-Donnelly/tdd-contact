package com.quintindonnelly.tddcontact.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Contact {
  @Id
  String id;
  String firstName;
  String lastName;
  String email;
}
