package team2.elearningapplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import team2.elearningapplication.Enum.ResponseCode;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.course.AddCourseRequest;
import team2.elearningapplication.dto.request.admin.course.DeleteCourseRequest;
import team2.elearningapplication.dto.request.admin.course.UpdateCourseRequest;
import team2.elearningapplication.dto.response.admin.course.AddCourseResponse;
import team2.elearningapplication.dto.response.admin.course.DeleteCourseResponse;
import team2.elearningapplication.dto.response.admin.course.UpdateCourseResponse;

import javax.validation.Valid;

public class commitController {
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

    @PostMapping("/update-course")
    public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse(@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
        ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update course fail",null));
        }
    }

    @PostMapping("/delete-course")
    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
        }
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

    @PostMapping("/update-course")
    public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse(@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
        ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update course fail",null));
        }
    }

    @PostMapping("/delete-course")
    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
        }
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

    @PostMapping("/update-course")
    public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse(@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
        ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update course fail",null));
        }
    }

    @PostMapping("/delete-course")
    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
        }
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

    @PostMapping("/update-course")
    public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse(@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
        ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update course fail",null));
        }
    }

    @PostMapping("/delete-course")
    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
        }
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

    @PostMapping("/update-course")
    public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse(@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
        ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update course fail",null));
        }
    }

    @PostMapping("/delete-course")
    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
        }
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

    @PostMapping("/update-course")
    public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse(@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
        ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update course fail",null));
        }
    }

    @PostMapping("/delete-course")
    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
        }
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

    @PostMapping("/update-course")
    public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse(@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
        ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update course fail",null));
        }
    }

    @PostMapping("/delete-course")
    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
        }
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

    @PostMapping("/update-course")
    public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse(@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
        ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update course fail",null));
        }
    }

    @PostMapping("/delete-course")
    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
        }
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

    @PostMapping("/update-course")
    public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse(@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
        ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update course fail",null));
        }
    }

    @PostMapping("/delete-course")
    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
        }
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

    @PostMapping("/update-course")
    public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse(@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
        ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update course fail",null));
        }
    }

    @PostMapping("/delete-course")
    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
        }
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

    @PostMapping("/update-course")
    public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse(@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
        ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update course fail",null));
        }
    }

    @PostMapping("/delete-course")
    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
        }
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

    @PostMapping("/update-course")
    public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse(@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
        ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update course fail",null));
        }
    }

    @PostMapping("/delete-course")
    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
        }
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

    @PostMapping("/update-course")
    public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse(@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
        ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update course fail",null));
        }
    }

    @PostMapping("/delete-course")
    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
        }
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

    @PostMapping("/update-course")
    public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse(@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
        ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update course fail",null));
        }
    }

    @PostMapping("/delete-course")
    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
        }
    }
    @PostMapping("/delete-course")
    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
        }
    }    @PostMapping("/update-course")
    public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse(@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
        ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update course fail",null));
        }
    }

    @PostMapping("/delete-course")
    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
        }
    }
    @PostMapping("/delete-course")
    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
        }
    }    @PostMapping("/update-course")
    public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse(@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
        ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update course fail",null));
        }
    }

    @PostMapping("/delete-course")
    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
        }
    }
    @PostMapping("/delete-course")
    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
        }
    }    @PostMapping("/update-course")
    public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse(@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
        ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update course fail",null));
        }
    }

    @PostMapping("/delete-course")
    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
        }
    }
    @PostMapping("/delete-course")
    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
        }
    }    @PostMapping("/update-course")
    public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse(@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
        ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update course fail",null));
        }
    }

    @PostMapping("/delete-course")
    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
        }
    }
    @PostMapping("/delete-course")
    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
        }
    }    @PostMapping("/delete-course")
    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
        }if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
    }if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);if(response.getCode()==ResponseCode.SUCCESS.getCode()) {
                return ResponseEntity.ok(response);
                if (response.getCode() == ResponseCode.SUCCESS.getCode()) {
                    return ResponseEntity.ok(response);
                    if (response.getCode() == ResponseCode.SUCCESS.getCode()) {
                        return ResponseEntity.ok(response);
                    }
                    @PostMapping("/delete-course")
                    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse
                    (@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
                        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
                        // if code of response equal code success -> return ok
                        if (response.getCode() == ResponseCode.SUCCESS.getCode()) {
                            return ResponseEntity.ok(response);
                        } // if code equal course not exist -> tell error
                        else if (response.getCode() == ResponseCode.COURSE_NOT_EXIST.getCode()) {
                            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(), "Course not exist", null));
                        } // else -> return fail  update
                        else {
                            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Delete course fail", null));
                        }
                    }
                    @PostMapping("/update-course")
                    public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse
                    (@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
                        ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
                        // if code of response equal code success -> return ok
                        if (response.getCode() == ResponseCode.SUCCESS.getCode()) {
                            return ResponseEntity.ok(response);
                        } // if code equal course not exist -> tell error
                        else if (response.getCode() == ResponseCode.COURSE_NOT_EXIST.getCode()) {
                            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(), "Course not exist", null));
                        } // else -> return fail  update
                        else {
                            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Update course fail", null));
                        }
                    }

                    @PostMapping("/delete-course")
                    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse
                    (@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
                        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
                        // if code of response equal code success -> return ok
                        if (response.getCode() == ResponseCode.SUCCESS.getCode()) {
                            return ResponseEntity.ok(response);
                        } // if code equal course not exist -> tell error
                        else if (response.getCode() == ResponseCode.COURSE_NOT_EXIST.getCode()) {
                            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(), "Course not exist", null));
                        } // else -> return fail  update
                        else {
                            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Delete course fail", null));
                        }
                    }
                    @PostMapping("/delete-course")
                    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse
                    (@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
                        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
                        // if code of response equal code success -> return ok
                        if (response.getCode() == ResponseCode.SUCCESS.getCode()) {
                            return ResponseEntity.ok(response);
                        } // if code equal course not exist -> tell error
                        else if (response.getCode() == ResponseCode.COURSE_NOT_EXIST.getCode()) {
                            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(), "Course not exist", null));
                        } // else -> return fail  update
                        else {
                            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Delete course fail", null));
                        }
                    }
                    @PostMapping("/update-course")
                    public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse
                    (@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
                        ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
                        // if code of response equal code success -> return ok
                        if (response.getCode() == ResponseCode.SUCCESS.getCode()) {
                            return ResponseEntity.ok(response);
                        } // if code equal course not exist -> tell error
                        else if (response.getCode() == ResponseCode.COURSE_NOT_EXIST.getCode()) {
                            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(), "Course not exist", null));
                        } // else -> return fail  update
                        else {
                            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Update course fail", null));
                        }
                    }

                    @PostMapping("/delete-course")
                    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse
                    (@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
                        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
                        // if code of response equal code success -> return ok
                        if (response.getCode() == ResponseCode.SUCCESS.getCode()) {
                            return ResponseEntity.ok(response);
                        } // if code equal course not exist -> tell error
                        else if (response.getCode() == ResponseCode.COURSE_NOT_EXIST.getCode()) {
                            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(), "Course not exist", null));
                        } // else -> return fail  update
                        else {
                            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Delete course fail", null));
                        }
                    }
                }
                @PostMapping("/add-course")
                public ResponseEntity<ResponseCommon<AddCourseResponse>> addCourse (@Valid @RequestBody AddCourseRequest
                addCourseRequest){
                    ResponseCommon<AddCourseResponse> response = courseService.addCourse(addCourseRequest);
                    // if code of response equal code SUCCESS  -> return ok
                    if (response.getCode() == ResponseCode.SUCCESS.getCode()) {
                        return ResponseEntity.ok(response);
                    } else if (response.getCode() == ResponseCode.COURSE_EXIST.getCode()) {
                        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseCommon<>(response.getCode(), "Course already exsit", null));
                    } else {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Add course fail", null));
                    }
                }

                @PostMapping("/update-course")
                public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse
                (@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
                    ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
                    // if code of response equal code success -> return ok
                    if (response.getCode() == ResponseCode.SUCCESS.getCode()) {
                        return ResponseEntity.ok(response);
                    } // if code equal course not exist -> tell error
                    else if (response.getCode() == ResponseCode.COURSE_NOT_EXIST.getCode()) {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(), "Course not exist", null));
                    } // else -> return fail  update
                    else {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Update course fail", null));
                    }
                }

                @PostMapping("/delete-course")
                public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse
                (@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
                    ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
                    // if code of response equal code success -> return ok
                    if (response.getCode() == ResponseCode.SUCCESS.getCode()) {
                        return ResponseEntity.ok(response);
                    } // if code equal course not exist -> tell error
                    else if (response.getCode() == ResponseCode.COURSE_NOT_EXIST.getCode()) {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(), "Course not exist", null));
                    } // else -> return fail  update
                    else {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Delete course fail", null));
                    }
                }
                @PostMapping("/add-course")
                public ResponseEntity<ResponseCommon<AddCourseResponse>> addCourse (@Valid @RequestBody AddCourseRequest
                addCourseRequest){
                    ResponseCommon<AddCourseResponse> response = courseService.addCourse(addCourseRequest);
                    // if code of response equal code SUCCESS  -> return ok
                    if (response.getCode() == ResponseCode.SUCCESS.getCode()) {
                        return ResponseEntity.ok(response);
                    } else if (response.getCode() == ResponseCode.COURSE_EXIST.getCode()) {
                        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseCommon<>(response.getCode(), "Course already exsit", null));
                    } else {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Add course fail", null));
                    }
                }@PostMapping("/add-course")
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

                @PostMapping("/update-course")
                public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse(@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
                    ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
                    // if code of response equal code success -> return ok
                    if(response.getCode()==ResponseCode.SUCCESS.getCode()){
                        return ResponseEntity.ok(response);
                    } // if code equal course not exist -> tell error
                    else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
                    } // else -> return fail  update
                    else {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update course fail",null));
                    }
                }

                @PostMapping("/delete-course")
                public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
                    ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
                    // if code of response equal code success -> return ok
                    if(response.getCode()==ResponseCode.SUCCESS.getCode()){
                        return ResponseEntity.ok(response);
                    } // if code equal course not exist -> tell error
                    else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
                    } // else -> return fail  update
                    else {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
                    }
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
                }@PostMapping("/add-course")
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

                @PostMapping("/update-course")
                public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse(@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
                    ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
                    // if code of response equal code success -> return ok
                    if(response.getCode()==ResponseCode.SUCCESS.getCode()){
                        return ResponseEntity.ok(response);
                    } // if code equal course not exist -> tell error
                    else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
                    } // else -> return fail  update
                    else {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update course fail",null));
                    }
                }

                @PostMapping("/delete-course")
                public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
                    ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
                    // if code of response equal code success -> return ok
                    if(response.getCode()==ResponseCode.SUCCESS.getCode()){
                        return ResponseEntity.ok(response);
                    } // if code equal course not exist -> tell error
                    else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
                    } // else -> return fail  update
                    else {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
                    }
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

                @PostMapping("/update-course")
                public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse(@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
                    ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
                    // if code of response equal code success -> return ok
                    if(response.getCode()==ResponseCode.SUCCESS.getCode()){
                        return ResponseEntity.ok(response);
                    } // if code equal course not exist -> tell error
                    else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
                    } // else -> return fail  update
                    else {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update course fail",null));
                    }
                }

                @PostMapping("/delete-course")
                public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
                    ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
                    // if code of response equal code success -> return ok
                    if(response.getCode()==ResponseCode.SUCCESS.getCode()){
                        return ResponseEntity.ok(response);
                    } // if code equal course not exist -> tell error
                    else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
                    } // else -> return fail  update
                    else {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
                    }
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
                }@PostMapping("/add-course")
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

                @PostMapping("/update-course")
                public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse(@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
                    ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
                    // if code of response equal code success -> return ok
                    if(response.getCode()==ResponseCode.SUCCESS.getCode()){
                        return ResponseEntity.ok(response);
                    } // if code equal course not exist -> tell error
                    else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
                    } // else -> return fail  update
                    else {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update course fail",null));
                    }
                }

                @PostMapping("/delete-course")
                public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
                    ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
                    // if code of response equal code success -> return ok
                    if(response.getCode()==ResponseCode.SUCCESS.getCode()){
                        return ResponseEntity.ok(response);
                    } // if code equal course not exist -> tell error
                    else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
                    } // else -> return fail  update
                    else {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
                    }
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

                @PostMapping("/update-course")
                public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse(@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
                    ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
                    // if code of response equal code success -> return ok
                    if(response.getCode()==ResponseCode.SUCCESS.getCode()){
                        return ResponseEntity.ok(response);
                    } // if code equal course not exist -> tell error
                    else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
                    } // else -> return fail  update
                    else {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update course fail",null));
                    }
                }

                @PostMapping("/delete-course")
                public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
                    ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
                    // if code of response equal code success -> return ok
                    if(response.getCode()==ResponseCode.SUCCESS.getCode()){
                        return ResponseEntity.ok(response);
                    } // if code equal course not exist -> tell error
                    else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
                    } // else -> return fail  update
                    else {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
                    }
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
                }@PostMapping("/add-course")
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

                @PostMapping("/update-course")
                public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse(@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
                    ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
                    // if code of response equal code success -> return ok
                    if(response.getCode()==ResponseCode.SUCCESS.getCode()){
                        return ResponseEntity.ok(response);
                    } // if code equal course not exist -> tell error
                    else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
                    } // else -> return fail  update
                    else {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update course fail",null));
                    }
                }

                @PostMapping("/delete-course")
                public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
                    ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
                    // if code of response equal code success -> return ok
                    if(response.getCode()==ResponseCode.SUCCESS.getCode()){
                        return ResponseEntity.ok(response);
                    } // if code equal course not exist -> tell error
                    else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
                    } // else -> return fail  update
                    else {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
                    }
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

                @PostMapping("/update-course")
                public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse(@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
                    ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
                    // if code of response equal code success -> return ok
                    if(response.getCode()==ResponseCode.SUCCESS.getCode()){
                        return ResponseEntity.ok(response);
                    } // if code equal course not exist -> tell error
                    else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
                    } // else -> return fail  update
                    else {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update course fail",null));
                    }
                }

                @PostMapping("/delete-course")
                public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
                    ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
                    // if code of response equal code success -> return ok
                    if(response.getCode()==ResponseCode.SUCCESS.getCode()){
                        return ResponseEntity.ok(response);
                    } // if code equal course not exist -> tell error
                    else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
                    } // else -> return fail  update
                    else {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
                    }
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

                @PostMapping("/update-course")
                public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse(@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
                    ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
                    // if code of response equal code success -> return ok
                    if(response.getCode()==ResponseCode.SUCCESS.getCode()){
                        return ResponseEntity.ok(response);
                    } // if code equal course not exist -> tell error
                    else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
                    } // else -> return fail  update
                    else {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update course fail",null));
                    }
                }

                @PostMapping("/delete-course")
                public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
                    ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
                    // if code of response equal code success -> return ok
                    if(response.getCode()==ResponseCode.SUCCESS.getCode()){
                        return ResponseEntity.ok(response);
                    } // if code equal course not exist -> tell error
                    else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
                    } // else -> return fail  update
                    else {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
                    }
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

                @PostMapping("/update-course")
                public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse(@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
                    ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
                    // if code of response equal code success -> return ok
                    if(response.getCode()==ResponseCode.SUCCESS.getCode()){
                        return ResponseEntity.ok(response);
                    } // if code equal course not exist -> tell error
                    else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
                    } // else -> return fail  update
                    else {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update course fail",null));
                    }
                }

                @PostMapping("/delete-course")
                public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
                    ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
                    // if code of response equal code success -> return ok
                    if(response.getCode()==ResponseCode.SUCCESS.getCode()){
                        return ResponseEntity.ok(response);
                    } // if code equal course not exist -> tell error
                    else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
                    } // else -> return fail  update
                    else {
                        return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
                    }
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
