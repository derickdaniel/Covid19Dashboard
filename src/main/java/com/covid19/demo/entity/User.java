package com.covid19.demo.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "user_info")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class User {
  
  @Id
  @GeneratedValue
  private UUID id;
  
  @Column(name = "first_name")
  private String firstName;
  
  @Column(name = "last_name")
  private String lastName;
  
  private String password;
  
  private String email;
  
}