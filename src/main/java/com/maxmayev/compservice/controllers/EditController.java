package com.maxmayev.compservice.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
@RequestMapping("/edit")
public class EditController {
    @PostMapping
    public String editOrder(String id){
        log.info("Editing order number " + id);
        return "redirect:/order";
    }

}
