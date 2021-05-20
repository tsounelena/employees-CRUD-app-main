package com.tsoun.employees.excel;

import com.tsoun.employees.entity.Employee;
import com.tsoun.employees.exception.ImportExcelException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class ExcelHelperImpl implements ExcelHelper{

    public static final String[] HEADERS =
            {"id", "surname", "name", "middle Name", "position", "birthday", "mobile phone", "email", "department"};
    public static final String SHEET = "Employees";

    @Override
    public void employeesToExcel(List<Employee> employees, HttpServletResponse response) {

        try (Workbook workbook = new XSSFWorkbook(); ServletOutputStream out = response.getOutputStream()) {

            Sheet sheet = workbook.createSheet(SHEET);

            Row headerRow = sheet.createRow(0);

            for (int i = 0; i < HEADERS.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(HEADERS[i]);
            }

            int rowIdx = 1;
            for (Employee employee : employees) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(employee.getId());
                row.createCell(1).setCellValue(employee.getSurname());
                row.createCell(2).setCellValue(employee.getName());
                row.createCell(3).setCellValue(employee.getMiddleName());
                row.createCell(4).setCellValue(employee.getPosition());
                row.createCell(5).setCellValue(employee.getBirthday());
                row.createCell(6).setCellValue(employee.getMobilePhone());
                row.createCell(7).setCellValue(employee.getEmail());
                row.createCell(8).setCellValue(employee.getDepartment().getName());
            }

            workbook.write(out);

        } catch (IOException e) {
            throw new ImportExcelException("excel generation failed" + e.getMessage());
        }
    }

}
