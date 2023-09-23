package team2.elearningapplication.exceptions;

import lombok.Getter;
import lombok.Setter;
import team2.elearningapplication.Enum.ResponseCode;

@Getter
@Setter
public class BussinessException extends Exception {
    private int code;
    private String message;

    public BussinessException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }
}
