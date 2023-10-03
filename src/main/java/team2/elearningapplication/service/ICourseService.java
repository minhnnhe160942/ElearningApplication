package team2.elearningapplication.service;

import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.course.AddCourseRequest;
import team2.elearningapplication.dto.request.admin.course.DeleteCourseRequest;
import team2.elearningapplication.dto.request.admin.course.UpdateCourseRequest;
import team2.elearningapplication.dto.response.admin.course.AddCourseResponse;
import team2.elearningapplication.dto.response.admin.course.DeleteCourseResponse;
import team2.elearningapplication.dto.response.admin.course.UpdateCourseResponse;

public interface ICourseService {
    ResponseCommon<AddCourseResponse> addCourse(AddCourseRequest addCourseRequest);

    ResponseCommon<UpdateCourseResponse> updateCourse(UpdateCourseRequest updateCourseRequest);

    ResponseCommon<DeleteCourseResponse> deleteCourse(DeleteCourseRequest deleteCourseRequest);
}
