

package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import typesEnum.EnumTypeProcess;

import java.sql.Timestamp;
import java.time.ZonedDateTime;

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
    private ZonedDateTime createdAt;

    public HistoryRegisterCourse() {
    }

    public HistoryRegisterCourse(int id, User user, Course courseId, int sttLessonCurrent, EnumTypeProcess process, ZonedDateTime createdAt) {
        this.id = id;
        this.user = user;
        this.courseId = courseId;
        this.sttLessonCurrent = sttLessonCurrent;
        this.process = process;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "HistoryRegisterCourse{" +
                "id=" + id +
                ", user=" + user +
                ", courseId=" + courseId +
                ", sttLessonCurrent=" + sttLessonCurrent +
                ", process=" + process +
                ", createdAt=" + createdAt +
                '}';
    }
}