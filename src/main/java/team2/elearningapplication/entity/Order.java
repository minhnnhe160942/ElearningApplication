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
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private User user;
    @Column(name="payment_id")
    private int paymentId;
    @OneToOne
    @JoinColumn(name="course_id",referencedColumnName = "id")
    private Course course;
    @Column(name="amount")
    private double amount;
    @Enumerated(EnumType.STRING)
    @Column(name = "process")
    private EnumTypeProcessPayment enumTypeProcessPayment;
    @Column(name="created_at")
    private LocalDateTime created_at;
    @Column(name="deleted")
    private boolean isDeleted;
    @Column(name = "checksum")
    private String checksum;
}
