package com.zechariah.employeemanagementsystem.service;

import com.zechariah.employeemanagementsystem.model.Employee;
import com.zechariah.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplement  implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
            employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Employee employee = null;
        if (optionalEmployee.isPresent()){
            employee = optionalEmployee.get();
        } else {
            throw new RuntimeException ("Employee Not Found with Id ::" + id);
        }
        return employee;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

}
