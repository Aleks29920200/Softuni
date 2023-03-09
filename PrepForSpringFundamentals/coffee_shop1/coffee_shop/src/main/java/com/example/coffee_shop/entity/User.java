package com.example.coffee_shop.entity;




import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User extends BaseEntity{
 @Column(nullable = false,unique = true)
 private String username;
 private String firstName;
 @Column(nullable = false)
 private String lastName;

 public String getFirstName() {
  return firstName;
 }

 public void setFirstName(String firstName) {
  this.firstName = firstName;
 }

 public String getLastName() {
  return lastName;
 }

 public void setLastName(String lastName) {
  this.lastName = lastName;
 }

 @Column(nullable = false)
 private String password;
 @Column(nullable = false,unique = true)
 private String  email ;
 public User() {
 }

 public String getUsername() {
  return username;
 }

 public void setUsername(String username) {
  this.username = username;
 }

 public String getPassword() {
  return password;
 }

 public void setPassword(String password) {
  this.password = password;
 }

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }

}
