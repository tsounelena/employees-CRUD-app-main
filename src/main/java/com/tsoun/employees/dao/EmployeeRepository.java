package com.tsoun.employees.dao;

import com.tsoun.employees.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "SELECT c FROM Employee c WHERE c.surname LIKE '%' || :keyword || '%'"
            + " OR c.name LIKE '%' || :keyword || '%'"
            + " OR c.middleName LIKE '%' || :keyword || '%'"
            + " OR c.position LIKE '%' || :keyword || '%'"
            + " OR c.department.name LIKE '%' || :keyword || '%'")
    List<Employee> search(@Param("keyword") String keyword);
}
