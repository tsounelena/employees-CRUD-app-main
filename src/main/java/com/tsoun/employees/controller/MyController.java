package com.tsoun.employees.controller;

import com.tsoun.employees.entity.Department;
import com.tsoun.employees.entity.Employee;
import com.tsoun.employees.service.DepartmentService;
import com.tsoun.employees.service.EmployeeService;
import com.tsoun.employees.service.ExcelService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MyController {

    private List<Department> allDepartments;

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final ExcelService excelService;

    /**
     * As departments are not changed by users, departments are initializing during startup.
     */
    @PostConstruct
    public void init() {
        allDepartments = departmentService.getAllDepartments();
    }

    @RequestMapping("/employees")
    public String showAllEmployees(Model model) {
        if (!model.containsAttribute("searchResult")) {
            List<Employee> allEmployees = employeeService.getAllEmployees();
            model.addAttribute("allEmployees", allEmployees);
        }
        return "view_for_all_employees";
    }

    @RequestMapping("/addEmployee")
    public String addEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("departments", allDepartments);

        return "view_for_employee_info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult,
            Model model) {
        model.addAttribute("departments", allDepartments);
        if (bindingResult.hasErrors()) {
            return "view_for_employee_info";
        } else {
            employeeService.saveEmployee(employee);
            return "redirect:/employees";
        }
    }

    @RequestMapping("/editEmployee")
    public String editEmployee(@RequestParam("emp_id") int id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee)
                .addAttribute("departments", allDepartments);

        return "view_for_employee_info";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("emp_id") int id) {
        employeeService.deleteEmployee(id);

        return "redirect:/employees";
    }

    @RequestMapping("/search")
    public String search(@RequestParam String keyword, Model model) {
        List<Employee> searchResult = employeeService.search(keyword);
        model.addAttribute("searchResult", searchResult);

        return "view_for_search_result";
    }

    @RequestMapping("/download")
    public void getFile(HttpServletResponse response) {
        response.setContentType("application/vnd.ms-excel");
        excelService.load(response);
    }
}
