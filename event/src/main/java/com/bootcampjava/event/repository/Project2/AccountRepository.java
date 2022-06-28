package com.bootcampjava.event.repository.Project2;

import com.bootcampjava.event.domain.Project2.Account;
import com.bootcampjava.event.domain.Project2.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByDocument(String document);
}
