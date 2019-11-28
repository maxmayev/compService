package com.maxmayev.compservice.controllers;


import com.maxmayev.compservice.Consumer;
import com.maxmayev.compservice.DAO.ConsumerRepository;
import com.maxmayev.compservice.Order;
import com.sun.org.apache.xpath.internal.operations.Or;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.*;

@Slf4j
@Controller
@SessionAttributes("consumer")
@RequestMapping("/order")
public class OrderController {

    private ConsumerRepository consumerRepository;

    @Autowired
    public OrderController(ConsumerRepository consumerRepository){
        this.consumerRepository = consumerRepository;
    }


 /*   public Consumer consumer;
    @ModelAttribute
    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }*/

    @GetMapping
    public String showOrderForm(Model model, Consumer consumer){
        model.addAttribute(consumer);
        List<Consumer> consumers = new ArrayList<>();
        consumerRepository.findAll().forEach(consumers::add);
        model.addAttribute("consumers",consumers);
        Order order = new Order();
        order.setAppendDate(new Date());
        model.addAttribute("order",order);
        Order.Technic[] technics = Order.Technic.values();
        model.addAttribute("technics",technics);
        Order.Condition[] conditions = Order.Condition.values();
        model.addAttribute("conditions",conditions);
        return "order";
    }

    @PostMapping
    public String addConsumer(Consumer consumer, Errors errors, SessionStatus sessionStatus){
        if (errors.hasErrors()) return "/order";
        log.info(consumer.toString());
        consumerRepository.save(consumer);
        return "redirect:/order";
    }

    @PostMapping("/addordertoconsumer")
    public String addOrderToConsumer(@ModelAttribute Consumer consumer, Order order, Errors errors, SessionStatus sessionStatus){
        consumer.addOrder(order);
        log.info(order.toString());
        return "redirect:/order";
    }


}
