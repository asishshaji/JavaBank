package com.app.bankapp.controller;

import com.app.bankapp.model.Account;
import com.app.bankapp.service.BankService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bank/")
public class BankController {
  @Autowired
  private BankService bankService;

  @GetMapping("/accounts")
  public List<Account> getAccounts() {
    return bankService.getAccounts();
  }

  @GetMapping("")
  public Map<String, String> sayHi() {
    System.out.println("ASD");
    Map<String, String> map = new HashMap<>();
    map.put("email", "uEm");
    return map;
  }
}
