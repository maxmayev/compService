package com.maxmayev.compservice;


import com.maxmayev.compservice.DAO.OrderRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consumer {

    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private String phoneNumber;

    private List<Order> orders = new ArrayList<>();
    public void addOrder(Order order){
        this.orders.add(order);
    }
}
