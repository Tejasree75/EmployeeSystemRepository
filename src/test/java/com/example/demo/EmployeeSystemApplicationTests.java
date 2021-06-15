package com.example.demo;

import com.example.demo.dto.Request;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Stream.of;
import static junit.framework.Assert.assertEquals;

/**
 * The type Employee system application tests.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeSystemApplicationTests {

    @Mock
    private EmployeeRepository repo;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private EmployeeService employeeService;

	/**
	 * Save employee test.
	 */
	@Test
    public void saveEmployeeTest() {
        Employee user = new Employee(8, "Meena", "female", 25, "Tester");
        Mockito.when(repo.save(ArgumentMatchers.any(Employee.class))).thenReturn(user);
        Mockito.when(modelMapper.map(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(RequestDto());
        Request created = employeeService.saveEmployee(user);
        assertThat(created.getName()).isSameAs(user.getName());
        Mockito.verify(repo).save(user);
    }

	/**
	 * Gets employee by id test.
	 */
	@Test
    public void getEmployeeByIdTest() {
        int id = 8;
        Employee user = new Employee(8, "Meena", "female", 22, "Tester");
        Mockito.when(repo.findById(id)).thenReturn(Optional.of(user));
        Mockito.when(modelMapper.map(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(RequestDto());
        assertEquals(8, employeeService.getEmployeeById(id).getId());
    }

	/**
	 * Gets employee id and name test.
	 */
	@Test
    public void getEmployeeIdAndNameTest() {
        int id = 8;
        String name = "Meena";
        Employee user = new Employee(8, "Meena", "female", 22, "Tester");
        Mockito.when(repo.findByIdAndName(id, name)).thenReturn(Optional.of(user));
        Mockito.when(modelMapper.map(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(RequestDto());
        assertEquals(8, employeeService.getEmployeeIdAndName(id, name).getId());
        assertEquals("Meena", employeeService.getEmployeeIdAndName(id, name).getName());

    }

	/**
	 * Gets age by sorted test.
	 */
	@Test
    public void getAgeBySortedTest() {
        int age = 22;
        List<Employee> list = new ArrayList<Employee>();
        Employee emp1 = new Employee(8, "Meena", "female", 22, "Tester");
        Employee emp2 = new Employee(9, "Sneha", "female", 23, "IT");
        list.add(emp1);
        list.add(emp2);
        Mockito.when(repo.findByAgeSorted(age)).thenReturn(list);
        Mockito.when(modelMapper.map(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(RequestDtoAll());
        assertEquals(2, employeeService.getAgeBySorted(age).size());
    }

	/**
	 * Gets all employees test.
	 */
	@Test
    public void getAllEmployeesTest() {
        List<Employee> list = new ArrayList<Employee>();
        Employee emp1 = new Employee(8, "Meena", "female", 22, "Tester");
        Employee emp2 = new Employee(9, "Sneha", "female", 23, "IT");
        list.add(emp1);
        list.add(emp2);
        Mockito.when(repo.findAll()).thenReturn(list);
        Mockito.when(modelMapper.map(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(RequestDtoAll());
        List<Request> created = employeeService.getAllEmployees();
        assertEquals(created.size(), employeeService.getAllEmployees().size());
    }

	/**
	 * Delete employee test.
	 */
	@Test
    public void deleteEmployeeTest() {
        Employee user = new Employee(8, "Meena", "female", 22, "Tester");
        Mockito.when(repo.save(ArgumentMatchers.any(Employee.class))).thenReturn(user);
        employeeService.deleteEmployee(user);
        Mockito.verify(repo, times(1)).delete(user);

    }

    private Request RequestDto() {
        Request employeeDto = new Request(8, "Meena", "Tester");
        return employeeDto;
    }

    private Request[] RequestDtoAll() {
        Request[] employee1 = new Request[2];
        employee1[0] = new Request(8, "Meena", "Tester");
        employee1[1] = new Request(9, "Sneha", "IT");
        return employee1;

    }
}
