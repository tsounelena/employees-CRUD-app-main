package com.tsoun.employees.service;

import com.tsoun.employees.dao.EmployeeRepository;
import com.tsoun.employees.entity.Employee;
import com.tsoun.employees.excel.ExcelHelper;
import com.tsoun.employees.excel.ExcelHelperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExcelServiceImpl implements ExcelService {

    private final EmployeeRepository employeeRepository;
    private final ExcelHelper excelHelper;

    @Override
    public void load(HttpServletResponse response) {
        List<Employee> employees = employeeRepository.findAll();
        excelHelper.employeesToExcel(employees, response);
    }
}
