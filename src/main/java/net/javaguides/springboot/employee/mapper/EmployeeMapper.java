package net.javaguides.springboot.employee.mapper;

import net.javaguides.springboot.employee.dto.EmployeeDto;
import net.javaguides.springboot.employee.entity.Employee;

public class EmployeeMapper {

    //Mapper converts Entity to DTO
    // INPUT  = Employee (comes from Database)
    // OUTPUT = EmployeeDto (sent to Client)
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmailId(),
                employee.getDepartmentId()
        );
    }

    //Mapper converts DTO to Entity
    // INPUT  = EmployeeDto (comes from Client/API request)
    // OUTPUT = Employee (saved into Database)
    public static Employee mapToEmployee(EmployeeDto dto){
        return new Employee(
                dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmailId(),
                dto.getDepartmentId()
        );
    }
}
