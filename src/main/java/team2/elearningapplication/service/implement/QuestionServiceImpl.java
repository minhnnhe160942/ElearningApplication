package team2.elearningapplication.service.implement;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import team2.elearningapplication.Enum.ResponseCode;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.answer.AnswerData;
import team2.elearningapplication.dto.request.admin.question.DeleteQuestionRequest;
import team2.elearningapplication.dto.request.admin.question.QuestionData;
import team2.elearningapplication.dto.request.admin.question.UpdateQuestionRequest;
import team2.elearningapplication.dto.response.admin.question.AddQuestionResponse;
import team2.elearningapplication.dto.response.admin.question.DeleteQuestionResponse;
import team2.elearningapplication.dto.response.admin.question.FindAllQuestionResponse;
import team2.elearningapplication.dto.response.admin.question.UpdateQuestionResponse;
import team2.elearningapplication.entity.Answer;
import team2.elearningapplication.entity.Question;
import team2.elearningapplication.repository.IQuestionDataRepository;
import team2.elearningapplication.repository.IQuestionRepository;
import team2.elearningapplication.service.IQuestionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements IQuestionService {
    private final IQuestionDataRepository questionDataRepository;
    private final IQuestionRepository questionRepository;

    private final Logger log = LoggerFactory.getLogger(QuestionServiceImpl.class);

    @Override
    public ResponseCommon<AddQuestionResponse> addQuestion(QuestionData questionData) {
        try {
            // Find the question by name to check if it already exists
            Question question = questionRepository.findQuestionByQuestionName(questionData.getQuestionName()).orElse(null);

            // Check if the question exists
            if (!Objects.isNull(question)) {
                log.debug("addQuestion: Question already exists.");
                return new ResponseCommon<>(ResponseCode.QUESTION_EXIST.getCode(), "Question exist", null);
            } else {
                List<Answer> answerList = new ArrayList<>();
                List<AnswerData> answerDataList = questionData.getListAnswer();

                // Create and save answers
                for (AnswerData answerData : answerDataList) {
                    Answer answer = new Answer();
                    answer.setAnswerContent(answerData.getAnswerName());
                    answer.setCorrect(answerData.isCorrect());
                    answer.setQuestionId(answerData.getQuestionID());
                    answerList.add(answer);
                }

                // Create and save the question
                Question questionAdd = new Question();
                questionAdd.setQuestionName(questionData.getQuestionName());
                questionAdd.setQuestionType(questionData.getQuestionType());
                questionAdd.setQuizID(questionData.getQuizID());
                questionAdd.setAnswerList(answerList);
                questionRepository.save(questionAdd);

                // Create and return a success response
                AddQuestionResponse addQuestionResponse = new AddQuestionResponse();
                addQuestionResponse.setQuestionID(questionAdd.getId());
                addQuestionResponse.setQuestionName(question.getQuestionName());
                addQuestionResponse.setAnswerList(questionAdd.getAnswerList());
                addQuestionResponse.setQuizID(question.getQuizID());

                log.debug("addQuestion: Question added successfully.");
                return new ResponseCommon<>(ResponseCode.SUCCESS.getCode(), "Add question success", addQuestionResponse);
            }
        } catch (Exception e) {
            log.error("addQuestion: An error occurred - " + e.getMessage(), e);
            return new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Add question fail", null);
        }
    }

    @Override
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

            // Create and return a success response
            UpdateQuestionResponse updateQuestionResponse = new UpdateQuestionResponse();
            updateQuestionResponse.setQuestionID(questionToUpdate.getId());
            updateQuestionResponse.setQuestionName(questionToUpdate.getQuestionName());
            updateQuestionResponse.setQuestionType(questionToUpdate.getQuestionType());

            log.debug("updateQuestion: Question updated successfully.");
            return new ResponseCommon<>(ResponseCode.SUCCESS.getCode(), "Update question success", updateQuestionResponse);
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
}
