package team2.elearningapplication.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import team2.elearningapplication.Enum.EnumTypeProcessPayment;
import team2.elearningapplication.Enum.EnumTypeRole;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Accessors(chain = true)
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn
    private User user;
    @OneToOne
    @JoinColumn
    private Payment payment;
    @OneToOne
    @JoinColumn
    private Course course;
    @Column(name="amount")
    private double amount;
    @Enumerated(EnumType.STRING)
    @Column(name = "process")
    private EnumTypeProcessPayment process;
    @Column(name="created_at")
    private LocalDateTime created_at;
    @Column(name="deleted")
    private boolean isDeleted;
}
