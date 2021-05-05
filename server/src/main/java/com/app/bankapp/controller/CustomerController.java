package com.app.bankapp.controller;

import com.app.bankapp.model.Account;
import com.app.bankapp.model.Customer;
import com.app.bankapp.service.BankService;
import com.app.bankapp.service.CustomerService;
import com.app.bankapp.utils.Helpers;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer/")
public class CustomerController {
  @Autowired
  private CustomerService _customerService;

  @Autowired
  private BankService bankService;

  @PostMapping("/register")
  public Map<String, String> createNewCustomer(@RequestBody Customer customer) {
    Map<String, String> msg = new HashMap<>();

    if (_customerService.createCustomer(customer) != null) {
      msg.put("message", "Created user");
      return msg;
    }
    return msg;
  }

  @PostMapping("/login")
  public Map<String, String> loginUser(@RequestBody Customer customer) {
    Map<String, String> msg = new HashMap<>();

    if (_customerService.getCustomerByEmail(customer.get_email()) != null) {
      msg.put("token", Helpers.getJWTToken(customer.get_email()));
      return msg;
    } else return msg;
  }

  @PostMapping("/create")
  public Map<String, String> createAccount(
    @RequestHeader("authorization") String jwtToken,
    @RequestBody Account account
  ) {
    System.out.println(account.toString());
    String uEmail = Helpers.parseJWT(jwtToken);

    Customer customer = _customerService.getCustomerByEmail(uEmail);

    Map<String, String> msg = new HashMap<>();

    account.setCustomer(customer);
    account.set_id(customer.get_id());
    account.set_balance(0.0);

    Account rAccount = bankService.createAccount(account);

    if (rAccount != null) msg.put("message", "Successfully created account");
    return msg;
  }

  @GetMapping("/profile")
  public Customer getProfile(@RequestHeader("authorization") String jwtToken) {
    String uEmail = Helpers.parseJWT(jwtToken);
    Customer customer = _customerService.getCustomerByEmail(uEmail);

    return customer;
  }

  @GetMapping("/account")
  public Account getAccount(@RequestHeader("authorization") String jwtToken) {
    String uEmail = Helpers.parseJWT(jwtToken);
    Customer customer = _customerService.getCustomerByEmail(uEmail);

    Account account = bankService.getAccount(customer.get_id());

    System.out.println(account);

    return account;
  }

  @GetMapping("")
  public Map<String, String> sayHi() {
    Map<String, String> map = new HashMap<>();
    map.put("email", "uEm");
    return map;
  }
}
