package team2.elearningapplication.service;

import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.question.AddQuestionRequest;
import team2.elearningapplication.dto.request.admin.question.DeleteQuestionRequest;
import team2.elearningapplication.dto.request.admin.question.QuestionData;
import team2.elearningapplication.dto.request.admin.question.UpdateQuestionRequest;
import team2.elearningapplication.dto.response.admin.question.AddQuestionResponse;
import team2.elearningapplication.dto.response.admin.question.DeleteQuestionResponse;
import team2.elearningapplication.dto.response.admin.question.FindAllQuestionResponse;
import team2.elearningapplication.dto.response.admin.question.UpdateQuestionResponse;
import team2.elearningapplication.entity.Question;

import java.util.List;

public interface IQuestionService  {

        ResponseCommon<AddQuestionResponse> addQuestion(QuestionData questionData);
        ResponseCommon<UpdateQuestionResponse> updateQuestion(UpdateQuestionRequest updateQuestionRequest);
        ResponseCommon<DeleteQuestionResponse> deleteQuestion(DeleteQuestionRequest deleteQuestionRequest);

        ResponseCommon<List<Question>> findAllQuestion();
}
