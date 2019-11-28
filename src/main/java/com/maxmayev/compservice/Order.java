package com.maxmayev.compservice;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Data
@RequiredArgsConstructor
@Slf4j
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
    @SneakyThrows
    public void setCallDate(String callDate) {
        SimpleDateFormat oldDateFormat = new SimpleDateFormat("d.MM.yyyy", Locale.getDefault());
        this.callDate = oldDateFormat.parse(callDate);
    }

    @SneakyThrows
    public void setReceivePlan(String receivePlan) {
        SimpleDateFormat oldDateFormat = new SimpleDateFormat("d.MM.yyyy", Locale.getDefault());
        this.receivePlan = oldDateFormat.parse(receivePlan);
    }
}
