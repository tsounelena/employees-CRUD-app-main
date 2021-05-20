package com.tsoun.employees.service;

import javax.servlet.http.HttpServletResponse;

public interface ExcelService {

    /**
     * Load excel file with employees' information.
     * @param response {@link HttpServletResponse}.
     */
    void load(HttpServletResponse response);

}
