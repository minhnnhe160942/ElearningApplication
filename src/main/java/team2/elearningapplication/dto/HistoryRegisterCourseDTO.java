package team2.elearningapplication.dto;

import java.time.LocalDateTime;

public class HistoryRegisterCourseDTO {
    private Integer id;
    private Integer userId;
    private Integer courseId;
    private Integer sttLessionCurrent;
    private String process;
    private LocalDateTime createdAt;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCourseId() {
        return this.courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getSttLessionCurrent() {
        return this.sttLessionCurrent;
    }

    public void setSttLessionCurrent(Integer sttLessionCurrent) {
        this.sttLessionCurrent = sttLessionCurrent;
    }

    public String getProcess() {
        return this.process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
