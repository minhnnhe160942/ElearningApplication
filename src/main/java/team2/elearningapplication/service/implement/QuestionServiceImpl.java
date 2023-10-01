package team2.elearningapplication.service.implement;

import team2.elearningapplication.Enum.ResponseCode;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.AddQuestionRequest;
import team2.elearningapplication.dto.response.AddQuestionResponse;
import team2.elearningapplication.entity.Question;

public class QuestionServiceImpl {
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
}
