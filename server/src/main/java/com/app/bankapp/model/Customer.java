package com.app.bankapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
  @Column(name = "id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer _id;

  @Column(name = "email")
  private String _email;

  @Column(name = "password")
  private String _password;

  public Integer get_id() {
    return this._id;
  }

  public void set_id(Integer _id) {
    this._id = _id;
  }

  public String get_email() {
    return this._email;
  }

  public void set_email(String _email) {
    this._email = _email;
  }

  public String get_password() {
    return this._password;
  }

  public void set_password(String _password) {
    this._password = _password;
  }

  @Override
  public String toString() {
    return (
      "{" +
      " _id='" +
      get_id() +
      "'" +
      ", _email='" +
      get_email() +
      "'" +
      ", _password='" +
      get_password() +
      "'" +
      "}"
    );
  }
}
