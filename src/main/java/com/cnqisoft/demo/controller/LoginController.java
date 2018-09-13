package com.cnqisoft.demo.controller;


import com.cnqisoft.demo.entity.ResBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {

    @GetMapping("authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public ResBean handleLogin(HttpServletRequest request) {
        System.out.println(request);
        return new ResBean("401", "未授权");
    }

}
