package com.maxmayev.compservice.controllers;

import com.maxmayev.compservice.DAO.UserRepository;
import com.maxmayev.compservice.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/register")
public class RegistrationController {

    UserRepository userRepository;
    PasswordEncoder encoder;

    @Autowired
    public RegistrationController(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @GetMapping

    public String registerForm(){
        return "registration";
    }


    @PostMapping

    public String processRegistration(RegistrationForm form){
        userRepository.save(form.toUser(encoder));
        return "redirect:/login";
    }

}
