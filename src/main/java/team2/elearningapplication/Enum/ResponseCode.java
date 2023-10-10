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
    COURSE_EXIST(1600, "Course exist"),
    COURSE_NOT_EXIST(1700, "Course not exist"),
    COURSE_LIST_IS_EMPTY(1800,"Course list is empty"),
    CATEGORY_EXIST(1900,"Category exist"),
    CATEGORY_NOT_EXIST(2000,"Category not exist"),
    CATEGORY_LIST_IS_EMPTY(2100,"Cateogry list is empty"),
    LESSON_EXIST(2200, "Lesson exist"),
    LESSON_NOT_EXIST(2300, "Lesson not exist"),
    LESSON_LIST_IS_EMPTY(2400,"Lesson list is empty"),
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