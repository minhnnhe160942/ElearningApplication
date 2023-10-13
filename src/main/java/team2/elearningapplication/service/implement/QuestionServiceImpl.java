package team2.elearningapplication.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team2.elearningapplication.Enum.ResponseCode;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.answer.AnswerData;
import team2.elearningapplication.dto.request.admin.question.QuestionData;
import team2.elearningapplication.dto.response.admin.question.AddQuestionResponse;
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
    @Override
    public ResponseCommon<AddQuestionResponse> addQuestion(QuestionData questionData) {
        try {
            QuestionData question  = questionDataRepository.findQuestionByQuestionName(questionData.getQuestionName()).orElse(null);
            // if questionAdd not null -> question exist -> tell user
            if(!Objects.isNull(question)) return new ResponseCommon<>(ResponseCode.QUESTION_EXIST.getCode(),"Question exist",null);
            else {
                List<Answer> answerList = new ArrayList<>();
                List<AnswerData> answerDataList = questionData.getListAnswer();
                for (AnswerData answerData: answerDataList) {
                    Answer answer = new Answer();
                    answer.setAnswerContent(answerData.getAnswerName());
                    answer.setCorrect(answerData.isCorrect());
                    answer.setQuestionId(answerData.getQuestionID());
                    answerList.add(answer);
                }
                Question questionAdd = new Question();
                questionAdd.setQuestionName(questionData.getQuestionName());
                questionAdd.setQuestionType(questionData.getQuestionType());
                questionAdd.setQuiz_id(questionData.getQuizID());
                questionAdd.setAnswerList(answerList);
                questionRepository.save(questionAdd);
                AddQuestionResponse addQuestionResponse = new AddQuestionResponse();
                addQuestionResponse.setQuestionID(questionAdd.getId());
                addQuestionResponse.setQuestionName(question.getQuestionName());
                addQuestionResponse.setAnswerList(questionAdd.getAnswerList());
                addQuestionResponse.setQuizID(question.getQuizID());
                return new ResponseCommon<>(ResponseCode.SUCCESS.getCode(),"Add question success",addQuestionResponse);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Add question fail",null);
        }
    }
}
