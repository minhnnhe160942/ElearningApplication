package team2.elearningapplication.Enum;

import lombok.Getter;

@Getter
public enum ResponseCode {
    SUCCESS(0, "success"),
    FAIL(1, "fail"),
    USER_NOT_FOUND(1000, "User not found"),
<<<<<<< HEAD
    ;
=======
    PASSWORD_INCORRECT(1100,"Password incorrect"),
    OTP_INCORRECT(1200,"OTP incorrect"),
    Expired_OTP(1300,"Expired OTP"),
    USER_EXIST(1400,"User exist");
>>>>>>> main
    private int code;

    private String message;

    ResponseCode() {
    }

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
