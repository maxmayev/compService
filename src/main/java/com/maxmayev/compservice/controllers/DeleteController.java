package com.maxmayev.compservice.controllers;

import com.maxmayev.compservice.DAO.ConsumerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/delete")

public class DeleteController {

    private ConsumerRepository consumerRepository;
    @Autowired
    public void setConsumerRepository(ConsumerRepository consumerRepository) {
        this.consumerRepository = consumerRepository;
    }

    @PostMapping
    public String deleteConsumer(String id){
        consumerRepository.deleteById(id);
        log.info("Delete consumer with id " + id);
        return "redirect:/order";
    }
}
