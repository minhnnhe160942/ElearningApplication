package team2.elearningapplication.Enum;

import lombok.Getter;

@Getter
public enum ResponseCode {
    SUCCESS(0, "success"),
    FAIL(1, "fail"),
    USER_NOT_FOUND(1000, "User not found"),
    ;
    private int code;

    private String message;

    ResponseCode() {
    }

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
