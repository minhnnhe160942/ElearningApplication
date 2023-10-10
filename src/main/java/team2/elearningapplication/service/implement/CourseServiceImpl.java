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
import team2.elearningapplication.dto.response.admin.course.FindAllCourseResponse;
import team2.elearningapplication.dto.response.admin.course.UpdateCourseResponse;
import team2.elearningapplication.entity.Category;
import team2.elearningapplication.entity.Course;
import team2.elearningapplication.repository.ICategoryRepository;
import team2.elearningapplication.repository.ICourseRepository;
import team2.elearningapplication.service.ICourseService;

import java.time.LocalDateTime;
import java.util.List;
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

            AddCourseResponse addCourseResponse = new AddCourseResponse();
            addCourseResponse.setCourseID(course.getId());
            addCourseResponse.setCourseName(course.getName());
            addCourseResponse.setDescription(course.getDescription());
            addCourseResponse.setPrice(course.getPrice());
            addCourseResponse.setCategory(course.getCategory());
            addCourseResponse.setLinkThumail(course.getLinkThumnail());
            addCourseResponse.setCreatedAt(course.getCreatedAt());
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
                UpdateCourseResponse updateCourseResponse = new UpdateCourseResponse();
                updateCourseResponse.setCourseID(courseUpdate.getId());
                updateCourseResponse.setCourseName(courseUpdate.getName());
                updateCourseResponse.setDescription(courseUpdate.getDescription());
                updateCourseResponse.setPrice(courseUpdate.getPrice());
                updateCourseResponse.setCategory(courseUpdate.getCategory());
                updateCourseResponse.setLinkThumail(courseUpdate.getLinkThumnail());
                LocalDateTime localDateTime = LocalDateTime.now();
                updateCourseResponse.setUpdateAt(localDateTime);
                updateCourseResponse.setCreateAt(courseUpdate.getCreatedAt());
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
                DeleteCourseResponse deleteCourseResponse = new DeleteCourseResponse();
                deleteCourseResponse.setCourseID(courseDelete.getId());
                deleteCourseResponse.setCourseName(courseDelete.getName());
                deleteCourseResponse.setDescription(courseDelete.getDescription());
                deleteCourseResponse.setPrice(courseDelete.getPrice());
                deleteCourseResponse.setCategory(courseDelete.getCategory());
                deleteCourseResponse.setLinkThumail(courseDelete.getLinkThumnail());
                deleteCourseResponse.setCreatedAt(courseDelete.getCreatedAt());
                deleteCourseResponse.setDeleted(courseDelete.isDeleted());
                return new ResponseCommon<>(ResponseCode.SUCCESS,deleteCourseResponse);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL,null);
        }
    }

    public ResponseCommon<FindAllCourseResponse> findAllCourse() {
        try {
            // Get all courses with isDeleted is false
            List<Course> listCourse = courseRepository.findAllByIsDeleted(false);

            // if listCourse is empty -> tell user
            if(listCourse.isEmpty()){
                return new ResponseCommon<>(ResponseCode.COURSE_LIST_IS_EMPTY,null);
            } // else -> return list course
            else {
                FindAllCourseResponse response = new FindAllCourseResponse("Get all course success",listCourse);
                return new ResponseCommon<>(ResponseCode.SUCCESS,response);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL,null);
        }
    }



}