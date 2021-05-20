package com.tsoun.employees;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class EmployeesApplicationTests {

    @Test
    void contextLoads(@Autowired ApplicationContext context) {
        Assertions.assertThat(context).isNotNull();
    }

}
