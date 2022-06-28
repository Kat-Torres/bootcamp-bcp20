package com.bootcampjava.event.bootstrap;


import com.bootcampjava.event.repository.Project2.AccountRepository;
import com.bootcampjava.event.repository.Project2.AfpRepository;
import com.bootcampjava.event.repository.Project2.EmployeeRepository;
import com.bootcampjava.event.repository.Project2.RequestRepository;
import org.springframework.boot.CommandLineRunner;

public class BootStrapData implements CommandLineRunner {

    public BootStrapData(AfpRepository afpRepository) {
        super();

    }

    public BootStrapData(EmployeeRepository employeeRepository) {
        super();

    }

    public BootStrapData(AccountRepository accountRepository) {
        super();

    }

    public BootStrapData(RequestRepository requestRepository) {
        super();

    }

    @Override
    public void run(String... args) throws Exception {

    }
}
