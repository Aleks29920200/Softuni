package com.example.springfundamentalsexam.domain.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User extends BaseEntity {
 @Column(nullable = false,unique = true)
 private String username;
 @Column(nullable = false)
 private String password;
 @Column(nullable = false,unique = true)
 private String  email ;
 @OneToMany(fetch = FetchType.EAGER)
 private List<Offer> offers;
 @OneToMany(fetch = FetchType.EAGER)
 private List<Offer> boughtOffers;
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


 public List<Offer> getOffers() {
  return offers;
 }

 public void setOffers(List<Offer> offers) {
  this.offers = offers;
 }

 public List<Offer> getBoughtOffers() {
  return boughtOffers;
 }

 public void setBoughtOffers(List<Offer> boughtOffers) {
  this.boughtOffers = boughtOffers;
 }
}
