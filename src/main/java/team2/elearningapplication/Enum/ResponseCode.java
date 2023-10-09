package team2.elearningapplication.Enum;

import lombok.Getter;

@Getter
public enum ResponseCode {
    SUCCESS(0, "success"),
    FAIL(1, "fail"),
    USER_NOT_FOUND(1000, "User not found"),
    PASSWORD_INCORRECT(1100,"Password incorrect"),
    OTP_INCORRECT(1200,"OTP incorrect"),
    Expired_OTP(1300,"Expired OTP"),
    USER_EXIST(1400,"User exist"),
    OLD_PASSWORD_INCORRECT(1500,"Old password incorrect"),
    COURSE_EXIST(1500, "Course exist"),
    COURSE_NOT_EXIST(1600, "Course not exist"),
    CATEGORY_EXIST(1700,"Category exist"),
    CATEGORY_NOT_EXIST(1800,"Category not exist"),
    SYSTEM_ERROR(100,"System Eroor"),
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
