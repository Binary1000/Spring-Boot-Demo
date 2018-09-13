package com.cnqisoft.demo;


import com.cnqisoft.demo.entity.Student;
import com.cnqisoft.demo.esrepository.ESUserRepository;
import com.cnqisoft.demo.service.MathService;
import com.cnqisoft.demo.service.RestService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.awt.print.Book;
import java.net.URI;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    Logger loggerFactory = LoggerFactory.getLogger(getClass());


    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Autowired
    Student student;

    @Autowired
    MathService mathService;

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users")
                .contentType(MediaType.ALL.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void test01() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String raw = "1000";
        String encode = passwordEncoder.encode(raw);
        boolean flag = passwordEncoder.matches(raw, "$2a$10$ez/pqUW4/8qg7zQJAfuJ9.tYyz4cl80WqKkSbrEGSQTgATAHulHPy");
        System.out.println(flag);
    }

}
