package com.maxmayev.compservice.controllers.consumer;

import com.maxmayev.compservice.domain.Consumer;
import com.maxmayev.compservice.domain.Order;
import com.maxmayev.compservice.services.consumer.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/consumer")
@SessionAttributes("consumer")
public class ConsumerController {

    private ConsumerService consumerService;

    @Autowired
    public ConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @PostMapping("/add")
    public String addConsumer(Consumer consumer, Errors errors){
        if (!consumerService.addConsumer(consumer,errors)) return "/order";
        return "redirect:/order";
    }

    @PostMapping("/addordertoconsumer")
    public String addOrderToConsumer(@ModelAttribute Consumer consumer, Order order){
        consumerService.addOrderToConsumer(consumer,order);
        return "redirect:/order";
    }

    @PostMapping("/saveconsumer")
    public String saveConsumer(@ModelAttribute Consumer consumer, SessionStatus sessionStatus){
        consumerService.saveConsumer(consumer,sessionStatus);
        return "redirect:/order";
    }

    @PostMapping("/delete")
    public String deleteConsumer(String id){
        consumerService.deleteConsumer(id);
        return "redirect:/order";
    }
}
