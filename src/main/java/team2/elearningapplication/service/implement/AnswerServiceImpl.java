package team2.elearningapplication.service.implement;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import team2.elearningapplication.Enum.ResponseCode;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.answer.AnswerData;
import team2.elearningapplication.dto.request.admin.answer.DeleteAnswerRequest;
import team2.elearningapplication.dto.request.admin.answer.UpdateAnswerRequest;
import team2.elearningapplication.dto.response.admin.answer.AddAnswerResponse;
import team2.elearningapplication.dto.response.admin.answer.DeleteAnswerResponse;
import team2.elearningapplication.dto.response.admin.answer.FindAllAnswerResponse;
import team2.elearningapplication.dto.response.admin.answer.UpdateAnswerResponse;
import team2.elearningapplication.entity.Answer;
import team2.elearningapplication.entity.Question;
import team2.elearningapplication.repository.IAnswerRepository;
import team2.elearningapplication.repository.IQuestionRepository;
import team2.elearningapplication.service.IAnswerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements IAnswerService {
    private final IQuestionRepository questionRepository;
    private final IAnswerRepository answerRepository;

    private final Logger log = LoggerFactory.getLogger(AnswerServiceImpl.class);

    @Override
    public ResponseCommon<AddAnswerResponse> addAnswer(AnswerData answerData) {
        try {
            // Find the question based on its ID
            Question question = questionRepository.findQuestionById(answerData.getQuestionID()).orElse(null);

            // Check if the question exists
            if (Objects.isNull(question)) {
                log.debug("addAnswer: Question not found.");
                return new ResponseCommon<>(ResponseCode.QUESTION_NOT_EXIST.getCode(), "Question not exist, cannot add answer to question", null);
            } else {
                // Create and save the answer
                Answer answer = new Answer();
                answer.setAnswerContent(answerData.getAnswerName());
                answer.setCorrect(answer.isCorrect());
                answer.setQuestionId(answer.getQuestionId());
                answerRepository.save(answer);

                // Create and return a success response
                AddAnswerResponse addAnswerResponse = new AddAnswerResponse();
                addAnswerResponse.setId(answer.getId());
                addAnswerResponse.setAnswerContent(answer.getAnswerContent());
                addAnswerResponse.setCorrect(answer.isCorrect());

                log.debug("addAnswer: Answer added successfully.");
                return new ResponseCommon<>(ResponseCode.SUCCESS.getCode(), "Add answer success", addAnswerResponse);
            }
        } catch (Exception e) {
            log.error("addAnswer: An error occurred - " + e.getMessage(), e);
            return new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Add answer fail", null);
        }
    }

    @Override
    public ResponseCommon<UpdateAnswerResponse> updateAnswer(UpdateAnswerRequest updateAnswerRequest) {
        try {
            // Find the answer based on its question ID and answer ID
            Answer answerExist = answerRepository.findAnswerByQuestionIdAndId(updateAnswerRequest.getQuestionID(), updateAnswerRequest.getAnswerID()).orElse(null);

            // Check if the answer exists
            if (Objects.isNull(answerExist)) {
                log.debug("updateAnswer: Answer not found in the question.");
                return new ResponseCommon<>(ResponseCode.ANSWER_NOT_EXIST.getCode(), "Answer not exist in question", null);
            } else {
                // Create an updated answer with the same content and properties
                Answer answerUpdate = new Answer();
                answerUpdate.setAnswerContent(answerExist.getAnswerContent());
                answerUpdate.setCorrect(answerExist.isCorrect());
                answerUpdate.setQuestionId(answerExist.getQuestionId());

                // Save the updated answer
                answerRepository.save(answerUpdate);

                // Create and return a success response
                UpdateAnswerResponse updateAnswerResponse = new UpdateAnswerResponse();
                updateAnswerResponse.setAnswerContent(answerUpdate.getAnswerContent());
                updateAnswerResponse.setAnswerID(answerUpdate.getId());
                updateAnswerResponse.setCorrect(answerUpdate.isCorrect());
                updateAnswerResponse.setQuestionID(answerUpdate.getQuestionId());

                log.debug("updateAnswer: Answer updated successfully.");
                return new ResponseCommon<>(ResponseCode.SUCCESS.getCode(), "Update answer success", updateAnswerResponse);
            }

        } catch (Exception e) {
            log.error("updateAnswer: An error occurred - " + e.getMessage(), e);
            return new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Update answer fail", null);
        }
    }

    @Override
    public ResponseCommon<DeleteAnswerResponse> deleteAnswer(DeleteAnswerRequest deleteAnswerRequest) {
        try {
            // Find the answer based on its question ID and answer ID
            Answer answerExist = answerRepository.findAnswerByQuestionIdAndId(deleteAnswerRequest.getQuestionID(), deleteAnswerRequest.getAnswerID()).orElse(null);

            // Check if the answer exists
            if (Objects.isNull(answerExist)) {
                log.debug("deleteAnswer: Answer not found in the question.");
                return new ResponseCommon<>(ResponseCode.ANSWER_NOT_EXIST.getCode(), "Answer not exist in question", null);
            } else {
                // Set the "deleted" flag to true and save the answer
                answerExist.setDeleted(true);
                answerRepository.save(answerExist);

                // Create a response with details of the deleted answer
                DeleteAnswerResponse deleteAnswerResponse = new DeleteAnswerResponse();
                deleteAnswerResponse.setQuestionID(answerExist.getQuestionId());
                deleteAnswerResponse.setAnswerID(answerExist.getId());
                deleteAnswerResponse.setAnswerContent(answerExist.getAnswerContent());
                deleteAnswerResponse.setCorrect(answerExist.isCorrect());

                log.debug("deleteAnswer: Answer deleted successfully.");
                return new ResponseCommon<>(ResponseCode.SUCCESS.getCode(), "Delete answer success", deleteAnswerResponse);
            }
        } catch (Exception e) {
            log.error("deleteAnswer: An error occurred - " + e.getMessage(), e);
            return new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Delete answer fail", null);
        }
    }

    @Override
    public ResponseCommon<List<FindAllAnswerResponse>> findAllAnswer() {
        try {
            List<Answer> answers = answerRepository.findAll();

            if (answers.isEmpty()) {
                log.debug("findAllAnswer: Answer list is empty.");
                return new ResponseCommon<>(ResponseCode.ANSWER_LIST_IS_EMPTY.getCode(), "Answer list is empty", null);
            }

            List<FindAllAnswerResponse> responseList = new ArrayList<>();
            for (Answer answer : answers) {
                responseList.add(new FindAllAnswerResponse(
                        answer.getQuestionId(),
                        answer.getId(),
                        answer.getAnswerContent(),
                        answer.isCorrect()
                ));
            }
            log.debug("findAllAnswer: Found all answers successfully.");
            return new ResponseCommon<>(ResponseCode.SUCCESS.getCode(), "Find all answer success", responseList);
        } catch (Exception e) {
            log.error("findAllAnswer: An error occurred - " + e.getMessage(), e);
            return new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Find all answer fail" + e.getMessage(), null);
        }
    }
}
