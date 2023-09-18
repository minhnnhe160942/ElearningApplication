package team2.elearningapplication.dto;

import java.time.LocalDateTime;

public class CourseDTO {
    private Integer id;
    private String name;
    private String description;
    private Integer categoryId;
    private LocalDateTime createdAt;
    private String linkThummail;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getLinkThummail() {
        return this.linkThummail;
    }

    public void setLinkThummail(String linkThummail) {
        this.linkThummail = linkThummail;
    }
}
