package team2.elearningapplication.service.implement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import team2.elearningapplication.Enum.*;
import team2.elearningapplication.dto.common.PaymentRes;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.course.AddCourseRequest;
import team2.elearningapplication.dto.request.admin.course.DeleteCourseRequest;
import team2.elearningapplication.dto.request.admin.course.GetCourseByIdRequest;
import team2.elearningapplication.dto.request.admin.course.UpdateCourseRequest;
import team2.elearningapplication.dto.common.PageRequestDTO;
import team2.elearningapplication.dto.request.user.course.EnrollCourseRequest;
import team2.elearningapplication.dto.request.user.course.PaymentConfirmRequest;
import team2.elearningapplication.dto.request.user.course.SearchCourseByNameAndCategoryRequest;
import team2.elearningapplication.dto.response.admin.course.*;
import team2.elearningapplication.dto.response.user.course.*;
import team2.elearningapplication.entity.*;
import team2.elearningapplication.repository.*;
import team2.elearningapplication.service.ICourseService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl implements ICourseService {
    private final ICourseRepository courseRepository;
    private final ICategoryRepository categoryRepository;
    private final IUserRepository userRepository;
    private final OrderRepository orderRepository;
    private final PaymentService paymentService;
    private final IPaymentRepository paymentRepository;
    private final IHistoryResgisterCourseRepository historyRegisterCourseRepository;
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
            if (Objects.isNull(course)) {
                log.debug("Get Course By Id failed: Course does not exist");
                return new ResponseCommon<>(ResponseCode.COURSE_NOT_EXIST, null);
            } else {
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

    @Override
    public ResponseCommon<GetTopCourseResponse> getTopCourse(int numberCourse) {
        try {
            List<Course> topCourse = courseRepository.getTopCourses(numberCourse);
            // if topCourse is empty -> tell user
            if (topCourse.isEmpty()) {
                return new ResponseCommon<>(ResponseCode.COURSE_LIST_IS_EMPTY.getCode(), "Course list is empty", null);
            } else {
                GetTopCourseResponse getTopCourseResponse = new GetTopCourseResponse(topCourse);
                return new ResponseCommon<>(ResponseCode.SUCCESS.getCode(), "Get top course success", getTopCourseResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("Get Top Course failed: " + e.getMessage());
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }

    @Override
    public ResponseCommon<GetNewestCourseResponse> getNewestCourse(int numberCourse) {
        try {
            List<Course> topNewestCourse = courseRepository.getTopNewCourse(numberCourse);
            // if topCourse is empty -> tell user
            if (topNewestCourse.isEmpty()) {
                return new ResponseCommon<>(ResponseCode.COURSE_LIST_IS_EMPTY.getCode(), "Course list is empty", null);
            } else {
                GetNewestCourseResponse getNewestCourseResponse = new GetNewestCourseResponse(topNewestCourse);
                return new ResponseCommon<>(ResponseCode.SUCCESS.getCode(), "Get newest course success", getNewestCourseResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("Get Newest Course failed: " + e.getMessage());
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }

    @Override
    public ResponseCommon<GetCourseByUserResponse> getCourseByUser(String username) {
        try {
            User user = userRepository.findByUsername(username).orElse(null);
            List<Course> courseList = courseRepository.getCoursesByUserId(user.getId());
            // if courseList is empty -> tell user
            if (courseList.isEmpty()) {
                return new ResponseCommon<>(ResponseCode.COURSE_LIST_IS_EMPTY.getCode(), "User not enroll any course", null);
            } else {
                GetCourseByUserResponse getCourseByUserResponse = new GetCourseByUserResponse(courseList);
                return new ResponseCommon<>(ResponseCode.SUCCESS.getCode(), "Get course by user success", getCourseByUserResponse);
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.debug("Get Newest Course failed: " + e.getMessage());
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }

    @Override
    public ResponseCommon<GetTotalCourseResponse> getTotalCourse() {
        try {
            int totalCourse = courseRepository.getTotalCourse();
            GetTotalCourseResponse getTotalCourseResponse = new GetTotalCourseResponse(totalCourse);
            return new ResponseCommon<>(ResponseCode.SUCCESS.getCode(), "Get total course success", getTotalCourseResponse);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("Get Total Course failed: " + e.getMessage());
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }

    @Override
    public ResponseCommon<SearchCourseByNameAndCategoryResponse> searchCourse(SearchCourseByNameAndCategoryRequest searchCourseByNameAndCategoryRequest) {
        try {
            List<Course> courseList = courseRepository.searchCoursesByNameOrCategory(searchCourseByNameAndCategoryRequest.getKeyword());
            // if courseList is empty -> tell user
            if (courseList.isEmpty()) {
                return new ResponseCommon<>(ResponseCode.COURSE_LIST_IS_EMPTY.getCode(), "Not course match with search", null);
            } else {
                SearchCourseByNameAndCategoryResponse searchCourseByNameAndCategoryResponse = new SearchCourseByNameAndCategoryResponse(courseList);
                return new ResponseCommon<>(ResponseCode.SUCCESS.getCode(), "Search success", searchCourseByNameAndCategoryResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("Get search Course failed: " + e.getMessage());
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }

    @Override
    public ResponseCommon<PageCourseResponse> getAllCoursePage(PageRequestDTO pageRequestDTO) {
        try {
            int pageNo = pageRequestDTO.getPageNo();
            int pageSize = pageRequestDTO.getPageSize();
            String sortBy = pageRequestDTO.getSortBy();
            String sortDir = pageRequestDTO.getSortDir();

            Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.fromString(sortDir), sortBy));

            Page<Course> coursePage = courseRepository.findAllByIsDeleted(false, pageable);
            if (coursePage.isEmpty()) {
                return new ResponseCommon<>(ResponseCode.COURSE_LIST_IS_EMPTY, null);
            }
            PageCourseResponse response = new PageCourseResponse();
            response.setCourseList(coursePage.getContent());
            response.setPageNo(pageNo);
            response.setPageSize(pageSize);
            response.setTotalElements((int) coursePage.getTotalElements());
            response.setTotalPages(coursePage.getTotalPages());
            response.setLast(coursePage.isLast());
            return new ResponseCommon<>(ResponseCode.SUCCESS, response);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("Get  Course page  failed: " + e.getMessage());
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }

    @Override
    public ResponseCommon<EnrollCourseResponse> enrollCourse(EnrollCourseRequest enrollCourseRequest) {
        try {
            EnrollCourseResponse enrollCourseResponse = new EnrollCourseResponse();

            Order order = new Order();
            order.setCreated_at(LocalDateTime.now());
            order.setUser(userRepository.findById(enrollCourseRequest.getUserId()).orElse(null));
            order.setCourse(courseRepository.findCourseById(enrollCourseRequest.getCourseId()).orElse(null));
            order.setEnumTypeProcessPayment(EnumTypeProcessPayment.INPROCESS);
            order.setAmount(enrollCourseRequest.getAmount());
            orderRepository.save(order);

            ResponseCommon<PaymentRes> paymentResponse = paymentService.addPayment(enrollCourseRequest.getAmount());
            if (paymentResponse.getCode() == ResponseCode.SUCCESS.getCode()) {
                enrollCourseResponse.setOrderId(order.getId());
                enrollCourseResponse.setUrlPayment(paymentResponse.getData().getUrl());
                return new ResponseCommon<>(ResponseCode.SUCCESS.getCode(), "Send url done", enrollCourseResponse);
            } else {
                log.debug("Enroll course response faile because paymentResponse not success.");
                return new ResponseCommon<>(ResponseCode.SEND_URL_PAYMENT_FAIL.getCode(), "Send url fail", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("Enroll Course failed: " + e.getMessage());
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }

    @Override
    public ResponseCommon<PaymentConfirmResponse> paymentConfirm(PaymentConfirmRequest paymentConfirmRequest) {
        try {
            Order order = orderRepository.getOrderById(paymentConfirmRequest.getOrderId()).orElse(null);
            if(Objects.isNull(order)){
                return new ResponseCommon<>(ResponseCode.ORDER_NOT_EXIST,null);
            } else {
                // if response code not equal 00
                if(!paymentConfirmRequest.getResponseCode().equals("00")){
                    return new ResponseCommon<>(ResponseCode.PAYMENT_FAIL,null);
                } else {
                    Payment payment = new Payment();
                    HistoryRegisterCourse historyRegisterCourse = new HistoryRegisterCourse();
                    payment.setUser(order.getUser());
                    payment.setCourse(order.getCourse());
                    payment.setPaymentGateway(EnumPaymentGateway.VN_PAY);
                    payment.setTransaction_id("vnpay");
                    payment.setAmount(order.getAmount());
                    payment.setEnumPaymentProcess(EnumPaymentProcess.SUCCESS);
                    payment.setCreated_at(LocalDateTime.now());
                    paymentRepository.save(payment);
                    order.setPayment(payment);
                    orderRepository.save(order);

                    historyRegisterCourse.setCourseId(payment.getCourse());
                    historyRegisterCourse.setUser(payment.getUser());
                    historyRegisterCourse.setSttLessonCurrent(1);
                    historyRegisterCourse.setPayment(payment);
                    historyRegisterCourse.setProcess(EnumTypeProcessAccount.NOT_READY);
                    historyRegisterCourse.setCreatedAt(LocalDateTime.now());
                    historyRegisterCourse.setOrder(order);
                    historyRegisterCourseRepository.save(historyRegisterCourse);
                    PaymentConfirmResponse paymentConfirmResponse = new PaymentConfirmResponse();
                    paymentConfirmResponse.setStatus("Payment done");
                    return new ResponseCommon<>(ResponseCode.SUCCESS.getCode(),"Accept to join course",paymentConfirmResponse);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            log.debug("Enroll Course failed: " + e.getMessage());
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }
}

