package com.example.demo;

import com.example.demo.controller.EmployeeController;
import com.example.demo.dto.Request;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The type Employee controller test.
 */
@RunWith(SpringRunner.class)

@WebMvcTest(value = EmployeeController.class)

public class EmployeeControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private EmployeeService employeeService;

    /**
     * Test get all employees.
     *
     * @throws Exception the exception
     */
    @Test
        public void TestGetAllEmployees() throws Exception {
            List<Request> employeeList = new ArrayList<>();
            employeeList.add(new Request(6, "Kishore", "IT"));
            employeeList.add(new Request(7, "Aamani", "Tester"));
            Mockito.when(employeeService.getAllEmployees()).thenReturn(employeeList);
            String URI = "/Employee/GetAllEmployees";
            RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                    URI).accept(
                    MediaType.APPLICATION_JSON);
            MvcResult result = mockMvc.perform(requestBuilder).andReturn();

            String expectedJson = this.mapToJson(employeeList);
            String outputInJson = result.getResponse().getContentAsString();
            assertThat(outputInJson).isEqualTo(expectedJson);
        }

    /**
     * Test get employee by id.
     *
     * @throws Exception the exception
     */
    @Test
    public void TestGetEmployeeById() throws Exception{
        Request mockEmployee= new Request(9,"kousalya","Manager");
        Mockito.when(employeeService.getEmployeeById(Mockito.anyInt())).thenReturn(mockEmployee);
        String URI = "/Employee/GetById/9";
        RequestBuilder requestBuilder= MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedJson= this.mapToJson(mockEmployee);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(expectedJson);
    }

    /**
     * Test get employee id and name.
     *
     * @throws Exception the exception
     */
    @Test
    public void TestGetEmployeeIdAndName() throws Exception{
        Request mockEmployee= new Request(9,"kousalya","Manager");
        Mockito.when(employeeService.getEmployeeIdAndName(Mockito.anyInt(),Mockito.anyString())).thenReturn(mockEmployee);
        String URI = "/Employee/GetByIdAndName/9/kousalya";
        RequestBuilder requestBuilder= MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedJson= this.mapToJson(mockEmployee);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(expectedJson);
    }

    /**
     * Test save employee.
     *
     * @throws Exception the exception
     */
    @Test
    public void TestSaveEmployee() throws Exception{
        Request mockEmployee=new Request(10,"sushela","Manager");
        String inputInJson= this.mapToJson(mockEmployee);
        Mockito.when(employeeService.saveEmployee(Mockito.any(Employee.class))).thenReturn(mockEmployee);
        String URI="/Employee/saveEmployee";
        RequestBuilder requestBuilder= MockMvcRequestBuilders
                .post(URI)
                .accept(MediaType.APPLICATION_JSON).content(inputInJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response= result.getResponse();
        String outputInJson = response.getContentAsString();
        assertThat(outputInJson).isEqualTo(inputInJson);
        Assertions.assertEquals(HttpStatus.OK.value(),response.getStatus());
    }

    /**
     * Test delete employee.
     *
     * @throws Exception the exception
     */
    @Test
    public void TestDeleteEmployee() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/Employee/DeleteEmployee"));
    }

    /**
     * Test get age by sorted.
     *
     * @throws Exception the exception
     */
    @Test
    public void TestGetAgeBySorted() throws Exception{
            int age=22;
        List<Request> employeeList=new ArrayList<>();
        employeeList.add(new Request(6,"kousalya","Manager"));
        employeeList.add(new Request(7,"geetha","Tester"));

        Mockito.when(employeeService.getAgeBySorted(age)).thenReturn(employeeList);
        String URI = "/Employee/AgeSorted/22";
        RequestBuilder requestBuilder= MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedJson= this.mapToJson(employeeList);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(expectedJson);
    }


        private String mapToJson(Object object) throws JsonProcessingException {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        }
    }



