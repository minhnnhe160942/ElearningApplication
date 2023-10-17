package team2.elearningapplication.service;

import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.course.AddCourseRequest;
import team2.elearningapplication.dto.request.admin.course.DeleteCourseRequest;
import team2.elearningapplication.dto.request.admin.course.GetCourseByIdRequest;
import team2.elearningapplication.dto.request.admin.course.UpdateCourseRequest;
import team2.elearningapplication.dto.response.admin.course.*;
import team2.elearningapplication.dto.response.user.course.GetCourseByUserResponse;
import team2.elearningapplication.dto.response.user.course.GetNewestCourseResponse;
import team2.elearningapplication.dto.response.user.course.GetTopCourseResponse;

public interface ICourseService {
    ResponseCommon<AddCourseResponse> addCourse(AddCourseRequest addCourseRequest);

    ResponseCommon<UpdateCourseResponse> updateCourse(UpdateCourseRequest updateCourseRequest);

    ResponseCommon<DeleteCourseResponse> deleteCourse(DeleteCourseRequest deleteCourseRequest);

    ResponseCommon<FindAllCourseResponse> findAllCourse();
    ResponseCommon<GetCourseByIdResponse> getCourseById(GetCourseByIdRequest getCourseByIdRequest);

    ResponseCommon<GetTopCourseResponse> getTopCourse(int numberCourse);

    ResponseCommon<GetNewestCourseResponse> getNewestCourse(int numberCourse);

    ResponseCommon<GetCourseByUserResponse> getCourseByUser(String username);

}
