package com.tsoun.employees.service;

import com.tsoun.employees.entity.Employee;

import java.util.List;

public interface EmployeeService {

    /**
     * Get all employees.
     * @return list of {@link Employee}.
     */
    List<Employee> getAllEmployees();

    /**
     * Delete employee.
     * @param id of employee.
     */
    void deleteEmployee(Integer id);

    /**
     * Save employee.
     * @param employee {@link Employee}
     */
    void saveEmployee(Employee employee);

    /**
     * Get employee by id.
     * @param id of employee.
     * @return {@link Employee}
     */
    Employee getEmployeeById(Integer id);

    /**
     * Search employee using keyword
     * @param keyword can use surname, name, middle name, position or name of department.
     * @return list of {@link Employee}.
     */
    List<Employee> search(String keyword);

}
