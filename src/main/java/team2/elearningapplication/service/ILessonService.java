package team2.elearningapplication.service;

import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.AddLessonRequest;
import team2.elearningapplication.dto.response.AddLessonResponse;
import team2.elearningapplication.entity.Course;
import team2.elearningapplication.entity.Lesson;

import java.util.List;

public interface ILessonService {
    ResponseCommon<AddLessonResponse> addLesson(AddLessonRequest requestDTO);

    Lesson updateLesson(Lesson lesson);

    List<Lesson> getAllLessonFromCourse(Course course);

    void deleteLesson(int id);
}
