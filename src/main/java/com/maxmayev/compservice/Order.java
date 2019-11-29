package com.maxmayev.compservice;


import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Slf4j
public class Order {

    private int id;
    private Date appendDate;
    private Date receivePlan;
    private Date receiveFact;
    private Date callDate;
    private int active = 1;
    private Technic technic = Technic.NotSet;
    private String brand;
    private String model;
    private String serialNumber;
    private ConditionType conditionType = ConditionType.NotSet;
    private String conditionDescription;
    private String orderDescription;
    private String note;

    public static enum ConditionType{
        LikeNew,
        Used,
        WithDamages,
        NotSet
    }
    public static enum Technic{
        Notebook,
        PC,
        PhoneOrTablet,
        OrgTech,
        Cartridge,
        Other,
        NotSet
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
