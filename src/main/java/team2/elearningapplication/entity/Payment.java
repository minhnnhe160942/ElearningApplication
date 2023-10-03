package team2.elearningapplication.entity;

import team2.elearningapplication.Enum.EnumPaymentGateway;
import team2.elearningapplication.Enum.EnumPaymentProcess;

import javax.persistence.*;
import java.time.LocalDateTime;

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name="course_id",referencedColumnName = "id")
    private Course course;

    @Enumerated(EnumType.STRING)
    @Column(name="payment_gateway")
    private EnumPaymentGateway paymentGateway;

    @Column(name="transaction_id")
    private String transaction_id;

    @Column(name="amount")
    private double amount;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private EnumPaymentProcess enumPaymentProcess;

    @Column(name="created_at")
    private LocalDateTime created_at;

}
