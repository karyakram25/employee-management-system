package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.EmployeeDto;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.mapper.EmployeeMapper;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    //constructor injection
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeMapper::mapToEmployeeDto)
                .toList();
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
    @Override
    public EmployeeDto getEmployeeById(Long id) {
         Employee emp=employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id: "+id));
        return EmployeeMapper.mapToEmployeeDto(emp);
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto dto) {
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id : "+id));

        emp.setFirstName(dto.getFirstName());
        emp.setLastName(dto.getLastName());
        emp.setEmailId(dto.getEmailId());

        Employee updated = employeeRepository.save(emp);

        return EmployeeMapper.mapToEmployeeDto(updated);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee= employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id: "+id));
        employeeRepository.delete(employee);
    }
}
