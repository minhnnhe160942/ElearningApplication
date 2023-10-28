package team2.elearningapplication.service;

import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.quiz.*;
import team2.elearningapplication.dto.request.user.quiz.FinishQuizRequest;
import team2.elearningapplication.dto.request.user.quiz.NextQuestionRequest;
import team2.elearningapplication.dto.request.user.quiz.ResetQuizRequest;
import team2.elearningapplication.dto.request.user.quiz.StartQuizRequest;
import team2.elearningapplication.dto.response.admin.quiz.*;
import team2.elearningapplication.dto.response.user.quiz.FinishQuizResponse;
import team2.elearningapplication.dto.response.user.quiz.NextQuestionResponse;
import team2.elearningapplication.dto.response.user.quiz.ResetQuizResponse;
import team2.elearningapplication.dto.response.user.quiz.StartQuizResponse;

public interface IQuizService {
    ResponseCommon<AddQuizResponse> addQuiz(AddQuizRequest addQuizRequest);
    ResponseCommon<UpdateQuizResponse> updateQuiz(UpdateQuizRequest updateQuizRequest);
    ResponseCommon<DeleteQuizResponse> deleteQuiz(DeleteQuizRequest deleteQuizRequest);
    ResponseCommon<FindAllQuizResponse> findAllQuiz();
    ResponseCommon<FindAllQuizResponse> findAllQuizByDeleted(FindQuizByDeletedRequest findQuizByDeletedRequest);

    ResponseCommon<GetQuizByIdResponse> getQuizById(GetQuizByIdRequest getQuizByIdRequest);

    ResponseCommon<StartQuizResponse> startQuiz(StartQuizRequest startQuizRequest);

    ResponseCommon<NextQuestionResponse> nextQuestion(NextQuestionRequest nextQuestionRequest);

    ResponseCommon<FinishQuizResponse> finishQuiz(FinishQuizRequest finishQuizRequest);

    ResponseCommon<ResetQuizResponse> resetQuiz(ResetQuizRequest resetQuizRequest);
}
