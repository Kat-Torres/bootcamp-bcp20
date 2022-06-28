package com.bootcampjava.event.mapper.Project2;


import com.bootcampjava.event.domain.Project2.Afp;
import com.bootcampjava.event.domain.Project2.Employee;
import com.bootcampjava.event.model.Project2.AfpModel;
import com.bootcampjava.event.model.Project2.EmployeeModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee EmployeeModelToEmployee (EmployeeModel model);

    EmployeeModel EmployeeToEmployeeModel(Employee domain);

    List<EmployeeModel> EmployeesToEmployeeModels (List<Employee> domains);
    void update(@MappingTarget Employee entity, EmployeeModel updateEntity);


}
