package team2.elearningapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Accessors(chain = true)

public class HistoryQuizUser {
    private int sessionId;
    private int totalCorrect;
    private int totalIncorrect;
    private LocalDateTime createdAt;
}
