

package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import typesEnum.EnumTypeProcess;

import java.sql.Timestamp;

@Entity
@Table(name = "history_register_course")
@Accessors(chain = true)
@Setter
@Getter

public class HistoryRegisterCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;
    @Column(name = "course_id")
    private int courseId;
    @Column(name = "stt_lession_current")
    private int sttLessonCurrent;
    @Enumerated(EnumType.STRING)
    @Column(name = "process")
    private EnumTypeProcess process;
    @Column(name = "created_at")
    private Timestamp createdAt;
}