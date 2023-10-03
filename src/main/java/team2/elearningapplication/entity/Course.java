package team2.elearningapplication.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Entity
@Table(name = "course")
@Accessors(chain = true)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn
    private Category category;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "link_thumnail")
    private String linkThumnail;
    @Column(name="price")
    private double price;
    @Column(name="deleted")
    private boolean isDeleted;
}
