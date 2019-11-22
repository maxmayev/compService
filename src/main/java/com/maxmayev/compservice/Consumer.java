package com.maxmayev.compservice;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class Consumer {
    private final int id;
    private final String name;
    private final String surname;
    private final String patronymic;
    private final String phoneNumber;
}
