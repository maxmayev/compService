package com.maxmayev.compservice.controllers;

import com.maxmayev.compservice.Consumer;
import com.maxmayev.compservice.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Slf4j
@Controller
@RequestMapping("/security")
public class SecurityController {

    @PostMapping
    public String showOrderForm(@Valid User user, Errors errors){

        if (errors.hasErrors()) {
            log.info("error validation User");
            return "security";
        }
        log.info(user.toString());
        return "redirect:/order";
    }

    @GetMapping
    public String showSecurity(Model model){
        model.addAttribute("user", new User());
        return "security";
    }
}
