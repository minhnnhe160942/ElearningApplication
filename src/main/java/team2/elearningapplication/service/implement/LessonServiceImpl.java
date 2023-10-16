package team2.elearningapplication.service.implement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class LessonServiceImpl implements ILessonService {
    private final ILessonRespository lessonRespository;
    private final ICourseRepository courseRepository;

    @Override
    public ResponseCommon<AddLessonResponse> addLesson(AddLessonRequest addLessonRequest) {
        try {
            Lesson lesson = lessonRespository.findLessonByOrdNumberAndCourse(addLessonRequest.getOrdNumber(), addLessonRequest.getCourseID()).orElse(null);
            // if lesson not null -> lesson exists -> tell the user
            if (!Objects.isNull(lesson)) {
                log.debug("Add Lesson failed: Lesson already exists");
                return new ResponseCommon<>(ResponseCode.LESSON_EXIST, null);
            }
            // if lesson is null -> create a new lesson
            else {
                Lesson addLesson = new Lesson();
                addLesson.setName(addLessonRequest.getLessonName());
                addLesson.setCourse(courseRepository.findCourseById(addLessonRequest.getCourseID()).orElse(null));
                addLesson.setOrdNumber(addLessonRequest.getOrdNumber());
                addLesson.setLinkContent(addLessonRequest.getLinkContent());
                addLesson.setDescription(addLessonRequest.getDescription());
                LocalDateTime createdAt = LocalDateTime.now();
                addLesson.setCreatedAt(createdAt);
                lessonRespository.save(addLesson);
                AddLessonResponse addLessonResponse = new AddLessonResponse();
                addLessonResponse.setLessonName(addLesson.getName());
                addLessonResponse.setLessonID(addLesson.getId());
                addLessonResponse.setOrdNumber(addLesson.getOrdNumber());
                addLessonResponse.setCourseID(addLesson.getCourse().getId());
                addLessonResponse.setLinkContent(addLesson.getLinkContent());
                addLessonResponse.setDescription(addLesson.getDescription());
                addLessonResponse.setCreatedAt(addLesson.getCreatedAt());
                log.debug("Add Lesson successful");
                return new ResponseCommon<>(ResponseCode.SUCCESS, addLessonResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("Add Lesson failed: " + e.getMessage());
            return new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Add Lesson Fail", null);
        }
    }

    @Override
    public ResponseCommon<UpdateLessonResponse> updateLesson(UpdateLessonRequest updateLessonRequest) {
        try {
            Lesson lesson = lessonRespository.findLessonById(updateLessonRequest.getLessonID()).orElse(null);
            // if lesson is null -> lesson does not exist -> tell the user
            if (Objects.isNull(lesson)) {
                log.debug("Update Lesson failed: Lesson does not exist");
                return new ResponseCommon<>(ResponseCode.LESSON_NOT_EXIST, null);
            }
            // if lesson not null -> update the lesson
            else {
                Lesson updateLesson = lesson;
                updateLesson.setName(updateLessonRequest.getLessonName());
                updateLesson.setCourse(courseRepository.findCourseById(updateLessonRequest.getCourseID()).orElse(null));
                updateLesson.setOrdNumber(updateLessonRequest.getOrdNumber());
                updateLesson.setLinkContent(updateLessonRequest.getLinkContent());
                updateLesson.setDescription(updateLessonRequest.getDescription());
                LocalDateTime updateAt = LocalDateTime.now();
                updateLesson.setCreatedAt(updateAt);
                lessonRespository.save(updateLesson);
                UpdateLessonResponse updateLessonResponse = new UpdateLessonResponse();
                updateLessonResponse.setLessonID(updateLesson.getId());
                updateLessonResponse.setLessonName(updateLesson.getName());
                updateLessonResponse.setOrdNumber(updateLesson.getOrdNumber());
                updateLessonResponse.setCourseID(updateLesson.getCourse().getId());
                updateLessonResponse.setLinkContent(updateLesson.getLinkContent());
                updateLessonResponse.setDescription(updateLesson.getDescription());
                updateLessonResponse.setCreatedAt(updateLesson.getCreatedAt());
                updateLessonResponse.setUpdateAt(updateAt);
                log.debug("Update Lesson successful");
                return new ResponseCommon<>(ResponseCode.SUCCESS, updateLessonResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("Update Lesson failed: " + e.getMessage());
            return new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Update Lesson Fail", null);
        }
    }

    @Override
    public ResponseCommon<DeleteLessonResponse> deleteLesson(DeleteLessonRequest deleteLessonRequest) {
        try {
            Lesson lesson = lessonRespository.findLessonById(deleteLessonRequest.getLessonID()).orElse(null);
            // if lesson is null -> lesson does not exist -> tell the user
            if (Objects.isNull(lesson)) {
                log.debug("Delete Lesson failed: Lesson does not exist");
                return new ResponseCommon<>(ResponseCode.LESSON_NOT_EXIST, null);
            }
            // if lesson not null -> update the lesson
            else {
                Lesson deleteLesson = lesson;
                deleteLesson.setDeleted(true);
                lessonRespository.save(deleteLesson);
                DeleteLessonResponse deleteLessonResponse = new DeleteLessonResponse();
                deleteLessonResponse.setLessonName(deleteLesson.getName());
                deleteLessonResponse.setLessonID(deleteLesson.getId());
                deleteLessonResponse.setOrdNumber(deleteLesson.getOrdNumber());
                deleteLessonResponse.setCourseID(deleteLesson.getCourse().getId());
                deleteLessonResponse.setLinkContent(deleteLesson.getLinkContent());
                deleteLessonResponse.setDescription(deleteLesson.getDescription());
                deleteLessonResponse.setCreatedAt(deleteLesson.getCreatedAt());
                LocalDateTime updateAt = LocalDateTime.now();
                deleteLessonResponse.setUpdateAt(updateAt);
                log.debug("Delete Lesson successful");
                return new ResponseCommon<>(ResponseCode.SUCCESS, deleteLessonResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("Delete Lesson failed: " + e.getMessage());
            return new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Delete Lesson Fail", null);
        }
    }

    @Override
    public ResponseCommon<FindAllLessonResponse> findAllLesson() {
        try {
            List<Lesson> listLesson = lessonRespository.findAllByIsDeleted(false);
            // if the list of lessons is empty -> tell the user
            if (listLesson.isEmpty()) {
                log.debug("Get all Lesson failed: Lesson list is empty");
                return new ResponseCommon<>(ResponseCode.LESSON_LIST_IS_EMPTY, null);
            } else {
                FindAllLessonResponse response = new FindAllLessonResponse("Get all lesson success", listLesson);
                log.debug("Get all Lesson successful");
                return new ResponseCommon<>(ResponseCode.SUCCESS, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("Get all Lesson failed: " + e.getMessage());
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }
}
