package team2.elearningapplication.dto.request.admin.question;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FindQuestionByDeletedRequest {
    @NotNull
    private boolean deleted;
}
