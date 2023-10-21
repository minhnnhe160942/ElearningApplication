package team2.elearningapplication.Enum;

import lombok.Getter;

@Getter
public enum ResponseCode {
    SUCCESS(0, "success"),
    FAIL(1, "fail"),
    USER_NOT_FOUND(1000, "User not exist"),
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
    SYSTEM_ERROR(100,"System Eroor"),
    LESSON_EXIST(2200,"Lesson exist"),
    LESSON_NOT_EXIST(2300,"LESSON NOT EXIST"),
    LESSON_LIST_IS_EMPTY(2400,"LESSON LIST IS EMPTY"),
    QUIZ_EXIST(2500,"QUIZ EXIST"),
    QUIZ_NOT_EXIST(2600,"QUIZ NOT EXIST"),
    QUIZ_LIST_IS_EMPTY(2700,"QUIZ LIST IS EMPTY"),
    POST_IS_EMPTY(2800,"POST IS EMPTY"),
    POST_LIST_IS_EMPTY(2900,"POST LIST IS EMPTY"),
    POST_CONTENT_IS_EMPTY(3000,"POST CONTENT IS EMPTY"),
    POST_NOT_EXIST(3100,"POST NOT EXIST"),
    QUESTION_EXIST(3200,"QUESTION EXIST"),
    QUESTION_NOT_EXIST(3300,"QUESTION NOT EXIST"),
    QUESTION_LIST_IS_EMPTY(3400,"QUESTION LIST IS EMPTY"),
    ANSWER_NOT_EXIST(3500,"ANSWER NOT EXIST IN QUESTION"),
    ANSWER_EXIST(3600,"ANSWER EXIST"),
    ANSWER_LIST_IS_EMPTY(3700,"ANSWER LIST IS EMPTY"),
    INVALID_DATA(9999,"INVALID DATA"),
    ORDER_NOT_EXIST(3800,"ORDER NOT EXIST"),
    PAYMENT_FAIL(3900,"PAYMENT FAIL VNPAY"),
    SEND_URL_PAYMENT_FAIL(4000,"SEND URL PAYMENT FAIL")
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
