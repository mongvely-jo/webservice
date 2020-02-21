package com.example.demod.service;

import com.example.demod.model.User;
import com.example.demod.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class JoinService {

    @Autowired
    private UserRepository userRepository;

    public void joinUser(HttpServletRequest request) {

        User user = User.builder()
                .account(request.getParameter("account"))
                .password(request.getParameter("password"))
                .name(request.getParameter("name"))
                .phoneNumber(request.getParameter("phoneNumber"))
                .build();


        userRepository.save(user);
    }
}
