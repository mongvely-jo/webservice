package com.example.demod.controller;

import com.example.demod.service.JoinService;
import com.example.demod.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private JoinService joinService;

    @Autowired
    private LoginService loginService;

    @Autowired
    HttpSession session;

    @PostMapping("/joinRequest")
    public String joinRequest(HttpServletRequest request) {
        return joinService.joinUser(request);

    }

    @PostMapping("/loginRequest")
    public String loginRequest(HttpServletRequest request){
        return loginService.loginRequest(request);
    }
}
