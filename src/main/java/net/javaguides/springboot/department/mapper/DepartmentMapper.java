package net.javaguides.springboot.department.mapper;

import net.javaguides.springboot.department.dto.DepartmentDto;
import net.javaguides.springboot.department.entity.Department;

public class DepartmentMapper {

    public static DepartmentDto mapToDepartmentDto(Department department){
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentCode(),
                department.getDepartmentDescription()
        );
    }

    public static Department mapToDepartment(DepartmentDto dto){
        return new Department(
                dto.getId(),
                dto.getDepartmentName(),
                dto.getDepartmentCode(),
                dto.getDepartmentDescription()
        );
    }
}
