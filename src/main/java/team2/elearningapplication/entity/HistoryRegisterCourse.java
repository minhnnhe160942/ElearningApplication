

package team2.elearningapplication.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import team2.elearningapplication.Enum.EnumTypeProcess;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Entity
@Table(name = "history_register_course")
@Accessors(chain = true)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HistoryRegisterCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course courseId;
    @Column(name = "stt_lession_current")
    private int sttLessonCurrent;
    @Enumerated(EnumType.STRING)
    @Column(name = "process")
    private EnumTypeProcess process;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @OneToOne
    @JoinColumn(name="payment_id",referencedColumnName = "id")
    private Payment payment;

}