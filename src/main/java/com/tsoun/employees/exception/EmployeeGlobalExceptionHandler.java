package com.tsoun.employees.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeGlobalExceptionHandler {

    @ExceptionHandler
    public String handlerException(ImportExcelException exception, Model model) {
        model.addAttribute("exception_message", exception.getMessage());
        return "view_for_exception";
    }

}
