package com.tsoun.employees.service;

import com.tsoun.employees.entity.Department;

import java.util.List;

public interface DepartmentService {
    /**
     * Get all departments.
     * @return list of {@link Department}.
     */
    List<Department> getAllDepartments();

}
