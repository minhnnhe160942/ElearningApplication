package team2.elearningapplication.service.implement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import team2.elearningapplication.Enum.ResponseCode;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.*;
import team2.elearningapplication.dto.response.*;
import team2.elearningapplication.entity.Category;
import team2.elearningapplication.entity.Course;
import team2.elearningapplication.repository.ICourseRepository;
import team2.elearningapplication.service.ICourseService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl implements ICourseService {
    private final ICourseRepository courseRepository;

    @Override
    public ResponseCommon<AddCourseResponse> addCourse(AddCourseRequest requestDTO) {
        try {
            Course course = new Course();
            course.setName(requestDTO.getName());
            course.setDescription(requestDTO.getDescription());
            course.setCategory(requestDTO.getCategory());
            course.setCreatedAt(requestDTO.getCreatedAt());
            course.setLinkThumnail(requestDTO.getLinkThumnail());

            courseRepository.save(course);

            AddCourseResponse responseDTO = new AddCourseResponse();
            responseDTO.setCourse(course);

            return new ResponseCommon<>(ResponseCode.SUCCESS, responseDTO);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }

    @Override
    public ResponseCommon<UpdateCourseResponse> updateCourse(UpdateCourseRequest requestDTO) {
        try {
            Optional<Course> existingCourse = courseRepository.findById(requestDTO.getId());
            if ( existingCourse.isPresent() ) {
                Course updateCourse = existingCourse.get();
                updateCourse.setName(requestDTO.getName());
                updateCourse.setDescription(requestDTO.getDescription());
                updateCourse.setCategory(requestDTO.getCategory());
                updateCourse.setCreatedAt(requestDTO.getCreatedAt());
                updateCourse.setLinkThumnail(requestDTO.getLinkThumnail());

                courseRepository.save(updateCourse);

                UpdateCourseResponse responseDTO = new UpdateCourseResponse();
                responseDTO.setCourse(updateCourse);

                return new ResponseCommon<>(ResponseCode.SUCCESS, responseDTO);
            }
            else {
                return new ResponseCommon<>(ResponseCode.FAIL, null);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }

    @Override
    public ResponseCommon<DeleteCourseResponse> deleteCourse(DeleteCourseRequest requestDTO) {
        try {
            Optional<Course> existingCourse = courseRepository.findById(requestDTO.getId());
            if ( existingCourse.isPresent() ) {
                Course course = existingCourse.get();

                courseRepository.delete(course);

                DeleteCourseResponse responseDTO = new DeleteCourseResponse();

                return new ResponseCommon<>(ResponseCode.SUCCESS, responseDTO);
            }
            else {
                return new ResponseCommon<>(ResponseCode.FAIL, null);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }

    @Override
    public ResponseCommon<GetCourseByNameResponse> getCourseByName(GetCourseByNameRequest requestDTO) {
        try {
            String name = requestDTO.getName();
            List<Course> listCourse = courseRepository.findAllByName(name);

            GetCourseByNameResponse responseDTO = new GetCourseByNameResponse();
            responseDTO.setListCourse(listCourse);

            return new ResponseCommon<>(ResponseCode.SUCCESS, responseDTO);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }

    @Override
    public ResponseCommon<GetCourseByCategoryResponse> getCourseByCategory(GetCourseByCategoryRequest requestDTO) {
        try {
            Category category = requestDTO.getCategory();
            List<Course> listCourse = courseRepository.findAllByCategory(category);

            GetCourseByCategoryResponse responseDTO = new GetCourseByCategoryResponse();
            responseDTO.setListCourse(listCourse);

            return new ResponseCommon<>(ResponseCode.SUCCESS, responseDTO);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }
}
