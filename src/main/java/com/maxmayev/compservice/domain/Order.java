package com.maxmayev.compservice.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.maxmayev.compservice.domain.Consumer;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Slf4j
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private Date appendDate;
    private Date receivePlan;
    private Date receiveFact;
    private Date callDate;
    private Integer active;
    private String technic;
    private String brand;
    private String model;
    private String serialNumber;
    private String conditionType;
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

    @ManyToOne(fetch = FetchType.EAGER,cascade= CascadeType.ALL)
    @JoinColumn(name = "consumer_id", nullable = false)
    @JsonBackReference
    private Consumer consumer;

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

  /*  public void setConditionType(String conditionType) {
        this.conditionType = ConditionType.valueOf(conditionType);
    }*/
}
