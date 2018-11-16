package com.codegym.employee.controller;

import com.codegym.employee.model.Employee;
import com.codegym.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ModelAndView listEmployees(@RequestParam("s") Optional<String> s, Pageable pageable) {
        Page<Employee> employees;
        if(s.isPresent()) {
            employees = employeeService.findAllByFullNameContaining(s.get(), pageable);
        } else {
            employees = employeeService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("views/list");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("/create-employee")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("views/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/create-employee")
    public ModelAndView saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("views/create");
        if(bindingResult.hasFieldErrors()) {
            return modelAndView;
        }else {
            employeeService.save(employee);
            modelAndView.addObject("employee", employee);
            modelAndView.addObject("message", "A new employee was created");
            return modelAndView;
        }
    }

    @GetMapping("/edit-employee/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        if(employee != null) {
            ModelAndView modelAndView = new ModelAndView("views/edit");
            modelAndView.addObject("employee", employee);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-employee")
    public ModelAndView editEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("views/edit");
        if(bindingResult.hasFieldErrors()) {
            return modelAndView;
        } else {
            employeeService.save(employee);
            modelAndView.addObject("employee", employee);
            modelAndView.addObject("message", "a new employee was updated!");
            return modelAndView;
        }
    }
}
