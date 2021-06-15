package com.example.demo.service;

import com.example.demo.dto.Request;
import com.example.demo.exception.EmployeeMatchNotFoundException;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.exception.NoEmployeeFoundException;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.model.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Employee service.
 */
@Service
public class EmployeeService {
    /**
     * The Id 1.
     */
    @Value("${my.id}")
    public int id1;
    /**
     * The Repo.
     */
    @Autowired
    EmployeeRepository repo;
    /**
     * The Model mapper.
     */
    @Autowired
    ModelMapper modelMapper;

    /**
     * Gets all employees.
     *
     * return all employees
     */
    public List<Request> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList = (List<Employee>) repo.findAll();
        if (employeeList.isEmpty()) {
            throw new NoEmployeeFoundException(ErrorCode.NO_EMPLOYEE_FOUND);
        }
        return convertToDtoList(employeeList);
    }

    /**
     * Gets employee by id.
     *
     * @param id the id
     * @return the employee by id
     */
    public Request getEmployeeById(int id) {
        System.out.println(id1);
        Employee employee= repo.findById(id).orElseThrow(() -> new EmployeeNotFoundException(ErrorCode.EMPLOYEE_NOT_FOUND, id));
        return convertToDto(employee);
    }

    /**
     * Gets employee id and name.
     *
     * @param id   the id
     * @param name the name
     * @return the employee id and name
     */
    public Request getEmployeeIdAndName(int id, String name) {
        Employee employee= repo.findByIdAndName(id, name).orElseThrow(() -> new EmployeeMatchNotFoundException(ErrorCode.EMPLOYEE_MATCH_NOT_FOUND, id, name));
        return convertToDto(employee);
    }

    /**
     * Save employee request.
     *
     * @param employee the employee
     * @return the request
     */
    public Request saveEmployee(Employee employee) {
         repo.save(employee);
         return convertToDto(employee);
    }

    /**
     * Delete employee request.
     *
     * @param employee the employee
     * @return the request
     */
    public Request deleteEmployee(Employee employee) {
        repo.delete(employee);
        return convertToDto(employee) ;
    }

    /**
     * Gets age by sorted.
     *
     * @return the age by sorted
     */
    public List<Request> getAgeBySorted(int age) {
        List<Employee> list= repo.findByAgeSorted(22);
         return convertToDtoList(list);
    }

    /**
     * Convert to dto request.
     *
     * @param employee the employee
     * @return the request
     */
    public Request convertToDto(Employee employee) {
        return modelMapper.map(employee, Request.class);
    }

    /**
     * Convert to dto list list.
     *
     * @param employee the employee
     * @return the list
     */
    public List<Request> convertToDtoList(List<Employee> employee) {

        List<Request> RequestList = Arrays.asList(modelMapper.map(employee, Request[].class));

        return RequestList;

    }
}
