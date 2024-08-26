package com.example.em_project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllers {

    @Autowired
    private EmployeeImp employee;

    @GetMapping("employee")
    public List<Employee> getAllEmployees() {
        return employee.showemployee();
    }

    @PostMapping("employee")
    public String postAllEmployees(@RequestBody Employee emp) {
        return employee.makeEmployee(emp);
    }

    @DeleteMapping("employee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return employee.deleteEmployee(id);
    }

    @PutMapping("employee/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee emp) {
        return employee.updateEmployee(id, emp);
    }
}
