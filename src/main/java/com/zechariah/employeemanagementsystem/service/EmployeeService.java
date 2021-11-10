package com.zechariah.employeemanagementsystem.service;

import com.zechariah.employeemanagementsystem.model.Employee;

import java.util.List;


public interface EmployeeService {
    public List<Employee> getAllEmployee();
    public void saveEmployee(Employee employee);
    public Employee getEmployeeById(Long id);
    public void deleteEmployeeById(Long id);
}
