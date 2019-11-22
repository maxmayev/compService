package com.maxmayev.compservice;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Size;

@Data
@RequiredArgsConstructor
public class User {

    @Size(min = 4, message = "Min characters is four")
    private String email;
    @Size(min = 4, message = "Min characters is four")
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
