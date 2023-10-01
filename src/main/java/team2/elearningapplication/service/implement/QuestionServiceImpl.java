package team2.elearningapplication.service.implement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import team2.elearningapplication.Enum.ResponseCode;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.AddQuestionRequest;
import team2.elearningapplication.dto.request.DeleteQuestionRequest;
import team2.elearningapplication.dto.request.UpdateQuestionRequest;
import team2.elearningapplication.dto.response.AddQuestionResponse;
import team2.elearningapplication.dto.response.DeleteQuestionResponse;
import team2.elearningapplication.dto.response.UpdateQuestionResponse;
import team2.elearningapplication.entity.Question;
import team2.elearningapplication.repository.IQuestionRepository;
import team2.elearningapplication.service.IQuestionService;

import java.util.Optional;
@Service
@RequiredArgsConstructor
@Slf4j
public class QuestionServiceImpl implements IQuestionService {
    private final IQuestionRepository questionRepository;

    @Override
    public ResponseCommon<AddQuestionResponse> addQuestion(AddQuestionRequest requestDTO) {
        try {
            Question question = new Question();
            question.setQuestion(requestDTO.getQuestion());
            question.setCorrectAnswerId(requestDTO.getCorrectAnswerId());
            question.setQuiz_id(requestDTO.getQuiz_id());

            questionRepository.save(question);

            AddQuestionResponse responseDTO = new AddQuestionResponse();
            responseDTO.setQuestion(question);

            return new ResponseCommon<>(ResponseCode.SUCCESS, responseDTO);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }

    @Override
    public ResponseCommon<UpdateQuestionResponse> updateQuestion(UpdateQuestionRequest requestDTO) {
        try {
            Optional<Question> existingQuestion = questionRepository.findById(requestDTO.getId());
            if ( existingQuestion.isPresent() ) {
                Question updateQuestion = existingQuestion.get();
                updateQuestion.setQuestion(requestDTO.getQuestion());
                updateQuestion.setCorrectAnswerId(requestDTO.getCorrectAnswerId());
                updateQuestion.setQuiz_id(requestDTO.getQuiz_id());

                questionRepository.save(updateQuestion);

                UpdateQuestionResponse responseDTO = new UpdateQuestionResponse();
                responseDTO.setQuestion(updateQuestion);

                return new ResponseCommon<>(ResponseCode.SUCCESS, responseDTO);
            }
            else {
                return new ResponseCommon<>(ResponseCode.FAIL, null);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }

    @Override
    public ResponseCommon<DeleteQuestionResponse> deleteQuestion(DeleteQuestionRequest requestDTO) {
        try {
            Optional<Question> existingQuestion = questionRepository.findById(requestDTO.getQuestionId());
            if ( existingQuestion.isPresent() ) {
                Question question = existingQuestion.get();

                questionRepository.delete(question);

                DeleteQuestionResponse responseDTO = new DeleteQuestionResponse();

                return new ResponseCommon<>(ResponseCode.SUCCESS, responseDTO);
            }
            else {
                return new ResponseCommon<>(ResponseCode.FAIL, null);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }
//
//    @Override
//    public ResponseCommon<GetQuestionByIdResponse> getQuestionById(GetQuestionByIdRequest requestDTO) {
//        try {
//            int id = requestDTO.getId();
//            Optional<Question> question = questionRepository.findById(id);
//
//            GetQuestionByIdResponse responseDTO = new GetQuestionByIdResponse();
//            question.ifPresent(responseDTO::setQuestion);
//
//            return new ResponseCommon<>(ResponseCode.SUCCESS, responseDTO);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseCommon<>(ResponseCode.FAIL, null);
//        }
//    }
//
//    @Override
//    public ResponseCommon<GetQuestionsByCategoryResponse> getQuestionsByCategory(GetQuestionsByCategoryRequest requestDTO) {
//        // Implement this method based on your use case
//        // You would need to modify the DTOs and repository accordingly
//        return null;
//    }
}
