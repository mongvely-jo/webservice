package com.example.demod.service;

import com.example.demod.model.User;
import com.example.demod.repository.UserRepository;
import com.example.demod.service.hash.UserPasswordHashClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
@Service
public class JoinService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPasswordHashClass userPasswordHashClass;

    public String joinUser(HttpServletRequest request) {
        String password = userPasswordHashClass.getSHA256(request.getParameter("password"));

        User user = User.builder()
                .account(request.getParameter("account"))
                .password(password)
                .name(request.getParameter("name"))
                .phoneNumber(request.getParameter("phoneNumber"))
                .build();

        log.info("{}",user);

        userRepository.save(user);

        if(user == null){
            return "join";
        }
        return "index";
    }
}
