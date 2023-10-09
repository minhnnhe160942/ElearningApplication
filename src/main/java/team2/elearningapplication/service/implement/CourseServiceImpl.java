package team2.elearningapplication.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team2.elearningapplication.Enum.ResponseCode;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.course.AddCourseRequest;
import team2.elearningapplication.dto.request.admin.course.DeleteCourseRequest;
import team2.elearningapplication.dto.request.admin.course.UpdateCourseRequest;
import team2.elearningapplication.dto.response.admin.course.AddCourseResponse;
import team2.elearningapplication.dto.response.admin.course.DeleteCourseResponse;
import team2.elearningapplication.dto.response.admin.course.UpdateCourseResponse;
import team2.elearningapplication.entity.Category;
import team2.elearningapplication.entity.Course;
import team2.elearningapplication.repository.ICategoryRepository;
import team2.elearningapplication.repository.ICourseRepository;
import team2.elearningapplication.service.ICourseService;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl  implements ICourseService {
    private final ICourseRepository courseRepository;
    private final ICategoryRepository categoryRepository;
    @Override
    public ResponseCommon<AddCourseResponse> addCourse(AddCourseRequest addCourseRequest) {
        try {
            Course course = courseRepository.findCourseByName(addCourseRequest.getName()).orElse(null);
            // if course not null -> tell user
            if (!Objects.isNull(course)) {
                return new ResponseCommon<>(ResponseCode.COURSE_EXIST, null);
            }
            // if course is null -> new course
            if (Objects.isNull(course)) {
                course = new Course();
            }
            course.setName(addCourseRequest.getName());
            course.setDescription(addCourseRequest.getDescription());
            course.setLinkThumnail(addCourseRequest.getLink_thumnail());
            course.setPrice(addCourseRequest.getPrice());
            course.setCreatedAt(LocalDateTime.now());
            Category category = categoryRepository.findCategoryByName(addCourseRequest.getCategory()).orElse(null);
            course.setCategory(category);

            // Save course to database
            Course savedCourse = courseRepository.save(course);

            // If course is not saved successfully, return a FAIL response
            if (savedCourse == null) {
                return new ResponseCommon<>(ResponseCode.FAIL, null);
            }

            AddCourseResponse addCourseResponse = new AddCourseResponse("Add course success");
            return new ResponseCommon<>(ResponseCode.SUCCESS, addCourseResponse);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }

    @Override
    public ResponseCommon<UpdateCourseResponse> updateCourse(UpdateCourseRequest updateCourseRequest) {
        try {
            Course courseExist = courseRepository.findCourseById(updateCourseRequest.getCourseID()).orElse(null);
            // if courseExist is null -> tell user
            if(Objects.isNull(courseExist)) return new ResponseCommon<>(ResponseCode.COURSE_NOT_EXIST,null);
            else {
                Category category = categoryRepository.findCategoryById(updateCourseRequest.getCategoryID()).orElse(null);
                Course courseUpdate = courseExist;
                courseUpdate.setCategory(category);
                courseUpdate.setName(updateCourseRequest.getName());
                courseUpdate.setDescription(updateCourseRequest.getDescription());
                courseUpdate.setPrice(updateCourseRequest.getPrice());
                courseUpdate.setLinkThumnail(updateCourseRequest.getLink_thumnail());
                courseUpdate.setCreatedAt(LocalDateTime.now());
                courseRepository.save(courseUpdate);
                UpdateCourseResponse updateCourseResponse = new UpdateCourseResponse("Update course success");
                return new ResponseCommon<>(ResponseCode.SUCCESS,updateCourseResponse);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL,null);
        }
    }

    @Override
    public ResponseCommon<DeleteCourseResponse> deleteCourse(DeleteCourseRequest deleteCourseRequest) {
        try {
            Course courseExist = courseRepository.findCourseById(deleteCourseRequest.getCourseID()).orElse(null);
            // if courseExist is null -> tell user
            if(Objects.isNull(courseExist)) return new ResponseCommon<>(ResponseCode.COURSE_NOT_EXIST,null);
            else {
                Course courseDelete = courseExist;
                courseDelete.setDeleted(true);
                courseRepository.save(courseDelete);
                DeleteCourseResponse deleteCourseResponse = new DeleteCourseResponse("Delete course success");
                return new ResponseCommon<>(ResponseCode.SUCCESS,deleteCourseResponse);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL,null);
        }
    }


}