package com.example.demod.controller;

import com.example.demod.service.JoinService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @PostMapping("/joinRequest")
    public String joinRequest(HttpServletRequest request) {
        JoinService joinService = new JoinService();
        joinService.joinUser(request);
        return "index";
    }

    @PostMapping("/loginRequest")
    public String loginRequest(){
        return "index";
    }
}
