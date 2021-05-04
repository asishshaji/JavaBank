package com.app.bankapp.repository;

import com.app.bankapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
  @Query("Select c from Customer c where c._email = :email")
  Customer findCustomerByEmail(@Param("email") String email);
}
