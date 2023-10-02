package team2.elearningapplication.service;

import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.*;
import team2.elearningapplication.dto.response.*;

public interface ICourseService {
    ResponseCommon<AddCourseResponse> addCourse(AddCourseRequest requestDTO);
    ResponseCommon<UpdateCourseResponse> updateCourse(UpdateCourseRequest requestDTO);
    ResponseCommon<DeleteCourseResponse> deleteCourse(DeleteCourseRequest requestDTO);
    ResponseCommon<GetCourseByNameResponse> getCourseByName(GetCourseByNameRequest requestDTO);
    ResponseCommon<GetCourseByCategoryResponse> getCourseByCategory(GetCourseByCategoryRequest requestDTO);
}
