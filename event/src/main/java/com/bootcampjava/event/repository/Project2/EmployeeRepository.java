package com.bootcampjava.event.repository.Project2;
import com.bootcampjava.event.domain.Project2.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByDocument(String document);
}
