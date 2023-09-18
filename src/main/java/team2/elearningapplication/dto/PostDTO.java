package team2.elearningapplication.dto;

public class PostDTO {
    private Integer id;
    private String name;
    private String content;
    private Integer categoryId;
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

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getLinkThummail() {
        return this.linkThummail;
    }

    public void setLinkThummail(String linkThummail) {
        this.linkThummail = linkThummail;
    }
}
