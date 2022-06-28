package com.bootcampjava.event.service.Project2;


import com.bootcampjava.event.domain.Project2.Employee;
import com.bootcampjava.event.mapper.Project2.EmployeeMapper;
import com.bootcampjava.event.model.Project2.EmployeeModel;
import com.bootcampjava.event.repository.Project2.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository employeeRepository ;
    private final EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeModel> findAll() throws Exception {
        List<Employee> list = employeeRepository.findAll();
        return employeeMapper.EmployeesToEmployeeModels(list);
    }

    @Override
    public EmployeeModel findById(Long id) throws Exception {
        Optional<Employee> domain = employeeRepository.findById(id);
        if(domain.isPresent())	return employeeMapper.EmployeeToEmployeeModel(domain.get());
        else throw new Exception("No se encontraron datos");
    }

    @Override
    public EmployeeModel create(EmployeeModel employeeModel) throws Exception {

        Optional<Employee> optional = employeeRepository.findByDocument(employeeModel.getDocument());
        if(optional.isPresent()) {
            throw new Exception("Empleado ya se encuentra registrado");
        } else {
            Employee employee = employeeRepository.save(employeeMapper.EmployeeModelToEmployee(employeeModel));
            return employeeMapper.EmployeeToEmployeeModel(employee);
        }
    }

    @Override
    public void update(Long id, EmployeeModel employeeModel) throws Exception {
        Optional<Employee> optional = employeeRepository.findById(id);

        if(optional.isPresent()) {
            Employee update = optional.get();
            employeeMapper.update(update, employeeModel);
            employeeRepository.save(update);
        }
        else throw new Exception("No se encontraron datos");
    }

    @Override
    public void deleteById(Long id) throws Exception {
        employeeRepository.deleteById(id);
    }
}
