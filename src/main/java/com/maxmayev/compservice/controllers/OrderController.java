package com.maxmayev.compservice.controllers;


import com.maxmayev.compservice.Consumer;
import com.maxmayev.compservice.DAO.ConsumerRepository;
import com.maxmayev.compservice.DAO.OrderRepository;
import com.maxmayev.compservice.Order;
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
    private OrderRepository orderRepository;

    @Autowired
    public OrderController(ConsumerRepository consumerRepository, OrderRepository orderRepository){
        this.consumerRepository = consumerRepository;
        this.orderRepository = orderRepository;
    }


 /*   public Consumer consumer;
    @ModelAttribute
    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }*/

    @GetMapping
    public String showOrderForm(Model model, Consumer consumer){
        //model.addAttribute(consumer);
        List<Consumer> consumers = new ArrayList<>();
        //consumerRepository.findAll().forEach(cons -> {cons.setOrders(orderRepository.findById(cons.getId())).;consumers::add;});
        consumerRepository.findAll().forEach(consumers::add);
       // log.info(consumers.toString());
        /*StringBuilder consumerOrders = new StringBuilder();
        orderRepository.getOrdersByConsumer(consumer).forEach(a-> consumerOrders.append(a.getId() + ", "));
        log.info(orderRepository.getOrdersByConsumer(consumer).toString());
        model.addAttribute("consumerOrders", consumerOrders.toString());*/
        model.addAttribute("consumers",consumers);
        Order order = new Order();
        order.setAppendDate(new Date());
        model.addAttribute("order", order);
        Order.Technic[] technics = Order.Technic.values();
        model.addAttribute("technics",technics);
        Order.ConditionType[] conditions = Order.ConditionType.values();
        model.addAttribute("conditions",conditions);
        return "order";
    }

    @PostMapping
    public String addConsumer(Consumer consumer, Errors errors, SessionStatus sessionStatus){
        if (errors.hasErrors()) return "/order";
        log.info(consumer.toString());
        //consumerRepository.save(consumer);
        return "redirect:/order";
    }

    @PostMapping("/addordertoconsumer")
    public String addOrderToConsumer(@ModelAttribute Consumer consumer, Order order, Errors errors, SessionStatus sessionStatus){
        order.setAppendDate(new Date());
        order.setReceiveFact(order.getReceivePlan());
        //order.setConsumer(consumer);
        consumer.addOrders(order);
        /*log.info(order.toString());
        log.info(consumer.toString());*/
        return "redirect:/order";
    }

    @PostMapping("/saveconsumer")
    public String saveConsumer(@ModelAttribute Consumer consumer, SessionStatus sessionStatus){
        log.info(consumer.toString());
        consumerRepository.save(consumer);
        //orderRepository.saveAll(consumer.getOrders());
        sessionStatus.setComplete();
        return "redirect:/order";
    }




}
