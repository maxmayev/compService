package com.maxmayev.compservice.domain;


import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "consumer")
@DynamicInsert
@DynamicUpdate
@ToString(exclude = "orders")
public class Consumer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Order.class)
    @JoinColumn(name = "consumer_id")
    //@JsonIgnore
    //@JsonManagedReference
   // @OneToMany(mappedBy="consumer",cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    public void addOrders(Order order){
        this.orders.add(order);
    }
}
