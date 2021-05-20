package com.tsoun.employees.service;

import com.tsoun.employees.entity.Employee;
import com.tsoun.employees.utils.EmployeeUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional(transactionManager = "transactionManager")
class EmployeeServiceImplTest {

    @Autowired
    private EmployeeService employeeService;


    @BeforeEach
    void saveEmployeeBefore() {
        employeeService.saveEmployee(EmployeeUtils.TEST_EMPLOYEE);
    }

    @Test
    void gotListOfEmployeesContainsValue() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        Assertions.assertThat(allEmployees).usingElementComparatorIgnoringFields("id")
                .contains(EmployeeUtils.TEST_EMPLOYEE);
    }

    @Test
    void whenDeleteEmployeeHeIsDeleted() {
        employeeService.deleteEmployee(EmployeeUtils.TEST_EMPLOYEE.getId());
        List<Employee> allEmployees = employeeService.getAllEmployees();
        Assertions.assertThat(allEmployees).isNotNull().hasSizeGreaterThan(0).usingElementComparatorIgnoringFields("id")
                .doesNotContain(EmployeeUtils.TEST_EMPLOYEE);
    }

    @Test
    void whenSaveEmployeeAndGetByIdTheyAreSame() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        Employee employeeFromList = allEmployees.get(allEmployees.size()-1);
        Employee employeeFromDb = employeeService.getEmployeeById(employeeFromList.getId());
        Assertions.assertThat(employeeFromList).isEqualTo(employeeFromDb);
    }

    @Test
    void searchByName() {
        List<Employee> employeeList = employeeService.search(EmployeeUtils.TEST_EMPLOYEE.getName());
        Assertions.assertThat(employeeList).usingElementComparatorIgnoringFields("id")
                .contains(EmployeeUtils.TEST_EMPLOYEE);
    }

    @Test
    void searchBySurname() {
        List<Employee> employeeList = employeeService.search(EmployeeUtils.TEST_EMPLOYEE.getSurname());
        Assertions.assertThat(employeeList).usingElementComparatorIgnoringFields("id")
                .contains(EmployeeUtils.TEST_EMPLOYEE);
    }

    @Test
    void searchByMiddleName() {
        List<Employee> employeeList = employeeService.search(EmployeeUtils.TEST_EMPLOYEE.getMiddleName());
        Assertions.assertThat(employeeList).usingElementComparatorIgnoringFields("id")
                .contains(EmployeeUtils.TEST_EMPLOYEE);
    }

    @Test
    void searchByDepartmentName() {
        List<Employee> employeeList = employeeService.search(EmployeeUtils.TEST_EMPLOYEE.getDepartment().getName());
        Assertions.assertThat(employeeList).usingElementComparatorIgnoringFields("id")
                .contains(EmployeeUtils.TEST_EMPLOYEE);
    }

    @Test
    void searchByPosition() {
        List<Employee> employeeList = employeeService.search(EmployeeUtils.TEST_EMPLOYEE.getPosition());
        Assertions.assertThat(employeeList).usingElementComparatorIgnoringFields("id")
                .contains(EmployeeUtils.TEST_EMPLOYEE);
    }
}