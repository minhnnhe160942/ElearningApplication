package team2.elearningapplication.service;

import org.springframework.data.domain.PageRequest;
import team2.elearningapplication.dto.common.PageRequestDTO;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.question.*;
import team2.elearningapplication.dto.request.user.question.GetQuestionByQuizIDRequest;
import team2.elearningapplication.dto.response.admin.question.*;
import team2.elearningapplication.dto.response.user.question.GetQuestionByQuizIdResponse;
import team2.elearningapplication.dto.response.user.question.GetQuestionPageResponse;
import team2.elearningapplication.entity.Question;

import java.util.List;

public interface IQuestionService  {

        ResponseCommon<AddQuestionResponse> addQuestion(QuestionData questionData);
        ResponseCommon<UpdateQuestionResponse> updateQuestion(UpdateQuestionRequest updateQuestionRequest);
        ResponseCommon<DeleteQuestionResponse> deleteQuestion(DeleteQuestionRequest deleteQuestionRequest);

        ResponseCommon<List<Question>> findAllQuestion();
        ResponseCommon<List<Question>> findAllQuestionByDeleted(FindQuestionByDeletedRequest findQuestionByDeletedRequest);
        ResponseCommon<GetQuestionByIdResponse> getQuestionById(GetQuestionByIdRequest getQuestionByIdRequest);

        ResponseCommon<GetQuestionPageResponse> getQuestionPage(PageRequestDTO pageRequestDTO);

        ResponseCommon<GetQuestionByQuizIdResponse> getQuestionByQuizId(GetQuestionByQuizIDRequest getQuestionByQuizIDRequest);
}
