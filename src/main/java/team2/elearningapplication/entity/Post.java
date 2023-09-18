

package team2.elearningapplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@Entity
@Table(name = "post")
@Accessors(chain = true)
@Setter
@Getter

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "content")
    private String content;
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "link_thumnail")
    private String linkThumnail;

    public Post() {
    }

    public Post(int id, String name, String content, int categoryId, String linkThumnail) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.categoryId = categoryId;
        this.linkThumnail = linkThumnail;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", categoryId=" + categoryId +
                ", linkThumnail='" + linkThumnail + '\'' +
                '}';
    }
}
