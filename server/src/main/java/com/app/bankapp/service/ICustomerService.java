package com.app.bankapp.service;

import com.app.bankapp.model.Customer;

public interface ICustomerService {
  public Customer createCustomer(Customer customer);

  public Customer getCustomerByEmail(String email);
}
