package example.application.controller.rest;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import example.application.controller.rest.dto.HelloResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext-testing.xml")
public class HelloWorldServiceJavaTest {

    @Inject
    HelloWorldService service;

    @Test
    public void testGet() {
        HelloResponse response = service.get("hoge");

        assertEquals(response.attr, "hello!");
        assertEquals(response.message, "hoge");
    }
}
