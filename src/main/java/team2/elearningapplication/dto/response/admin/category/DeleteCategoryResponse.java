package team2.elearningapplication.dto.response.admin.category;

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
public class DeleteCategoryResponse {
    @NotNull
    private int categoryID;
    @NotBlank
    private String categoryName;
    @NotNull
    private boolean isDeleted;
    @NotBlank
    private String createdBy;
    @NotBlank
    private String updatedBy;
}
