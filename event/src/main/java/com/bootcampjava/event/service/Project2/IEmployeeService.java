package com.bootcampjava.event.service.Project2;

import com.bootcampjava.event.model.Project2.EmployeeModel;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeModel> findAll() throws Exception;

    EmployeeModel findById(Long id) throws Exception;

    EmployeeModel create(EmployeeModel employeeModel) throws Exception;

    void update(Long id, EmployeeModel employeeModel) throws Exception;

    void deleteById(Long id) throws Exception;
}
