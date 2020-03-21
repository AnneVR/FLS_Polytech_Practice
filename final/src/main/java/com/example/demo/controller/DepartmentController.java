package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
//@CrossOrigin(origins = "http//localhost:5432")
@RequestMapping("/api/v1")
public class DepartmentController {

    @Autowired
    DepartmentRepository departmentRepository;

    /**
     * Get all departments list.
     *
     * @return the list
     */
    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    /**
     * Gets users by id.
     *
     * @param departmentId the user id
     * @return the users by id
     */
    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getUsersById(@PathVariable(value = "id") Long departmentId)
            throws ResourceNotFoundException {
        Department department =
                departmentRepository
                        .findById(departmentId)
                        .orElseThrow(() -> new ResourceNotFoundException("Department not found on :: " + departmentId));
        return ResponseEntity.ok().body(department);
    }




}
