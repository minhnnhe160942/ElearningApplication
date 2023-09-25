package team2.elearningapplication.service.implement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import team2.elearningapplication.Enum.ResponseCode;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.AddLessonRequest;
import team2.elearningapplication.dto.response.AddLessonResponse;
import team2.elearningapplication.entity.Course;
import team2.elearningapplication.entity.Lesson;
import team2.elearningapplication.repository.ILessonRepository;
import team2.elearningapplication.service.ILessonService;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LessonServiceImpl implements ILessonService {
    private final ILessonRepository lessonRepository;

    @Override
    public ResponseCommon<AddLessonResponse> addLesson(AddLessonRequest requestDTO) {
        try {
            Lesson lesson = new Lesson();
            lesson.setCourse(requestDTO.getCourse());
            lesson.setLinkContent(requestDTO.getLinkContent());
            lesson.setDescription(requestDTO.getDescription());
            lesson.setCreatedAt(requestDTO.getCreatedAt());

            AddLessonResponse responseDTO = new AddLessonResponse();
            responseDTO.setCourse(lesson.getCourse());
            responseDTO.setLinkContent(lesson.getLinkContent());
            responseDTO.setDescription(lesson.getDescription());
            responseDTO.setCreatedAt(lesson.getCreatedAt());

            return new ResponseCommon<>(ResponseCode.SUCCESS, responseDTO);
        } catch ( Exception e ) {
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }

    @Override
    public Lesson updateLesson(Lesson lesson) {
        Optional<Lesson> existingLesson = lessonRepository.findById(lesson.getId());
        if ( existingLesson.isPresent() ) {
            Lesson updateLesson = existingLesson.get();
            updateLesson.setCourse(lesson.getCourse());
            updateLesson.setLinkContent(lesson.getLinkContent());
            updateLesson.setDescription(lesson.getDescription());
            updateLesson.setCreatedAt(lesson.getCreatedAt());

            return lessonRepository.save(updateLesson);
        }
        return  null;
    }

    @Override
    public List<Lesson> getAllLessonFromCourse(Course course) {
        return lessonRepository.findAll(course);
    }

    @Override
    public void deleteLesson(int id) {
        lessonRepository.deleteById(id);
    }
}
