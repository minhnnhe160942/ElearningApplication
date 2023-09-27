package team2.elearningapplication.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team2.elearningapplication.entity.Category;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCourseRequest {
    @NotBlank
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private Category category;
    @NotBlank
    private ZonedDateTime createdAt;
    @NotBlank
    private String linkThumnail;
}
