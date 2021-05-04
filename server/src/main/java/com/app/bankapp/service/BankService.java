package com.app.bankapp.service;

import com.app.bankapp.model.Account;
import com.app.bankapp.repository.BankRepo;
import java.util.List;
import java.util.Optional;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService implements IBankService {
  @Autowired
  private BankRepo bankRepo;

  @Override
  public Account createAccount(Account account) {
    return bankRepo.save(account);
  }

  @Override
  public Account updateAccount(Account account) {
    return null;
  }

  @Override
  public Account depositIntoAccount(Double amountToDeposit) {
    return null;
  }

  @Override
  public Account withdrawFromAccount(Double amountToWithdraw) {
    return null;
  }

  @Override
  public List<Account> getAccounts() {
    return bankRepo.findAll();
  }

  @Override
  public Account getAccount(int id) {
    try {
      Optional<Account> e = bankRepo.findById(id);
      Account account = e.get();
      return account;
    } catch (NoResultException e) {
      e.printStackTrace();
      return null;
    }
  }
}
