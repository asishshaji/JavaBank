package com.app.bankapp.model;

import com.app.bankapp.utils.Helpers.Status;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
  @Column(name = "id")
  @Id
  private Integer _id;

  @Column(name = "ownername")
  private String _ownerName;

  @Column(name = "state")
  private String _state;

  @Column(name = "city")
  private String _city;

  @Column(name = "pin")
  private String _pin;

  @Column(name = "created_timestamp")
  private String _createdDateTimeStamp;

  @OneToOne
  @JoinColumn(name = "customer_id", referencedColumnName = "id")
  private Customer customer;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private Status status;

  @Column(name = "balance")
  private Double _balance;

  public Account() {
    this._createdDateTimeStamp =
      new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    this.status = Status.ACTIVE;
  }

  public Integer get_id() {
    return this._id;
  }

  public void set_id(Integer _id) {
    this._id = _id;
  }

  public String get_ownerName() {
    return this._ownerName;
  }

  public void set_ownerName(String _ownerName) {
    this._ownerName = _ownerName;
  }

  public String get_state() {
    return this._state;
  }

  public void set_state(String _state) {
    this._state = _state;
  }

  public String get_city() {
    return this._city;
  }

  public void set_city(String _city) {
    this._city = _city;
  }

  public String get_pin() {
    return this._pin;
  }

  public void set_pin(String _pin) {
    this._pin = _pin;
  }

  public String get_createdDateTimeStamp() {
    return this._createdDateTimeStamp;
  }

  public void set_createdDateTimeStamp(String _createdDateTimeStamp) {
    this._createdDateTimeStamp = _createdDateTimeStamp;
  }

  public Status getStatus() {
    return this.status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Double get_balance() {
    return this._balance;
  }

  public void set_balance(Double _balance) {
    this._balance = _balance;
  }

  @Override
  public String toString() {
    return (
      "{" +
      " _id='" +
      get_id() +
      "'" +
      ", _ownerName='" +
      get_ownerName() +
      "'" +
      ", _state='" +
      get_state() +
      "'" +
      ", _city='" +
      get_city() +
      "'" +
      ", _pin='" +
      get_pin() +
      "'" +
      ", _createdDateTimeStamp='" +
      get_createdDateTimeStamp() +
      "'" +
      "'" +
      ", status='" +
      getStatus() +
      "'" +
      ", _balance='" +
      get_balance() +
      "'" +
      "}"
    );
  }
}
