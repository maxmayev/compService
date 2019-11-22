package com.maxmayev.compservice.controllers;


import com.maxmayev.compservice.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/order")
public class OrderController {
    @GetMapping
    public String showOrderForm(Model model){
        Consumer consumer = new Consumer(1,"Max","Mayev","Nicolayevich", "+79657560804");
        model.addAttribute("consumer", consumer);
        return "order";
    }
}
