package team2.elearningapplication.dto.response.admin.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddCategoryResponse {
    @NotBlank
    private String message;
}
