package team2.elearningapplication.service;

import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.lesson.AddLessonRequest;
import team2.elearningapplication.dto.response.admin.lesson.AddLessonResponse;
import team2.elearningapplication.entity.Lesson;

public interface ILessonService {
    ResponseCommon<AddLessonResponse> addLesson(AddLessonRequest addLessonRequest);
}
