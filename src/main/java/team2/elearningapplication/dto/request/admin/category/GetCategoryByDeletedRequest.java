package team2.elearningapplication.dto.request.admin.category;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GetCategoryByDeletedRequest {
    @NotNull
    private boolean isDeleted;
}
