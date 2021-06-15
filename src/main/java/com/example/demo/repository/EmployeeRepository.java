package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Employee repository.
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer>{
    /**
     * Find by id and name optional.
     *
     * @param id   the id
     * @param name the name
     * @return the optional
     */
//public Employee findById(int id);
    public Optional<Employee> findByIdAndName(int id, String name);

    /**
     * Find by age sorted list.
     *
     * @param age the age
     * @return the list
     */
    @Query("from Employee where age=?1 order by name")
    List<Employee> findByAgeSorted(int age);
}
