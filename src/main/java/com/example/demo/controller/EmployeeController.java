package com.example.demo.controller;

import com.example.demo.dto.Request;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The type Employee controller.
 */
@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    /**
     * The Employee service.
     */
    @Autowired
    EmployeeService employeeService;

    /**
     * Get all employees list.
     *
     * @return the list
     */
    @GetMapping("/GetAllEmployees")
    public List<Request> getAllEmployees(){
         return employeeService.getAllEmployees();
    }

    /**
     * Gets employee by id.
     *
     * @param id the id
     * @return the employee by id
     */
    @GetMapping("/GetById/{id}")
    public Request getEmployeeById(@PathVariable ("id")int id){
        return employeeService.getEmployeeById(id);
    }

    /**
     * Gets employee by id and name.
     *
     * @param id   the id
     * @param name the name
     * @return the employee by id and name
     */
    @GetMapping("/GetByIdAndName/{id}/{name}")
    public Request getEmployeeByIdAndName(@PathVariable ("id")int id,@PathVariable ("name")String name){
         return employeeService.getEmployeeIdAndName(id,name);
    }

    /**
     * Save employee request.
     *
     * @param employee the employee
     * @return the request
     */
    @PostMapping("/saveEmployee")
    public Request saveEmployee(Employee employee){
         return employeeService.saveEmployee(employee);
    }

    /**
     * Delete employee request.
     *
     * @param employee the employee
     * @return the request
     */
    @DeleteMapping("/DeleteEmployee")
    public Request deleteEmployee(Employee employee){
         return employeeService.deleteEmployee(employee);
    }

    /**
     * Get age by sorted list.
     *
     * @return the list
     */
    @GetMapping("/AgeSorted/{age}")
    public List<Request> getAgeBySorted(@PathVariable ("age")int age){
         return employeeService.getAgeBySorted(age);
    }
}
