package team2.elearningapplication.dto.response.admin.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team2.elearningapplication.entity.Category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeleteCourseResponse {
    @NotNull
    private int courseID;
    @NotBlank
    private String courseName;
    @NotBlank
    private String description;
    @NotEmpty
    private Category category;
    @NotNull
    private double price;
    @NotBlank
    private String linkThumail;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private boolean isDeleted;
}
