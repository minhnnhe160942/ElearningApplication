package team2.elearningapplication.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "blog")
@Accessors(chain = true)
@Data
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn (name="created_by",referencedColumnName = "id")
    private User userCreated;
    @ManyToOne
    @JoinColumn(name="updated_by",referencedColumnName = "id")
    private User userUpdated;
    @Column(name="title")
    private String title;
    @Column(name="content")
    private String content;
    @Column(name="link_thumnail")
    private String linkThumnail;

}
