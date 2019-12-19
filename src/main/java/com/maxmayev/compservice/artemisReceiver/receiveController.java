package com.maxmayev.compservice.artemisReceiver;


import com.maxmayev.compservice.Consumer;
import com.maxmayev.compservice.TestConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/receive")
public class receiveController {

    JmsTemplate jmsTemplate;
    private MessageConverter converter;


    @Autowired
    public receiveController(JmsTemplate jmsTemplate, MessageConverter converter) {
        this.jmsTemplate = jmsTemplate;
        this.converter = converter;
    }

    @GetMapping
    public String receiveConsumer(Model model){
        Consumer consumer = (Consumer) jmsTemplate.receiveAndConvert("com.maxmayev.consumer.queue");
        log.info(consumer.toString());
        model.addAttribute("consum",consumer);
    return "receiveTest";
    }
}
