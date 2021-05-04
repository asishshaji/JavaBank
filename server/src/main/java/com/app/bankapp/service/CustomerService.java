package com.app.bankapp.service;

import com.app.bankapp.error.UserExists;
import com.app.bankapp.model.Customer;
import com.app.bankapp.repository.CustomerRepo;
import com.app.bankapp.utils.Helpers;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService, UserDetailsService {
  @Autowired
  private CustomerRepo customerRepo;

  @Override
  public Customer createCustomer(Customer customer) {
    if (
      customer.get_password().length() > 6 &&
      Helpers.isEmailValid(customer.get_email())
    ) {
      if (customerRepo.findCustomerByEmail(customer.get_email()) != null) {
        throw new UserExists("User already exists");
      }
      return customerRepo.save(customer);
    } else {
      return null;
    }
  }

  @Override
  public Customer getCustomerByEmail(String email) {
    return customerRepo.findCustomerByEmail(email);
  }

  @Override
  public UserDetails loadUserByUsername(String username)
    throws UsernameNotFoundException {
    Customer customer = customerRepo.findCustomerByEmail(username);
    System.out.println(
      new User(customer.get_email(), customer.get_password(), new ArrayList<>())
      .toString()
    );
    return new User(
      customer.get_email(),
      customer.get_password(),
      new ArrayList<>()
    );
  }
}
