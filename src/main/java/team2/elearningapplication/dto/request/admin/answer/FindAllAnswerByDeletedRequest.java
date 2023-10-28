package team2.elearningapplication.dto.request.admin.answer;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FindAllAnswerByDeletedRequest {
    @NotNull
    private boolean isDeleted;
}
