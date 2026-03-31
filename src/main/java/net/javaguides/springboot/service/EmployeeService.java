package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.EmployeeDto;
import net.javaguides.springboot.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {

    Page<EmployeeDto> getAllEmployees(int page, int size, String sortBy, String sortDir);

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);

    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDetails);

    void deleteEmployee(Long id);

}
