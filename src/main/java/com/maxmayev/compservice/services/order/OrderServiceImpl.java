package com.maxmayev.compservice.services.order;

import com.maxmayev.compservice.domain.Consumer;
import com.maxmayev.compservice.domain.Order;
import com.maxmayev.compservice.domain.User;
import com.maxmayev.compservice.repository.ConsumerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService{

    ConsumerRepository consumerRepository;

    @Autowired
    public OrderServiceImpl(ConsumerRepository consumerRepository) {
        this.consumerRepository = consumerRepository;
    }

    @Override
    public void showOrderForm(Model model, Consumer consumer, Authentication authentication) {
        User user = (User)authentication.getPrincipal();
        log.debug(user.toString());
        List<Consumer> consumers = new ArrayList<>();
        consumerRepository.findAll().forEach(consumers::add);
        model.addAttribute("consumers",consumers);
        Order order = new Order();
        order.setAppendDate(new Date());
        model.addAttribute("order", order);
        Order.Technic[] technics = Order.Technic.values();
        model.addAttribute("technics",technics);
        Order.ConditionType[] conditions = Order.ConditionType.values();
        model.addAttribute("conditions",conditions);
    }

    @Override
    public void editOrder(String id) {
        log.info("Editing order number " + id);
    }
}
