package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Employee;

@RestController
public class HelloController {
    //choice 1: 
    // @GetMapping(value = "/employee", produces = {"application/xml"})
    // public Employee employeeMethod() {
    //     return new Employee(1, "Ashit kumar Rai", "100");

    // }

    //choince 2: 
    @GetMapping(value = "/employee")
    public Employee employeeMethod() {
        return new Employee(1, "Ashit kumar Rai", "100");

    }

}
