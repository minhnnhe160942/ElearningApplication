package team2.elearningapplication.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team2.elearningapplication.Enum.ResponseCode;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.lesson.AddLessonRequest;
import team2.elearningapplication.dto.request.admin.lesson.DeleteLessonRequest;
import team2.elearningapplication.dto.request.admin.lesson.UpdateLessonRequest;
import team2.elearningapplication.dto.response.admin.lesson.AddLessonResponse;
import team2.elearningapplication.dto.response.admin.lesson.DeleteLessonResponse;
import team2.elearningapplication.dto.response.admin.lesson.GetAllLessonResponse;
import team2.elearningapplication.dto.response.admin.lesson.UpdateLessonResponse;
import team2.elearningapplication.entity.Lesson;
import team2.elearningapplication.service.ILessonService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/lesson")
@AllArgsConstructor
@Log4j2
public class LessonController {

    private final ILessonService lessonService;

    @Operation(
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping("/get-all-lesson")
    public ResponseEntity<ResponseCommon<GetAllLessonResponse>> getLessons() {
        try {
            List<Lesson> lessons = lessonService.getAllLessons();

            GetAllLessonResponse responseDTO = new GetAllLessonResponse(lessons);
            return ResponseEntity.ok(new ResponseCommon<>(ResponseCode.SUCCESS, responseDTO));
        } catch (Exception e) {
            log.error("An error occurred while retrieving lessons: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Failed to retrieve lessons", null));
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseCommon<AddLessonResponse>> addLesson(@Valid @RequestBody AddLessonRequest requestDTO) {
        try {
            ResponseCommon<AddLessonResponse> responseDTO = lessonService.addLesson(requestDTO);
            // if code of response equal code success -> return ok
            if (responseDTO.getCode() == ResponseCode.SUCCESS.getCode()) {
                return ResponseEntity.ok(responseDTO);
            } else if (responseDTO.getCode() == ResponseCode.LESSON_EXIST.getCode()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseCommon<>(responseDTO.getCode(), "Course already exsit", null));
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Add course fail", null));
            }
        } catch (Exception e) {
            log.error("An error occurred while adding a lesson: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Failed to add lesson", null));
        }
    }


    @PostMapping("/update")
    public ResponseEntity<ResponseCommon<UpdateLessonResponse>> updateLesson(
            @Valid @RequestBody UpdateLessonRequest requestDTO) {
        try {
            ResponseCommon<UpdateLessonResponse> responseDTO = lessonService.updateLesson(requestDTO);

            // if code of response equal code success -> return ok
            if (responseDTO.getCode() == ResponseCode.SUCCESS.getCode()) {
                return ResponseEntity.ok(responseDTO);
            } else if (responseDTO.getCode() == ResponseCode.LESSON_EXIST.getCode()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseCommon<>(responseDTO.getCode(), "Course already exsit", null));
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Add course fail", null));
            }
        } catch (Exception e) {
            log.error("An error occurred while adding a lesson: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Failed to add lesson", null));
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseCommon<DeleteLessonResponse>> deleteLesson(
            @Valid @RequestBody DeleteLessonRequest requestDTO) {
        try {
            ResponseCommon<DeleteLessonResponse> responseDTO = lessonService.deleteLesson(requestDTO);
            // if code of response equal code success -> return ok
            if (responseDTO.getCode() == ResponseCode.SUCCESS.getCode()) {
                return ResponseEntity.ok(responseDTO);
            } else if (responseDTO.getCode() == ResponseCode.LESSON_EXIST.getCode()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseCommon<>(responseDTO.getCode(), "Course already exsit", null));
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Add course fail", null));
            }
        } catch (Exception e) {
            log.error("An error occurred while adding a lesson: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Failed to add lesson", null));
        }
    }
}
