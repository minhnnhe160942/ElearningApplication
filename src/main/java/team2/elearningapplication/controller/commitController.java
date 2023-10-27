package team2.elearningapplication.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/lesson")
@AllArgsConstructor
public class commitController {
    private final IQuestionService questionService;

    public QuestionController(IQuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/api/question/add")
    public ResponseEntity<AddQuestionResponse> addQuestion(@RequestBody AddQuestionRequest request) {
        ResponseCommon<AddQuestionResponse> responseCommon = questionService.addQuestion(request);

        if (responseCommon.getCode() == ResponseCode.SUCCESS.getCode()) {
            return ResponseEntity.ok(responseCommon.getData());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    private final IQuestionService questionService;

    public QuestionController(IQuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/api/question/add")
    public ResponseEntity<AddQuestionResponse> addQuestion(@RequestBody AddQuestionRequest request) {
        ResponseCommon<AddQuestionResponse> responseCommon = questionService.addQuestion(request);

        if (responseCommon.getCode() == ResponseCode.SUCCESS.getCode()) {
            return ResponseEntity.ok(responseCommon.getData());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    private final IQuestionService questionService;

    public QuestionController(IQuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/api/question/add")
    public ResponseEntity<AddQuestionResponse> addQuestion(@RequestBody AddQuestionRequest request) {
        ResponseCommon<AddQuestionResponse> responseCommon = questionService.addQuestion(request);

        if (responseCommon.getCode() == ResponseCode.SUCCESS.getCode()) {
            return ResponseEntity.ok(responseCommon.getData());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    private final IQuestionService questionService;

    public QuestionController(IQuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/api/question/add")
    public ResponseEntity<AddQuestionResponse> addQuestion(@RequestBody AddQuestionRequest request) {
        ResponseCommon<AddQuestionResponse> responseCommon = questionService.addQuestion(request);

        if (responseCommon.getCode() == ResponseCode.SUCCESS.getCode()) {
            return ResponseEntity.ok(responseCommon.getData());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping("/api/question/add")
    public ResponseEntity<AddQuestionResponse> addQuestion(@RequestBody AddQuestionRequest request) {
        ResponseCommon<AddQuestionResponse> responseCommon = questionService.addQuestion(request);

        if (responseCommon.getCode() == ResponseCode.SUCCESS.getCode()) {
            return ResponseEntity.ok(responseCommon.getData());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            @PostMapping("/api/question/add")
            public ResponseEntity<AddQuestionResponse> addQuestion(@RequestBody AddQuestionRequest request) {
                ResponseCommon<AddQuestionResponse> responseCommon = questionService.addQuestion(request);

                if (responseCommon.getCode() == ResponseCode.SUCCESS.getCode()) {
                    return ResponseEntity.ok(responseCommon.getData());
                } else {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

                            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                        }
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
}
