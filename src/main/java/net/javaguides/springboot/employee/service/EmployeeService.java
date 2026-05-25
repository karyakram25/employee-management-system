package net.javaguides.springboot.employee.service;

import net.javaguides.springboot.employee.dto.APIResponseDto;
import net.javaguides.springboot.employee.dto.EmployeeDto;
import org.springframework.data.domain.Page;

public interface EmployeeService {

    Page<EmployeeDto> getAllEmployees(int page, int size, String sortBy, String sortDir);

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);

    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDetails);

    void deleteEmployee(Long id);

    APIResponseDto getEmployeeWithDepartment(Long employeeId);

}
