package com.maxmayev.compservice.services.consumer;

import com.maxmayev.compservice.domain.Consumer;
import com.maxmayev.compservice.domain.Order;
import com.maxmayev.compservice.repository.ConsumerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;

@Slf4j
@Service
public class ConsumerServiceImpl implements ConsumerService {

    private ConsumerRepository consumerRepository;

    @Autowired
    public ConsumerServiceImpl(ConsumerRepository consumerRepository) {
        this.consumerRepository = consumerRepository;
    }

    @Override
    public Boolean addConsumer(Consumer consumer, Errors errors) {
        if (errors.hasErrors()) return false;
        log.debug(consumer.toString());
        return true;
    }

    @Override
    public void addOrderToConsumer(Consumer consumer, Order order) {
        order.setAppendDate(new Date());
        order.setReceiveFact(order.getReceivePlan());
        consumer.addOrders(order);
    }

    @Override
    public void saveConsumer(Consumer consumer, SessionStatus sessionStatus) {
        consumerRepository.save(consumer);
        sessionStatus.setComplete();
    }

    @Override
    public void deleteConsumer(String id) {
        consumerRepository.deleteById(Integer.parseInt(id));
        log.info("Delete consumer with id " + id);
    }

}
