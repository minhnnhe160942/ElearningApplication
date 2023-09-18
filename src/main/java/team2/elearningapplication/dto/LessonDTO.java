package team2.elearningapplication.dto;

import java.time.LocalDateTime;

public class LessonDTO {
    private Integer id;
    private Integer stt;
    private Integer courseId;
    private String linkContent;
    private String description;
    private LocalDateTime createdAt;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStt() {
        return this.stt;
    }

    public void setStt(Integer stt) {
        this.stt = stt;
    }

    public Integer getCourseId() {
        return this.courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getLinkContent() {
        return this.linkContent;
    }

    public void setLinkContent(String linkContent) {
        this.linkContent = linkContent;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
