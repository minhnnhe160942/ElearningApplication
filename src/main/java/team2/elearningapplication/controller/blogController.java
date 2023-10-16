package team2.elearningapplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import team2.elearningapplication.Enum.ResponseCode;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.course.AddCourseRequest;
import team2.elearningapplication.dto.response.admin.course.AddCourseResponse;

import javax.validation.Valid;

public class blogController {
    @PostMapping("/quiz")
    public QuizResult takeQuiz(@RequestBody List<String> answers) {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (i < answers.size() && answers.get(i).equalsIgnoreCase(questions.get(i).getAnswer())) {
                score++;
            }
        }
        return new QuizResult(score);
    }
    @PostMapping("/quiz")
    public QuizResult takeQuiz(@RequestBody List<String> answers) {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (i < answers.size() && answers.get(i).equalsIgnoreCase(questions.get(i).getAnswer())) {
                score++;
            }
        }
        return new QuizResult(score);
    }
    @PostMapping("/quiz")
    public QuizResult takeQuiz(@RequestBody List<String> answers) {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (i < answers.size() && answers.get(i).equalsIgnoreCase(questions.get(i).getAnswer())) {
                score++;
            }
        }
        return new QuizResult(score);
    }
    @PostMapping("/quiz")
    public QuizResult takeQuiz(@RequestBody List<String> answers) {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (i < answers.size() && answers.get(i).equalsIgnoreCase(questions.get(i).getAnswer())) {
                score++;
            }
        }
        return new QuizResult(score);
    }
    @PostMapping("/quiz")
    public QuizResult takeQuiz(@RequestBody List<String> answers) {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (i < answers.size() && answers.get(i).equalsIgnoreCase(questions.get(i).getAnswer())) {
                score++;
            }
        }
        return new QuizResult(score);
    }
    @PostMapping("/quiz")
    public QuizResult takeQuiz(@RequestBody List<String> answers) {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (i < answers.size() && answers.get(i).equalsIgnoreCase(questions.get(i).getAnswer())) {
                score++;
            }
        }
        return new QuizResult(score);
    }
    @PostMapping("/quiz")
    public QuizResult takeQuiz(@RequestBody List<String> answers) {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (i < answers.size() && answers.get(i).equalsIgnoreCase(questions.get(i).getAnswer())) {
                score++;
            }
        }
        return new QuizResult(score);
    }
    @PostMapping("/quiz")
    public QuizResult takeQuiz(@RequestBody List<String> answers) {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (i < answers.size() && answers.get(i).equalsIgnoreCase(questions.get(i).getAnswer())) {
                score++;
            }
        }
        return new QuizResult(score);
    }
    @PostMapping("/add-course")
    public ResponseEntity<ResponseCommon<AddCourseResponse>> addCourse(@Valid @RequestBody AddCourseRequest addCourseRequest){
        ResponseCommon<AddCourseResponse> response = courseService.addCourse(addCourseRequest);
        // if code of response equal code SUCCESS  -> return ok
        if(response.getCode() == ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } else if(response.getCode() == ResponseCode.COURSE_EXIST.getCode()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseCommon<>(response.getCode(),"Course already exsit",null));
        } else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Add course fail",null));
        }
    }
    @PostMapping("/quiz")
    public QuizResult takeQuiz(@RequestBody List<String> answers) {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (i < answers.size() && answers.get(i).equalsIgnoreCase(questions.get(i).getAnswer())) {
                score++;
            }
        }
        return new QuizResult(score);
    }
    @PostMapping("/add-course")
    public ResponseEntity<ResponseCommon<AddCourseResponse>> addCourse(@Valid @RequestBody AddCourseRequest addCourseRequest){
        ResponseCommon<AddCourseResponse> response = courseService.addCourse(addCourseRequest);
        // if code of response equal code SUCCESS  -> return ok
        if(response.getCode() == ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } else if(response.getCode() == ResponseCode.COURSE_EXIST.getCode()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseCommon<>(response.getCode(),"Course already exsit",null));
        } else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Add course fail",null));
        }
    }
    @PostMapping("/quiz")
    public QuizResult takeQuiz(@RequestBody List<String> answers) {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (i < answers.size() && answers.get(i).equalsIgnoreCase(questions.get(i).getAnswer())) {
                score++;
            }
        }
        return new QuizResult(score);
    }
    @PostMapping("/add-course")
    public ResponseEntity<ResponseCommon<AddCourseResponse>> addCourse(@Valid @RequestBody AddCourseRequest addCourseRequest){
        ResponseCommon<AddCourseResponse> response = courseService.addCourse(addCourseRequest);
        // if code of response equal code SUCCESS  -> return ok
        if(response.getCode() == ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } else if(response.getCode() == ResponseCode.COURSE_EXIST.getCode()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseCommon<>(response.getCode(),"Course already exsit",null));
        } else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Add course fail",null));
        }
    }
    @PostMapping("/quiz")
    public QuizResult takeQuiz(@RequestBody List<String> answers) {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (i < answers.size() && answers.get(i).equalsIgnoreCase(questions.get(i).getAnswer())) {
                score++;
            }
        }
        return new QuizResult(score);
    }
    @PostMapping("/add-course")
    public ResponseEntity<ResponseCommon<AddCourseResponse>> addCourse(@Valid @RequestBody AddCourseRequest addCourseRequest){
        ResponseCommon<AddCourseResponse> response = courseService.addCourse(addCourseRequest);
        // if code of response equal code SUCCESS  -> return ok
        if(response.getCode() == ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } else if(response.getCode() == ResponseCode.COURSE_EXIST.getCode()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseCommon<>(response.getCode(),"Course already exsit",null));
        } else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Add course fail",null));
        }
    }
    @PostMapping("/quiz")
    public QuizResult takeQuiz(@RequestBody List<String> answers) {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (i < answers.size() && answers.get(i).equalsIgnoreCase(questions.get(i).getAnswer())) {
                score++;
            }
        }
        return new QuizResult(score);
    }
    @PostMapping("/add-course")
    public ResponseEntity<ResponseCommon<AddCourseResponse>> addCourse(@Valid @RequestBody AddCourseRequest addCourseRequest){
        ResponseCommon<AddCourseResponse> response = courseService.addCourse(addCourseRequest);
        // if code of response equal code SUCCESS  -> return ok
        if(response.getCode() == ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } else if(response.getCode() == ResponseCode.COURSE_EXIST.getCode()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseCommon<>(response.getCode(),"Course already exsit",null));
        } else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Add course fail",null));
        }
    }
    @PostMapping("/quiz")
    public QuizResult takeQuiz(@RequestBody List<String> answers) {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (i < answers.size() && answers.get(i).equalsIgnoreCase(questions.get(i).getAnswer())) {
                score++;
            }
        }
        return new QuizResult(score);
    }
    @PostMapping("/add-course")
    public ResponseEntity<ResponseCommon<AddCourseResponse>> addCourse(@Valid @RequestBody AddCourseRequest addCourseRequest){
        ResponseCommon<AddCourseResponse> response = courseService.addCourse(addCourseRequest);
        // if code of response equal code SUCCESS  -> return ok
        if(response.getCode() == ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } else if(response.getCode() == ResponseCode.COURSE_EXIST.getCode()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseCommon<>(response.getCode(),"Course already exsit",null));
        } else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Add course fail",null));
        }
    }    @PostMapping("/quiz")
    public QuizResult takeQuiz(@RequestBody List<String> answers) {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (i < answers.size() && answers.get(i).equalsIgnoreCase(questions.get(i).getAnswer())) {
                score++;
            }
        }
        return new QuizResult(score);
    }
    @PostMapping("/add-course")
    public ResponseEntity<ResponseCommon<AddCourseResponse>> addCourse(@Valid @RequestBody AddCourseRequest addCourseRequest){
        ResponseCommon<AddCourseResponse> response = courseService.addCourse(addCourseRequest);
        // if code of response equal code SUCCESS  -> return ok
        if(response.getCode() == ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } else if(response.getCode() == ResponseCode.COURSE_EXIST.getCode()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseCommon<>(response.getCode(),"Course already exsit",null));
        } else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Add course fail",null));
        }
    }
    @PostMapping("/quiz")
    public QuizResult takeQuiz(@RequestBody List<String> answers) {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (i < answers.size() && answers.get(i).equalsIgnoreCase(questions.get(i).getAnswer())) {
                score++;
            }
        }
        return new QuizResult(score);
    }
    @PostMapping("/add-course")
    public ResponseEntity<ResponseCommon<AddCourseResponse>> addCourse(@Valid @RequestBody AddCourseRequest addCourseRequest){
        ResponseCommon<AddCourseResponse> response = courseService.addCourse(addCourseRequest);
        // if code of response equal code SUCCESS  -> return ok
        if(response.getCode() == ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } else if(response.getCode() == ResponseCode.COURSE_EXIST.getCode()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseCommon<>(response.getCode(),"Course already exsit",null));
        } else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Add course fail",null));
        }
    }
    @PostMapping("/quiz")
    public QuizResult takeQuiz(@RequestBody List<String> answers) {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (i < answers.size() && answers.get(i).equalsIgnoreCase(questions.get(i).getAnswer())) {
                score++;
            }
        }
        return new QuizResult(score);
    }
    @PostMapping("/add-course")
    public ResponseEntity<ResponseCommon<AddCourseResponse>> addCourse(@Valid @RequestBody AddCourseRequest addCourseRequest){
        ResponseCommon<AddCourseResponse> response = courseService.addCourse(addCourseRequest);
        // if code of response equal code SUCCESS  -> return ok
        if(response.getCode() == ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } else if(response.getCode() == ResponseCode.COURSE_EXIST.getCode()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseCommon<>(response.getCode(),"Course already exsit",null));
        } else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Add course fail",null));
        }
    }    @PostMapping("/quiz")
    public QuizResult takeQuiz(@RequestBody List<String> answers) {
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (i < answers.size() && answers.get(i).equalsIgnoreCase(questions.get(i).getAnswer())) {
                score++;
            }
        }
        return new QuizResult(score);
    }
    @PostMapping("/add-course")
    public ResponseEntity<ResponseCommon<AddCourseResponse>> addCourse(@Valid @RequestBody AddCourseRequest addCourseRequest){
        ResponseCommon<AddCourseResponse> response = courseService.addCourse(addCourseRequest);
        // if code of response equal code SUCCESS  -> return ok
        if(response.getCode() == ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } else if(response.getCode() == ResponseCode.COURSE_EXIST.getCode()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseCommon<>(response.getCode(),"Course already exsit",null));
        } else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Add course fail",null));
        }
    }

}
