package com.maxmayev.compservice;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Order {
    private final int id;
    private final String person;
    private final String address;
    private final String description;
    private final String technique;
}
