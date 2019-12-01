package com.maxmayev.compservice;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "consumer")
public class Consumer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "consumer_id")
   //@OneToMany(mappedBy="consumer",cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    public void addOrders(Order order){
        this.orders.add(order);
    }
}
