package com.ing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String>{

}
