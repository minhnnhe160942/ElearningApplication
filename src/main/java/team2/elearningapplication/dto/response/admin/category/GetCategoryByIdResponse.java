package team2.elearningapplication.dto.response.admin.category;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetCategoryByIdResponse {
    @NotNull
    private int id;
    @NotBlank
    private String name;
    @NotNull
    private boolean isDeleted;

}
