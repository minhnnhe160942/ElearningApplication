package team2.elearningapplication.service;

import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.AddQuestionRequest;
import team2.elearningapplication.dto.request.DeleteQuestionRequest;
import team2.elearningapplication.dto.request.UpdateQuestionRequest;
import team2.elearningapplication.dto.response.AddQuestionResponse;
import team2.elearningapplication.dto.response.DeleteQuestionResponse;
import team2.elearningapplication.dto.response.UpdateQuestionResponse;

public interface IQuestionService {
//    private IQuestionRepository questionRepository;
//
//     List<Question> getAllQuestions() {
//        return questionRepository.findAll();
//    }
//
//     Question getQuestionById(int id) {
//        return questionRepository.findById(id).orElse(null);
//    }
//
//     Question saveQuestion(Question question) {
//        return questionRepository.save(question);
//    }
//
//     void deleteQuestion(int id) {
//        questionRepository.deleteById(id);
//    }

    //recommend
    ResponseCommon<AddQuestionResponse> addQuestion(AddQuestionRequest requestDTO);
    ResponseCommon<UpdateQuestionResponse> updateQuestion(UpdateQuestionRequest requestDTO);
    ResponseCommon<DeleteQuestionResponse> deleteQuestion(DeleteQuestionRequest requestDTO);
//    ResponseCommon<GetQuestionByNameResponse> getQuestionById(GetQuestionByNameRequest requestDTO);
//    ResponseCommon<GetQuestionsByLessonResponse> getQuestionsByCategory(GetQuestionsByLessonRequest requestDTO);
}
