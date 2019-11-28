package com.maxmayev.compservice;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Calendar;
import java.util.Date;

@Data
@RequiredArgsConstructor
public class Order {

    private int id;
    private Date appendDate;
    private Date receivePlan;
    private Date receiveFact;
    private Date callDate;
    private boolean active;
    private Technic technic;
    private String brand;
    private String model;
    private String serialNumber;
    private Condition condition;
    private String conditionDescription;
    private String orderDescription;
    private String note;

    public String getOrderByConsumerId(String id){
        return "010101";
    }

    public static enum Condition{
        LikeNew,
        Used,
        WithDamages;
    }
    public static enum Technic{
        Notebook,
        PC,
        PhoneOrTablet,
        OrgTech,
        Cartridge,
        Other
    }
    
}
