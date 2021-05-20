package com.tsoun.employees.excel;

import com.tsoun.employees.entity.Employee;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ExcelHelper {

    void employeesToExcel(List<Employee> employees, HttpServletResponse response);

}
