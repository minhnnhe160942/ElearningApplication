

package entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@Entity
@Table(name="post")
@Accessors(chain=true)
@Setter
@Getter

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="content")
    private String content;
    @Column(name="category_id")
    private int categoryId;
}
