package team2.elearningapplication.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team2.elearningapplication.Enum.ResponseCode;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.course.AddCourseRequest;
import team2.elearningapplication.dto.response.admin.course.AddCourseResponse;
import team2.elearningapplication.service.ICourseService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/course")
@AllArgsConstructor
public class CourseController {
    private ICourseService courseService;

    @PostMapping("/add-course")
    public ResponseEntity<ResponseCommon<AddCourseResponse>> addCourse(@Valid @RequestBody AddCourseRequest addCourseRequest){
        ResponseCommon<AddCourseResponse> response = courseService.addCourse(addCourseRequest);
        // if code of response equal code SUCCESS  -> return ok
        if(response.getCode() == ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } else if(response.getCode() == ResponseCode.COURSE_EXIST.getCode()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseCommon<>(response.getCode(),"Course already exsit",null));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseCommon<>(ResponseCode.SYSTEM_ERROR.getCode(),"System error",null));
        }
    }
}