package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "receipt")
public class FeeReceiptEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "referenceId")
    private Long referenceId;

    //@Column(name = "cardNumber")
    private String cardNumber;

    //@Column(name = "cardType")
    private String cardType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    //@Column(name = "tuitionFee")
    private double tuitionFee;

    //@Column(name = "studentId")
    private Long studentId;
}
