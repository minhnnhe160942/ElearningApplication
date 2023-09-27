package team2.elearningapplication.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class DeleteCategory {
    @NotBlank
    private String name;
    
}
