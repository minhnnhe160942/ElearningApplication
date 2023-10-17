package team2.elearningapplication.dto.request.admin.course;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetCourseByIdRequest {
    @NotNull
    private int id;
}
