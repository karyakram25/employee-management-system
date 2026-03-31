package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.EmployeeDto;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.mapper.EmployeeMapper;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;


@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    //Adding logger
    private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    //constructor injection
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Page<EmployeeDto> getAllEmployees(int page, int size, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("asc")?
                Sort.by(sortBy).ascending():
                Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page,size,sort);

        Page<Employee> employees =employeeRepository.findAll(pageable);

        return employees.map(emp->  EmployeeMapper.mapToEmployeeDto(emp));


//        return employeeRepository.findAll()
//                .stream()
//                .map(EmployeeMapper::mapToEmployeeDto)
//                .toList();
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        //Adding Log Info
        log.info("Creating employee with email:{} ",employeeDto.getEmailId());

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        log.info("Employee created with ID :{}", savedEmployee.getId());

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
    @Override
    public EmployeeDto getEmployeeById(Long id) {

        log.info("Yo I am testing log :Fetching employee with ID: {}", id);

         Employee emp=employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id: "+id));
        return EmployeeMapper.mapToEmployeeDto(emp);
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto dto) {

        log.info("Updating employee with ID:{}",id);

        Employee emp = employeeRepository.findById(id)
                .orElseThrow(()-> {
                    log.error("Employee not found with ID: {}", id);    //logging for error
                    return new ResourceNotFoundException("Employee does not exist with id : "+id);
                });

        emp.setFirstName(dto.getFirstName());
        emp.setLastName(dto.getLastName());
        emp.setEmailId(dto.getEmailId());

        Employee updated = employeeRepository.save(emp);

        log.info("Employee not found with ID: {}", id);

        return EmployeeMapper.mapToEmployeeDto(updated);
    }

    @Override
    public void deleteEmployee(Long id) {
        log.info("Deleting employee with ID: {}", id);

        Employee employee= employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id: "+id));
        employeeRepository.delete(employee);

        log.info("Employee deleted with ID: {}",id);
    }
}
