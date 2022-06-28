package com.bootcampjava.event.repository.Project2;

import com.bootcampjava.event.domain.Project2.Account;
import com.bootcampjava.event.domain.Project2.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Account> findByDocument(String document);
}
