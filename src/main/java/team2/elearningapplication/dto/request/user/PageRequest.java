package team2.elearningapplication.dto.request.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageRequest {
    @NotNull
    private int pageNo;
    @NotNull
    private int pageSize;
    @NotBlank
    private String sortBy;
    @NotBlank
    private String sortDir;
}
