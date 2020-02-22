package com.example.demod.controller;

import com.example.demod.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    JoinService joinService;

    @PostMapping("/joinRequest")
    public String joinRequest(HttpServletRequest request) {
        return joinService.joinUser(request);
    }

    @PostMapping("/loginRequest")
    public String loginRequest(){
        return "index";
    }
}
