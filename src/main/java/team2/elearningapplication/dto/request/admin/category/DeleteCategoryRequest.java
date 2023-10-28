package team2.elearningapplication.dto.request.admin.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeleteCategoryRequest {
    @NotBlank
    private String username;
    @NotNull
    private int categoryID;
}
