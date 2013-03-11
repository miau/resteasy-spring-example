package example.application.controller.rest;

import static org.unitils.reflectionassert.ReflectionAssert.*;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.joda.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.unitils.dbunit.annotation.DataSet;

import example.application.controller.rest.dto.EmployeeListResponse;
import example.application.controller.rest.dto.EmployeeResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext-testing.xml")
@DataSet
public class EmployeeServiceJavaTest {

    @Inject
    EmployeeService service;

    @Test
    public void testGet() {
        EmployeeListResponse response = service.get();
        EmployeeResponse[] expected = new EmployeeResponse[] {
            new EmployeeResponse() {{
                employeeId = new BigDecimal(1);
                employeeName = "スミス";
                hiredate = new LocalDateTime("1980-12-17T00:00:00.000");
                salary = new BigDecimal(800);
            }},
            new EmployeeResponse() {{
                employeeId = new BigDecimal(2);
                employeeName = "アレン";
                hiredate = new LocalDateTime("1981-02-20T00:00:00.000");
                salary = new BigDecimal(1600);
            }},
            new EmployeeResponse() {{
                employeeId = new BigDecimal(3);
                employeeName = "ワード";
                hiredate = new LocalDateTime("1981-02-22T00:00:00.000");
                salary = new BigDecimal(1250);
            }}
        };
        // 本来 expected を第一引数とすべきだが、型が一致しないとみなされるので逆にしている
        assertReflectionEquals(response.employee, expected);
    }
}
