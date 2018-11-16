package com.codegym.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    @GetMapping("/")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("views/create");
        return modelAndView;
    }
}
