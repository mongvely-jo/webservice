package com.example.demod.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class HomeController {

    @Autowired
    private HttpSession session;

    @GetMapping("/")
    public String index() {
        log.info("index 페이지");
        log.info("{}", session.getAttribute("loginUser"));
        return "index";
    }

    @GetMapping("/joinPage")
    public String joinPage() {
        return "join";
    }

    @GetMapping("/loginPage")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "index";
    }

    @GetMapping("/freeboardWritePage")
    public String freeboardWritePage() {
        return "freeboardWrite";
    }
}
