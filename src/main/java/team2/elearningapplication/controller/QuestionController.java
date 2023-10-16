package team2.elearningapplication.controller;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team2.elearningapplication.Enum.ResponseCode;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.question.DeleteQuestionRequest;
import team2.elearningapplication.dto.request.admin.question.QuestionData;
import team2.elearningapplication.dto.request.admin.question.UpdateQuestionRequest;
import team2.elearningapplication.dto.response.admin.question.AddQuestionResponse;
import team2.elearningapplication.dto.response.admin.question.DeleteQuestionResponse;
import team2.elearningapplication.dto.response.admin.question.UpdateQuestionResponse;
import team2.elearningapplication.entity.Question;
import team2.elearningapplication.service.IQuestionService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/question")
@AllArgsConstructor
public class QuestionController {
    private final IQuestionService questionService;
    private final Logger log = LoggerFactory.getLogger(QuestionController.class);

    @PostMapping("/add-question")
    public ResponseEntity<ResponseCommon<AddQuestionResponse>> addQuestion(@Valid @RequestBody QuestionData questionData) {
        ResponseCommon<AddQuestionResponse> response = questionService.addQuestion(questionData);
        if (response.getCode() == ResponseCode.SUCCESS.getCode()) {
            log.debug("addQuestion: Question added successfully.");
            return ResponseEntity.ok(response);
        } else if (response.getCode() == ResponseCode.QUESTION_EXIST.getCode()) {
            log.debug("addQuestion: Question already exists.");
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(), "Question exists", null));
        } else {
            log.error("addQuestion: Add question failed.");
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Add question failed", null));
        }
    }

    @PutMapping("/update-question")
    public ResponseEntity<ResponseCommon<UpdateQuestionResponse>> updateQuestion(@Valid @RequestBody UpdateQuestionRequest updateQuestionRequest) {
        ResponseCommon<UpdateQuestionResponse> response = questionService.updateQuestion(updateQuestionRequest);
        if (response.getCode() == ResponseCode.SUCCESS.getCode()) {
            log.debug("updateQuestion: Question updated successfully.");
            return ResponseEntity.ok(response);
        } else if (response.getCode() == ResponseCode.QUESTION_NOT_EXIST.getCode()) {
            log.debug("updateQuestion: Question not found.");
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(), "Question not found", null));
        } else {
            log.error("updateQuestion: Update question failed.");
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Update question failed", null));
        }
    }

    @DeleteMapping("/delete-question")
    public ResponseEntity<ResponseCommon<DeleteQuestionResponse>> deleteQuestion(@Valid @RequestBody DeleteQuestionRequest deleteQuestionRequest) {
        ResponseCommon<DeleteQuestionResponse> response = questionService.deleteQuestion(deleteQuestionRequest);
        if (response.getCode() == ResponseCode.SUCCESS.getCode()) {
            log.debug("deleteQuestion: Question deleted successfully.");
            return ResponseEntity.ok(response);
        } else if (response.getCode() == ResponseCode.QUESTION_NOT_EXIST.getCode()) {
            log.debug("deleteQuestion: Question not found.");
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(), "Question not found", null));
        } else {
            log.error("deleteQuestion: Delete question failed.");
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Delete question failed", null));
        }
    }

    @GetMapping("/find-all-question")
    public ResponseEntity<ResponseCommon<List<Question>>> findAllQuestion() {
        ResponseCommon<List<Question>> response = questionService.findAllQuestion();
        if (response.getCode() == ResponseCode.SUCCESS.getCode()) {
            log.debug("findAllQuestion: Found all questions successfully.");
            return ResponseEntity.ok(response);
        } else if (response.getCode() == ResponseCode.QUESTION_LIST_IS_EMPTY.getCode()) {
            log.debug("findAllQuestion: Question list is empty.");
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(), "Question list is empty", null));
        } else {
            log.error("findAllQuestion: Find all questions failed.");
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Find all questions failed", null));
        }
    }
}
