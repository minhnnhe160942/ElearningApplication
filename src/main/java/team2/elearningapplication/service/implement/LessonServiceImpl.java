package team2.elearningapplication.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team2.elearningapplication.Enum.ResponseCode;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.lesson.AddLessonRequest;
import team2.elearningapplication.dto.request.admin.lesson.DeleteLessonRequest;
import team2.elearningapplication.dto.request.admin.lesson.UpdateLessonRequest;
import team2.elearningapplication.dto.response.admin.lesson.AddLessonResponse;
import team2.elearningapplication.dto.response.admin.lesson.DeleteLessonResponse;
import team2.elearningapplication.dto.response.admin.lesson.FindAllLessonResponse;
import team2.elearningapplication.dto.response.admin.lesson.UpdateLessonResponse;
import team2.elearningapplication.entity.Lesson;
import team2.elearningapplication.repository.ICourseRepository;
import team2.elearningapplication.repository.ILessonRespository;
import team2.elearningapplication.service.ILessonService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements ILessonService {
    private final ILessonRespository lessonRespository;
    private final ICourseRepository courseRepository;
    @Override
    public ResponseCommon<AddLessonResponse> addLesson(AddLessonRequest addLessonRequest) {
        try {
            Lesson lesson = lessonRespository.findLessonByOrdNumberAndCourse(addLessonRequest.getOrdNumber(), addLessonRequest.getCourseID()).orElse(null);
            // if lesson not null -> lesson exist -> tell user
            if(!Objects.isNull(lesson)) return new ResponseCommon<>(ResponseCode.LESSON_EXIST,null);
            // if lesson is null -> create new lesson
            else  {
                Lesson addLesson = new Lesson();
                addLesson.setCourse(courseRepository.findCourseById(addLessonRequest.getCourseID()).orElse(null));
                addLesson.setOrdNumber(addLesson.getOrdNumber());
                addLesson.setLinkContent(addLesson.getLinkContent());
                addLesson.setDescription(addLesson.getDescription());
                LocalDateTime createdAt = LocalDateTime.now();
                addLesson.setCreatedAt(createdAt);
                lessonRespository.save(addLesson);
                AddLessonResponse addLessonResponse = new AddLessonResponse();
                addLessonResponse.setLessonID(addLesson.getId());
                addLessonResponse.setOrdNumber(addLesson.getOrdNumber());
                addLessonResponse.setCourseID(addLesson.getCourse().getId());
                addLessonResponse.setLinkContent(addLesson.getLinkContent());
                addLessonResponse.setDescription(addLesson.getDescription());
                addLessonResponse.setCreatedAt(addLesson.getCreatedAt());
                return new ResponseCommon<>(ResponseCode.SUCCESS,addLessonResponse);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Add Lesson Fail",null);
        }
    }

    @Override
    public ResponseCommon<UpdateLessonResponse> updateLesson(UpdateLessonRequest updateLessonRequest) {
        try {
            Lesson lesson = lessonRespository.findLessonById(updateLessonRequest.getLessonID()).orElse(null);
            // if lesson is null -> lesson not exist -> tell user
            if(Objects.isNull(lesson)) return new ResponseCommon<>(ResponseCode.LESSON_NOT_EXIST,null);
                // if lesson not null -> update lesson
            else  {
                Lesson updateLesson = new Lesson();
                updateLesson.setCourse(courseRepository.findCourseById(updateLessonRequest.getCourseID()).orElse(null));
                updateLesson.setOrdNumber(updateLesson.getOrdNumber());
                updateLesson.setLinkContent(updateLesson.getLinkContent());
                updateLesson.setDescription(updateLesson.getDescription());
                LocalDateTime updateAt = LocalDateTime.now();
                updateLesson.setCreatedAt(updateAt);
                lessonRespository.save(updateLesson);
                UpdateLessonResponse updateLessonResponse = new UpdateLessonResponse();
                updateLessonResponse.setLessonID(updateLesson.getId());
                updateLessonResponse.setOrdNumber(updateLesson.getOrdNumber());
                updateLessonResponse.setCourseID(updateLesson.getCourse().getId());
                updateLessonResponse.setLinkContent(updateLesson.getLinkContent());
                updateLessonResponse.setDescription(updateLesson.getDescription());
                updateLessonResponse.setCreatedAt(updateLesson.getCreatedAt());
                updateLessonResponse.setUpdateAt(updateAt);
                return new ResponseCommon<>(ResponseCode.SUCCESS,updateLessonResponse);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update Lesson Fail",null);
        }
    }

    @Override
    public ResponseCommon<DeleteLessonResponse> deleteLesson(DeleteLessonRequest deleteLessonRequest) {
        try {
            Lesson lesson = lessonRespository.findLessonById(deleteLessonRequest.getLessonID()).orElse(null);
            // if lesson is null -> lesson not exist -> tell user
            if(Objects.isNull(lesson)) return new ResponseCommon<>(ResponseCode.LESSON_NOT_EXIST,null);
                // if lesson not null -> update lesson
            else  {
                Lesson deleteLesson = new Lesson();
                deleteLesson.setDeleted(true);
                lessonRespository.save(deleteLesson);
                DeleteLessonResponse deleteLessonResponse = new DeleteLessonResponse();
                deleteLessonResponse.setLessonID(deleteLesson.getId());
                deleteLessonResponse.setOrdNumber(deleteLesson.getOrdNumber());
                deleteLessonResponse.setCourseID(deleteLesson.getCourse().getId());
                deleteLessonResponse.setLinkContent(deleteLesson.getLinkContent());
                deleteLessonResponse.setDescription(deleteLesson.getDescription());
                deleteLessonResponse.setCreatedAt(deleteLesson.getCreatedAt());
                LocalDateTime updateAt = LocalDateTime.now();
                deleteLessonResponse.setUpdateAt(updateAt);
                return new ResponseCommon<>(ResponseCode.SUCCESS,deleteLessonResponse);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete Lesson Fail",null);
        }
    }

    @Override
    public ResponseCommon<FindAllLessonResponse> findAllLesson() {
        try {
            List<Lesson> listLesson = lessonRespository.findAllByDeleted(false);
            // if list lesson is empty -> tell user
            if(listLesson.isEmpty()){
                return new ResponseCommon<>(ResponseCode.LESSON_LIST_IS_EMPTY,null);
            } else {
                FindAllLessonResponse response = new FindAllLessonResponse("Get all lesson success",listLesson);
                return new ResponseCommon<>(ResponseCode.SUCCESS,response);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL,null);
        }

    }
}
