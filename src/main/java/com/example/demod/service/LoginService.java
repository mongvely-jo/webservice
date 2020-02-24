package com.example.demod.service;

import com.example.demod.model.User;
import com.example.demod.repository.UserRepository;
import com.example.demod.service.hash.UserPasswordHashClass;
import com.mysql.cj.Session;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPasswordHashClass userPasswordHashClass;

    @Autowired
    private HttpSession session;

    public String loginRequest(HttpServletRequest request) {
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        if(account.equals("") || password.equals("")){
            log.info("{}", "계정과 비밀번호중 입력하지 않은 것 존재");
            return "login";
        }

        String hashPassword = userPasswordHashClass.getSHA256(password);

        User user = userRepository.findByAccount(account);


        if(user == null){
            log.info("{}", "아이디가 존재하지 않음");
            return "login";
        }

        String storedPassword = user.getPassword();

        if(!hashPassword.equals(storedPassword)){
            log.info("{}", "비밀번호 틀림");
            return "login";
        }

        session.setAttribute("loginUser",user);

        log.info("{}","로그인 성공");
        return "index";
    }

}
