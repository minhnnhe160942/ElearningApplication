

package team2.elearningapplication.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "post")
@Accessors(chain = true)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JoinColumn(name = "lesson_id")
    private int lessonId;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "created_at",columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "deleted")
    private boolean deleted;
    @ManyToOne
    @JoinColumn (name="created_by",referencedColumnName = "id")
    private User userCreated;
    @ManyToOne
    @JoinColumn(name="updated_by",referencedColumnName = "id")
    private User userUpdated;
}
