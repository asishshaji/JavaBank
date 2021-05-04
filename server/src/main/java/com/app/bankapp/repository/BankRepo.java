package com.app.bankapp.repository;

import com.app.bankapp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
public interface BankRepo extends JpaRepository<Account, Integer> {}
