package com.tsoun.employees.utils;

import com.tsoun.employees.entity.Employee;

import java.time.LocalDate;

public class EmployeeUtils {

    public static final Employee TEST_EMPLOYEE = getEmployee();

    public static Employee getEmployee(){
        return  new Employee("Ivanov", "Ivan", "Ivanovich", "developer", LocalDate.of(1990, 12, 12), "12345",
                "ivan@mail.com",
                DepartmentUtils.DEV);
    }

}
