package team2.elearningapplication.dto.request.admin.category;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetCategoryByIdRequest {
    @NotNull
    private int id;
}
