package team2.elearningapplication.dto.request.admin.lesson;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FindLessonByDeletedRequest {
    @NotNull
    private boolean deleted;
}
