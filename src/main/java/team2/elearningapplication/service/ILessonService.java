package team2.elearningapplication.service;

import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.lesson.AddLessonRequest;
import team2.elearningapplication.dto.request.admin.lesson.DeleteLessonRequest;
import team2.elearningapplication.dto.request.admin.lesson.UpdateLessonRequest;
import team2.elearningapplication.dto.response.admin.lesson.AddLessonResponse;
import team2.elearningapplication.dto.response.admin.lesson.DeleteLessonResponse;
import team2.elearningapplication.dto.response.admin.lesson.FindAllLessonResponse;
import team2.elearningapplication.dto.response.admin.lesson.UpdateLessonResponse;
import team2.elearningapplication.entity.Lesson;

import java.util.List;

public interface ILessonService {
    ResponseCommon<AddLessonResponse> addLesson(AddLessonRequest addLessonRequest);
    ResponseCommon<UpdateLessonResponse> updateLesson(UpdateLessonRequest updateLessonRequest);
    ResponseCommon<DeleteLessonResponse> deleteLesson(DeleteLessonRequest deleteLessonRequest);

    ResponseCommon<FindAllLessonResponse> findAllLesson();
}
