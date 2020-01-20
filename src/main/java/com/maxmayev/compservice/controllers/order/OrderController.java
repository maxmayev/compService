package com.maxmayev.compservice.controllers.order;

import com.maxmayev.compservice.domain.Consumer;
import com.maxmayev.compservice.services.order.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@SessionAttributes("consumer")
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping
    public String showOrderForm(Model model, Consumer consumer, Authentication authentication){
        orderService.showOrderForm(model, consumer , authentication);
        return "order";
    }

    @PostMapping ("/edit")
    public String editOrder(String id){
        orderService.editOrder(id);
        return "redirect:/order";
    }

}
