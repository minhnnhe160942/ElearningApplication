package team2.elearningapplication.service;

import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.quiz.AddQuizRequest;
import team2.elearningapplication.dto.request.admin.quiz.DeleteQuizRequest;
import team2.elearningapplication.dto.request.admin.quiz.UpdateQuizRequest;
import team2.elearningapplication.dto.response.admin.quiz.AddQuizResponse;
import team2.elearningapplication.dto.response.admin.quiz.DeleteQuizResponse;
import team2.elearningapplication.dto.response.admin.quiz.FindAllQuizResponse;
import team2.elearningapplication.dto.response.admin.quiz.UpdateQuizResponse;

public interface IQuizService {
    ResponseCommon<AddQuizResponse> addQuiz(AddQuizRequest addQuizRequest);
    ResponseCommon<UpdateQuizResponse> updateQuiz(UpdateQuizRequest updateQuizRequest);
    ResponseCommon<DeleteQuizResponse> deleteQuiz(DeleteQuizRequest deleteQuizRequest);
    ResponseCommon<FindAllQuizResponse> findAllQuiz();
}
