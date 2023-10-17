package team2.elearningapplication.dto.request.admin.lesson;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetLessonByIdRequest {
    @NotNull
    private int id;
}
