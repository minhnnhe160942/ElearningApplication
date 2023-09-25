package team2.elearningapplication.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddQuestionResponse {
    private int id;
    private String question;
    private int quiz_id;
    private ZonedDateTime createdAt;
}
