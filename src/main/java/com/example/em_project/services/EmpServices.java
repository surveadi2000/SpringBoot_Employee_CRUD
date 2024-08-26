package com.example.em_project.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.em_project.Dao.EmployeeEntity;
import com.example.em_project.Repositories.EmployeeRepository;
import com.example.em_project.controllers.Employee;
import com.example.em_project.controllers.EmployeeImp;

@Service
public class EmpServices implements EmployeeImp {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> showemployee() {
        List<EmployeeEntity> entities = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();
        for (EmployeeEntity entity : entities) {
            Employee emp = new Employee();
            BeanUtils.copyProperties(entity, emp);
            employees.add(emp);
        }
        return employees;
    }

    @Override
    public String makeEmployee(Employee emp) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(emp, employeeEntity);
        employeeRepository.save(employeeEntity);
        return "Added Successfully";
    }

    @Override
    public String deleteEmployee(int id) {
        employeeRepository.deleteById((long) id);
        return "Deleted Successfully";
    }

    @Override
    public String updateEmployee(int id, Employee emp) {
        Optional<EmployeeEntity> optionalEntity = employeeRepository.findById((long) id);
        if (optionalEntity.isPresent()) {
            EmployeeEntity employeeEntity = optionalEntity.get();
            BeanUtils.copyProperties(emp, employeeEntity);
            employeeEntity.setId(id);  // Ensure the ID remains the same
            employeeRepository.save(employeeEntity);
            return "Updated Successfully";
        } else {
            return "Employee not found";
        }
    }
}
