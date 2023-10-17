package team2.elearningapplication.service.implement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import team2.elearningapplication.Enum.ResponseCode;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.course.AddCourseRequest;
import team2.elearningapplication.dto.request.admin.course.DeleteCourseRequest;
import team2.elearningapplication.dto.request.admin.course.GetCourseByIdRequest;
import team2.elearningapplication.dto.request.admin.course.UpdateCourseRequest;
import team2.elearningapplication.dto.response.admin.course.*;
import team2.elearningapplication.entity.Category;
import team2.elearningapplication.entity.Course;
import team2.elearningapplication.repository.ICategoryRepository;
import team2.elearningapplication.repository.ICourseRepository;
import team2.elearningapplication.service.ICourseService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl implements ICourseService {
    private final ICourseRepository courseRepository;
    private final ICategoryRepository categoryRepository;

    @Override
    public ResponseCommon<AddCourseResponse> addCourse(AddCourseRequest addCourseRequest) {
        try {
            Course course = courseRepository.findCourseByName(addCourseRequest.getName()).orElse(null);
            // if course not null -> tell the user
            if (!Objects.isNull(course)) {
                log.debug("Add Course failed: Course already exists");
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

            // Save course to the database
            Course savedCourse = courseRepository.save(course);

            // If the course is not saved successfully, return a FAIL response
            if (savedCourse == null) {
                log.debug("Add Course failed: Unable to save the course");
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
            log.debug("Add Course successful");
            return new ResponseCommon<>(ResponseCode.SUCCESS, addCourseResponse);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("Add Course failed: " + e.getMessage());
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }

    @Override
    public ResponseCommon<UpdateCourseResponse> updateCourse(UpdateCourseRequest updateCourseRequest) {
        try {
            Course courseExist = courseRepository.findCourseById(updateCourseRequest.getCourseID()).orElse(null);
            // if courseExist is null -> tell the user
            if (Objects.isNull(courseExist)) {
                log.debug("Update Course failed: Course does not exist");
                return new ResponseCommon<>(ResponseCode.COURSE_NOT_EXIST, null);
            } else {
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
                log.debug("Update Course successful");
                return new ResponseCommon<>(ResponseCode.SUCCESS, updateCourseResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("Update Course failed: " + e.getMessage());
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }

    @Override
    public ResponseCommon<DeleteCourseResponse> deleteCourse(DeleteCourseRequest deleteCourseRequest) {
        try {
            Course courseExist = courseRepository.findCourseById(deleteCourseRequest.getCourseID()).orElse(null);
            // if courseExist is null -> tell the user
            if (Objects.isNull(courseExist)) {
                log.debug("Delete Course failed: Course does not exist");
                return new ResponseCommon<>(ResponseCode.COURSE_NOT_EXIST, null);
            } else {
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
                log.debug("Delete Course successful");
                return new ResponseCommon<>(ResponseCode.SUCCESS, deleteCourseResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("Delete Course failed: " + e.getMessage());
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }

    public ResponseCommon<FindAllCourseResponse> findAllCourse() {
        try {
            // Get all courses with isDeleted is false
            List<Course> listCourse = courseRepository.findAllByIsDeleted(false);

            // if listCourse is empty -> tell the user
            if (listCourse.isEmpty()) {
                log.debug("Get all Course failed: Course list is empty");
                return new ResponseCommon<>(ResponseCode.COURSE_LIST_IS_EMPTY, null);
            } // else -> return the list of courses
            else {
                FindAllCourseResponse response = new FindAllCourseResponse("Get all success", listCourse);
                log.debug("Get all Course successful");
                return new ResponseCommon<>(ResponseCode.SUCCESS, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("Get all Course failed: " + e.getMessage());
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }

    @Override
    public ResponseCommon<GetCourseByIdResponse> getCourseById(GetCourseByIdRequest getCourseByIdRequest) {
        try {
            Course course = courseRepository.findCourseById(getCourseByIdRequest.getId()).orElse(null);
            // If course does not exist
            if ( Objects.isNull(course) ) {
                log.debug("Get Course By Id failed: Course does not exist");
                return new ResponseCommon<>(ResponseCode.COURSE_NOT_EXIST, null);
            }
            else {
                GetCourseByIdResponse response = new GetCourseByIdResponse();
                response.setId(course.getId());
                response.setName(course.getName());
                response.setDescription(course.getDescription());
                response.setCategory(course.getCategory());
                response.setPrice(course.getPrice());
                response.setLinkThumail(course.getLinkThumnail());
                response.setCreateAt(course.getCreatedAt());
                response.setDeleted(course.isDeleted());

                log.debug("Get Course by id successful");
                return new ResponseCommon<>(ResponseCode.SUCCESS, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("Get Course By Id failed: " + e.getMessage());
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }
}
