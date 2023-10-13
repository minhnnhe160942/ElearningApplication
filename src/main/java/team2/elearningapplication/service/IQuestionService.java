package team2.elearningapplication.service;

import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.question.AddQuestionRequest;
import team2.elearningapplication.dto.request.admin.question.QuestionData;
import team2.elearningapplication.dto.response.admin.question.AddQuestionResponse;

public interface IQuestionService  {

        ResponseCommon<AddQuestionResponse> addQuestion(QuestionData questionData);
}
