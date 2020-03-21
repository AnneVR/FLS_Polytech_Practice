package com.example.demo.controller;


import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    /**
    Get all departments list

    @return department list
     **/
    @GetMapping("/departments")
    public List<Department> getAllDepartments(){
        return  departmentRepository.findAll();
    }

    /**
     * Get info of one Department specified by Id
     *
     * @param departmentId the Id of Department
     * @return specific departmen
     */
    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getDepartmentsById(@PathVariable(value = "id") Long departmentId )
            throws ResourceNotFoundException {
        Department department = departmentRepository
                .findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found on :: " + departmentId));

        return ResponseEntity.ok().body(department);

    }





}
