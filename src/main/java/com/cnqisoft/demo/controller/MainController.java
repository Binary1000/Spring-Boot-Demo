package com.cnqisoft.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostMapping("validateCode")
    public String validateCode(String code, HttpSession session) {
        String sessionCode = (String) session.getAttribute("imageCode");
        if (sessionCode.toLowerCase().equals(code.toLowerCase())) {
            return "redirect:success";
        }else {
            return "redirect:fail";
        }
    }

    @GetMapping("works")
    @ResponseBody
    public List works() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from work");
        return list;
    }

}