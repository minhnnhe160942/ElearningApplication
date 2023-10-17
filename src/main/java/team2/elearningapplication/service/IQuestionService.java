package team2.elearningapplication.service;

import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.question.*;
import team2.elearningapplication.dto.response.admin.question.*;
import team2.elearningapplication.entity.Question;

import java.util.List;

public interface IQuestionService  {

        ResponseCommon<AddQuestionResponse> addQuestion(QuestionData questionData);
        ResponseCommon<UpdateQuestionResponse> updateQuestion(UpdateQuestionRequest updateQuestionRequest);
        ResponseCommon<DeleteQuestionResponse> deleteQuestion(DeleteQuestionRequest deleteQuestionRequest);

        ResponseCommon<List<Question>> findAllQuestion();

        ResponseCommon<GetQuestionByIdResponse> getQuestionById(GetQuestionByIdRequest getQuestionByIdRequest);

}
