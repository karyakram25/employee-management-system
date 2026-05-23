package net.javaguides.springboot.department.controller;

import lombok.RequiredArgsConstructor;
import net.javaguides.springboot.department.dto.DepartmentDto;
import net.javaguides.springboot.department.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService service;

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto dto){

    return new ResponseEntity<>(service.createDepartment(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Long id){
        return ResponseEntity.ok(service.getDepartmentById(id));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        return ResponseEntity.ok(service.getAllDepartments());
    }
}
