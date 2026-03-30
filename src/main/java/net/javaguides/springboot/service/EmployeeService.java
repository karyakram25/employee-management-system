package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.EmployeeDto;
import net.javaguides.springboot.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> getAllEmployees();

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);

    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDetails);

    void deleteEmployee(Long id);

}
