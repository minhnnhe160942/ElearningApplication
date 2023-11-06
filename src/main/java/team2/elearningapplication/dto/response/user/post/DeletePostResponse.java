package team2.elearningapplication.dto.response.user.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeletePostResponse {
    @NotBlank
    private int postID;
    @NotNull
    private String email;
    @NotNull
    private int courseId;
    @NotBlank
    private String content;
    @NotNull
    private LocalDateTime updateAt;
    @NotNull
    private boolean isDeleted;
}
