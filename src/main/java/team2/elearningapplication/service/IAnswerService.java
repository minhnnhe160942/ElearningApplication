package team2.elearningapplication.service;

import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.answer.AnswerData;
import team2.elearningapplication.dto.request.admin.answer.DeleteAnswerRequest;
import team2.elearningapplication.dto.request.admin.answer.UpdateAnswerRequest;
import team2.elearningapplication.dto.response.admin.answer.AddAnswerResponse;
import team2.elearningapplication.dto.response.admin.answer.DeleteAnswerResponse;
import team2.elearningapplication.dto.response.admin.answer.FindAllAnswerResponse;
import team2.elearningapplication.dto.response.admin.answer.UpdateAnswerResponse;
import team2.elearningapplication.entity.Answer;

import java.util.List;

public interface IAnswerService {
    ResponseCommon<AddAnswerResponse> addAnswer(AnswerData answerData);

    ResponseCommon<UpdateAnswerResponse> updateAnswer(UpdateAnswerRequest updateAnswerRequest);

    ResponseCommon<DeleteAnswerResponse> deleteAnswer(DeleteAnswerRequest deleteAnswerRequest);

    ResponseCommon<List<FindAllAnswerResponse>> findAllAnswer();
}