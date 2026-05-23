package net.javaguides.springboot.department.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.department.dto.DepartmentDto;
import net.javaguides.springboot.department.mapper.DepartmentMapper;
import net.javaguides.springboot.department.entity.Department;
import net.javaguides.springboot.department.repository.DepartmentRepository;
import net.javaguides.springboot.department.service.DepartmentService;
import net.javaguides.springboot.common.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department= DepartmentMapper.mapToDepartment(departmentDto);

        Department saved=repository.save(department);

        return DepartmentMapper.mapToDepartmentDto(saved);
    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        Department department= repository.findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("Department not found")
        );
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        return repository.findAll()
                .stream()
                .map(DepartmentMapper::mapToDepartmentDto)
                .toList();
    }
}
