package com.example.demo.model;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Employee {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "employee_name")
    private String name;
    @Column(name = "employee_gender")
    private String gender;
    @Column(name = "employee_age")
    private int age;
    @Column(name = "employee_designation")
    private String designation;

    public Employee() {
    }

    public Employee(int id, String name, String gender, int age, String designation) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.designation = designation;
    }
    /*  public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", designation='" + designation + '\'' +
                '}';
    }*/
}
