package com.zechariah.employeemanagementsystem.controller;

import com.zechariah.employeemanagementsystem.model.Employee;
import com.zechariah.employeemanagementsystem.service.EmployeeServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeServiceImplement employeeServiceImplement;

    @GetMapping("/")
    public String getAllEmployee(Model model){
        model.addAttribute("listEmployees", employeeServiceImplement.getAllEmployee());
        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@Valid @ModelAttribute ("employee") Employee employee){
        employeeServiceImplement.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateEmployee(@Valid @PathVariable Long id, Model model){
        Employee employee = employeeServiceImplement.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeServiceImplement.deleteEmployeeById(id);
        return "redirect:/";
    }
}
