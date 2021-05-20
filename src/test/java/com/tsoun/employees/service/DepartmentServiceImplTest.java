package com.tsoun.employees.service;

import com.tsoun.employees.entity.Department;
import com.tsoun.employees.utils.DepartmentUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DepartmentServiceImplTest {

    @Autowired
    private DepartmentService departmentService;

    @Test
    void whenGetListOfAllDepartmentsListIsNotEmpty() {
        List<Department> departmentList = departmentService.getAllDepartments();
        Assertions.assertThat(departmentList).isNotNull();
    }

    @Test
    void WhenGetAllDepartmentsFromDataBaseListContainsValuesHrSalesDev() {
        List<Department> departmentList = departmentService.getAllDepartments();
        Assertions.assertThat(departmentList).usingRecursiveFieldByFieldElementComparator().contains(DepartmentUtils.DEV, DepartmentUtils.SALES, DepartmentUtils.HR);
    }
}