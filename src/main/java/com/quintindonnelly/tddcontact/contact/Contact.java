package com.quintindonnelly.tddcontact.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
  String firstName;
  String lastName;
  String email;
}
