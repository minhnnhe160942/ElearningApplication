package team2.elearningapplication.service.implement;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team2.elearningapplication.Enum.ResponseCode;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.question.DeleteQuestionRequest;
import team2.elearningapplication.dto.request.admin.question.GetQuestionByIdRequest;
import team2.elearningapplication.dto.request.admin.question.QuestionData;
import team2.elearningapplication.dto.request.admin.question.UpdateQuestionRequest;
import team2.elearningapplication.dto.response.admin.question.AddQuestionResponse;
import team2.elearningapplication.dto.response.admin.question.DeleteQuestionResponse;
import team2.elearningapplication.dto.response.admin.question.GetQuestionByIdResponse;
import team2.elearningapplication.dto.response.admin.question.UpdateQuestionResponse;
import team2.elearningapplication.entity.Answer;
import team2.elearningapplication.entity.Question;
import team2.elearningapplication.entity.Quiz;
import team2.elearningapplication.repository.IAnswerRepository;
import team2.elearningapplication.repository.IQuestionDataRepository;
import team2.elearningapplication.repository.IQuestionRepository;
import team2.elearningapplication.repository.IQuizRepository;
import team2.elearningapplication.service.IQuestionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements IQuestionService {
    private final IQuestionDataRepository questionDataRepository;
    private final IQuestionRepository questionRepository;
    private final IQuizRepository iQuizRepository;
    private final IAnswerRepository iAnswerRepository;


    private final Logger log = LoggerFactory.getLogger(QuestionServiceImpl.class);

    @Override
    public ResponseCommon<AddQuestionResponse> addQuestion(QuestionData questionData) {
        try {
            // Find the question by name to check if it already exists
            Quiz quiz = iQuizRepository.findQuizById(questionData.getQuizID()).orElse(null);
            if (quiz == null) {
                log.debug("addQuestion: Quiz not exists.");
                return new ResponseCommon<>(ResponseCode.QUIZ_NOT_EXIST.getCode(), "Quizz not exist", null);
            }
//                List<Answer> answerList =  questionData.getListAnswer();
            // Create and save the question
            Question questionAdd = new Question();
            questionAdd.setQuestionName(questionData.getQuestionName());
            questionAdd.setQuestionType(questionData.getQuestionType());
            questionAdd.setQuizID(questionData.getQuizID());
            questionAdd = questionRepository.save(questionAdd);

            for (Answer answer : questionData.getListAnswer()) {
                answer.setQuestionId(questionAdd.getId());
                iAnswerRepository.save(answer);
            }

            log.debug("addQuestion: Question added successfully.");
            return new ResponseCommon<>(ResponseCode.SUCCESS.getCode(), "Add question success", new AddQuestionResponse());

        } catch (Exception e) {
            log.error("addQuestion: An error occurred - " + e.getMessage(), e);
            return new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Add question fail", null);
        }
    }

    @Override
    @Transactional
    public ResponseCommon<UpdateQuestionResponse> updateQuestion(UpdateQuestionRequest updateQuestionRequest) {
        try {
            // Find the question to update
            Question questionToUpdate = questionRepository.findQuestionById(updateQuestionRequest.getQuestionID()).orElse(null);

            // Check if the question exists
            if (Objects.isNull(questionToUpdate)) {
                log.debug("updateQuestion: Question not found.");
                return new ResponseCommon<>(ResponseCode.QUESTION_NOT_EXIST.getCode(), "Question not exist", null);
            }

            // Update the question
            questionToUpdate.setQuestionName(updateQuestionRequest.getQuestionName());
            questionToUpdate.setQuestionType(updateQuestionRequest.getQuestionType());

            // Save the updated question
            questionRepository.save(questionToUpdate);
            for (Answer answer : updateQuestionRequest.getAnswers()) {
                Answer answerUpdate = iAnswerRepository.findAnswerById(answer.getId()).orElse(null);
                if (answerUpdate == null) {
                    log.debug("updateQuestion: Answer not found.");
                    return new ResponseCommon<>(ResponseCode.ANSWER_NOT_EXIST.getCode(), "Answer not exist", null);
                }
                answerUpdate.setAnswerContent(answer.getAnswerContent());
                answerUpdate.setCorrect(answer.isCorrect());
                iAnswerRepository.save(answerUpdate);
            }

            log.debug("updateQuestion: Question updated successfully.");
            return new ResponseCommon<>(ResponseCode.SUCCESS.getCode(), "Update question success", new UpdateQuestionResponse());
        } catch (Exception e) {
            log.error("updateQuestion: An error occurred - " + e.getMessage(), e);
            return new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Update question fail", null);
        }
    }

    @Override
    public ResponseCommon<DeleteQuestionResponse> deleteQuestion(DeleteQuestionRequest deleteQuestionRequest) {
        try {
            // Find the question to delete
            Question questionToDelete = questionRepository.findQuestionById(deleteQuestionRequest.getQuestionID()).orElse(null);

            // Check if the question exists
            if (Objects.isNull(questionToDelete)) {
                log.debug("deleteQuestion: Question not found.");
                return new ResponseCommon<>(ResponseCode.QUESTION_NOT_EXIST.getCode(), "Question not exist", null);
            }

            // Set the question as deleted
            questionToDelete.setDeleted(true);

            // Save the deleted question
            questionRepository.save(questionToDelete);

            // Create and return a success response
            DeleteQuestionResponse deleteQuestionResponse = new DeleteQuestionResponse();
            deleteQuestionResponse.setQuizID(questionToDelete.getQuizID());
            deleteQuestionResponse.setQuestionID(questionToDelete.getId());

            log.debug("deleteQuestion: Question deleted successfully.");
            return new ResponseCommon<>(ResponseCode.SUCCESS.getCode(), "Delete question success", deleteQuestionResponse);
        } catch (Exception e) {
            log.error("deleteQuestion: An error occurred - " + e.getMessage(), e);
            return new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Delete question fail", null);
        }
    }

    @Override
    public ResponseCommon<List<Question>> findAllQuestion() {
        try {
            // Find all questions
            List<Question> questions = questionRepository.findAll();

            // Check if the question list is empty
            if (questions.isEmpty()) {
                log.debug("findAllQuestion: Question list is empty.");
                return new ResponseCommon<>(ResponseCode.QUESTION_LIST_IS_EMPTY.getCode(), "Question list is empty", null);
            }
            log.debug("findAllQuestion: Found all questions successfully.");
            return new ResponseCommon<>(ResponseCode.SUCCESS.getCode(), "Find all question success", questions);
        } catch (Exception e) {
            log.error("findAllQuestion: An error occurred - " + e.getMessage(), e);
            return new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Find all question fail", null);
        }
    }

    @Override
    public ResponseCommon<GetQuestionByIdResponse> getQuestionById(GetQuestionByIdRequest getQuestionByIdRequest) {
        try {
            Question question = questionRepository.findQuestionById(getQuestionByIdRequest.getId()).orElse(null);
            // If question not exist -> tell user
            if (Objects.isNull(question)) {
                log.debug("Get question by id: Question not exits.");
                return new ResponseCommon<>(ResponseCode.QUESTION_NOT_EXIST.getCode(), "Question not exits", null);
            } else {
                GetQuestionByIdResponse response = new GetQuestionByIdResponse();
                List<Answer> answers = iAnswerRepository.findAnswerByQuestionId(question.getId());

                response.setId(question.getId());
                response.setQuizID(question.getQuizID());
                response.setQuestionType(question.getQuestionType());
                response.setQuestionName(question.getQuestionName());
                response.setAnswerList(answers);
                response.setDeleted(question.isDeleted());

                log.debug("Get question by id successfully.");
                return new ResponseCommon<>(ResponseCode.SUCCESS.getCode(), "Get question by id success", response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Get question by id: An error occurred - " + e.getMessage(), e);
            return new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Get question by id fail", null);
        }
    }
}
