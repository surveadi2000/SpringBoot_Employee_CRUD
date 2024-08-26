package com.example.em_project.controllers;

import java.util.List;

public interface EmployeeImp {
    
    public List<Employee> showemployee();
    public String makeEmployee(Employee emp);
    public String deleteEmployee(int  id);
    public String updateEmployee(int id, Employee emp);
}
