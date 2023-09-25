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
public class AddAnswerResponse {
    private int id;
    private String answerContent;
    private int questionId;
    private ZonedDateTime createdAt;
}
