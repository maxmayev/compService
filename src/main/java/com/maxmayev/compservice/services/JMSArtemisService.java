package com.maxmayev.compservice.services;

import com.maxmayev.compservice.Consumer;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class JMSArtemisService implements ConsumerMessagingService {

    JmsTemplate jms;
    private MessageConverter converter;

    @Autowired
    public JMSArtemisService(JmsTemplate jms, MessageConverter messageConverter) {
        this.jms = jms;
        this.converter = messageConverter;
    }



    @Override
    public void sendConsumer(Consumer consumer) {
       log.info("Sending " + consumer.toString());
        jms.convertAndSend(consumer);
    }
}
