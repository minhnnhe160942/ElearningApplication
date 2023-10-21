package team2.elearningapplication.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team2.elearningapplication.Enum.ResponseCode;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.lesson.AddLessonRequest;
import team2.elearningapplication.dto.request.admin.lesson.DeleteLessonRequest;
import team2.elearningapplication.dto.request.admin.lesson.GetLessonByIdRequest;
import team2.elearningapplication.dto.request.admin.lesson.UpdateLessonRequest;
import team2.elearningapplication.dto.response.admin.lesson.*;
import team2.elearningapplication.service.ILessonService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/lesson")
@AllArgsConstructor
public class LessonController {
    private ILessonService lessonService;

    @PostMapping("/add-lesson")
    public ResponseEntity<ResponseCommon<AddLessonResponse>> addLesson(@Valid @RequestBody AddLessonRequest addLessonRequest){
        ResponseCommon<AddLessonResponse> response = lessonService.addLesson(addLessonRequest);
        if (response.getCode() == ResponseCode.SUCCESS.getCode()) {
            return ResponseEntity.ok(response);
        } else if (response.getCode() == ResponseCode.LESSON_EXIST.getCode()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseCommon<>(response.getCode(), "Lesson already exists", null));
        } else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Add lesson failed", null));
        }
    }

    @PutMapping("/update-lesson")
    public ResponseEntity<ResponseCommon<UpdateLessonResponse>> updateLesson(@Valid @RequestBody UpdateLessonRequest updateLessonRequest){
        ResponseCommon<UpdateLessonResponse> response = lessonService.updateLesson(updateLessonRequest);
        if (response.getCode() == ResponseCode.SUCCESS.getCode()) {
            return ResponseEntity.ok(response);
        } else if (response.getCode() == ResponseCode.LESSON_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(), "Lesson does not exist", null));
        } else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Update lesson failed", null));
        }
    }

    @DeleteMapping("/delete-lesson")
    public ResponseEntity<ResponseCommon<DeleteLessonResponse>> deleteLesson(@Valid @RequestBody DeleteLessonRequest deleteLessonRequest){
        ResponseCommon<DeleteLessonResponse> response = lessonService.deleteLesson(deleteLessonRequest);
        if (response.getCode() == ResponseCode.SUCCESS.getCode()) {
            return ResponseEntity.ok(response);
        } else if (response.getCode() == ResponseCode.LESSON_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(), "Lesson does not exist", null));
        } else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Delete lesson failed", null));
        }
    }

    @GetMapping("/find-all-lesson")
    public ResponseEntity<ResponseCommon<FindAllLessonResponse>> findAllLesson(){
        ResponseCommon<FindAllLessonResponse> response = lessonService.findAllLesson();
        if (response.getCode() == ResponseCode.SUCCESS.getCode()) {
            return ResponseEntity.ok(response);
        } else if (response.getCode() == ResponseCode.LESSON_LIST_IS_EMPTY.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(), "Lesson list is empty", null));
        } else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Get All lesson fail", null));
        }
    }

    @GetMapping("/get-lesson-by-id")
    public ResponseEntity<ResponseCommon<GetLessonByIdResponse>> getLessonById(@Valid @RequestBody GetLessonByIdRequest request){
        ResponseCommon<GetLessonByIdResponse> response = lessonService.getLessonById(request);
        if (response.getCode() == ResponseCode.SUCCESS.getCode()) {
            return ResponseEntity.ok(response);
        } else if (response.getCode() == ResponseCode.LESSON_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(), "Lesson not exist", null));
        } else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Get lesson by id fail", null));
        }
    }
}
