package team2.elearningapplication.controller;

import lombok.AllArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team2.elearningapplication.Enum.ResponseCode;
import team2.elearningapplication.dto.common.PageRequestDTO;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.course.AddCourseRequest;
import team2.elearningapplication.dto.request.admin.course.DeleteCourseRequest;
import team2.elearningapplication.dto.request.admin.course.GetCourseByIdRequest;
import team2.elearningapplication.dto.request.admin.course.UpdateCourseRequest;
import team2.elearningapplication.dto.request.user.course.*;
import team2.elearningapplication.dto.response.admin.GetTotalRevenueResponse;
import team2.elearningapplication.dto.response.admin.course.*;
import team2.elearningapplication.dto.response.user.course.*;
import team2.elearningapplication.service.ICourseService;
import team2.elearningapplication.service.IPaymentService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/course")
@AllArgsConstructor
public class CourseController {
    private ICourseService courseService;
    private IPaymentService paymentService;
    private final int TOP_COURSE = 10;

    @PostMapping("/add-course")
    public ResponseEntity<ResponseCommon<AddCourseResponse>> addCourse(@Valid @RequestBody AddCourseRequest addCourseRequest){
        ResponseCommon<AddCourseResponse> response = courseService.addCourse(addCourseRequest);
        // if code of response equal code SUCCESS  -> return ok
        if(response.getCode() == ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } else if(response.getCode() == ResponseCode.COURSE_EXIST.getCode()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseCommon<>(response.getCode(),"Course already exsit",null));
        } else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Add course fail",null));
        }
    }

    @PostMapping("/update-course")
    public ResponseEntity<ResponseCommon<UpdateCourseResponse>> updateCouse(@Valid @RequestBody UpdateCourseRequest updateCourseRequest){
        ResponseCommon<UpdateCourseResponse> response = courseService.updateCourse(updateCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Update course fail",null));
        }
    }

    @PostMapping("/delete-course")
    public ResponseEntity<ResponseCommon<DeleteCourseResponse>> updateCouse(@Valid @RequestBody DeleteCourseRequest deleteCourseRequest){
        ResponseCommon<DeleteCourseResponse> response = courseService.deleteCourse(deleteCourseRequest);
        // if code of response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } // if code equal course not exist -> tell error
        else if (response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(response.getCode(),"Course not exist",null));
        } // else -> return fail  update
        else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Delete course fail",null));
        }
    }

    @GetMapping("/find-all-course")
    public ResponseEntity<ResponseCommon<FindAllCourseResponse>> findAllCourse(){
        ResponseCommon<FindAllCourseResponse> response = courseService.findAllCourse();
        // if code response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } //  if code response equals code courseList empty -> tell user
        else if(response.getCode()==ResponseCode.COURSE_LIST_IS_EMPTY.getCode()){
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.COURSE_LIST_IS_EMPTY.getCode(),"Course list is empty",null));
        } // else -> return fail
        else{
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL,null));
        }
    }

    @GetMapping("/get-course-by-id")
    public ResponseEntity<ResponseCommon<GetCourseByIdResponse>> getCourseById(GetCourseByIdRequest request){
        ResponseCommon<GetCourseByIdResponse> response = courseService.getCourseById(request);
        // if code response equal code success -> return ok
        if(response.getCode()==ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok(response);
        } //  if code response equals code course empty -> tell user
        else if(response.getCode()==ResponseCode.COURSE_NOT_EXIST.getCode()){
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.COURSE_NOT_EXIST.getCode(),"Course not exist",null));
        } // else -> return fail
        else{
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL,null));
        }
    }

    @GetMapping("/get-top-course")
    public ResponseEntity<ResponseCommon<GetTopCourseResponse>> getTopCourse(){
        ResponseCommon<GetTopCourseResponse> response = courseService.getTopCourse(TOP_COURSE);
        // if response code quals empty list code -> tell user
        if(response.getCode() == ResponseCode.COURSE_LIST_IS_EMPTY.getCode()){
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.COURSE_LIST_IS_EMPTY.getCode(),"Course list is empty",null));
        } else if(response.getCode() == ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok().body(new ResponseCommon<>(ResponseCode.SUCCESS.getCode(),"Get top course success",response.getData()));
        } else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Get top course fail",null));
        }
    }

    @GetMapping("/get-newest-course")
    public ResponseEntity<ResponseCommon<GetNewestCourseResponse>> getNewestCourse(){
        ResponseCommon<GetNewestCourseResponse> response = courseService.getNewestCourse(TOP_COURSE);
        // if response code quals empty list code -> tell user
        if(response.getCode() == ResponseCode.COURSE_LIST_IS_EMPTY.getCode()){
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.COURSE_LIST_IS_EMPTY.getCode(),"Course list is empty",null));
        } else if(response.getCode() == ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok().body(new ResponseCommon<>(ResponseCode.SUCCESS.getCode(),"Get newest course success",response.getData()));
        } else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Get newest course fail",null));
        }
    }

    @GetMapping("/get-course-user")
    public ResponseEntity<ResponseCommon<GetCourseByUserResponse>> getCourseByUser(GetAllCourseByUserRequest getAllCourseByUserRequest){
        ResponseCommon<GetCourseByUserResponse> response = courseService.getCourseByUser(getAllCourseByUserRequest.getUsername());
        // if response code quals empty list code -> tell user
        if(response.getCode() == ResponseCode.COURSE_LIST_IS_EMPTY.getCode()){
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.COURSE_LIST_IS_EMPTY.getCode(),"Course list is empty",null));
        } else if(response.getCode() == ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok().body(new ResponseCommon<>(ResponseCode.SUCCESS.getCode(),"Get course success",response.getData()));
        } else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Get course fail",null));
        }
    }

    @GetMapping("/get-total-course")
    public ResponseEntity<ResponseCommon<GetTotalCourseResponse>> getCourseByUser(){
        ResponseCommon<GetTotalCourseResponse> response = courseService.getTotalCourse();
        // if response code quals empty list code -> tell user
        if(response.getCode() == ResponseCode.COURSE_LIST_IS_EMPTY.getCode()){
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.COURSE_LIST_IS_EMPTY.getCode(),"Course list is empty",null));
        } else if(response.getCode() == ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok().body(new ResponseCommon<>(ResponseCode.SUCCESS.getCode(),"Get total course success",response.getData()));
        } else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Get total course fail",null));
        }
    }

    @GetMapping("/search-course")
    public ResponseEntity<ResponseCommon<SearchCourseByNameAndCategoryResponse>> searchCourse(SearchCourseByNameAndCategoryRequest searchCourseByNameAndCategoryRequest){
        ResponseCommon<SearchCourseByNameAndCategoryResponse> response = courseService.searchCourse(searchCourseByNameAndCategoryRequest);
        // if response code quals empty list code -> tell user
        if(response.getCode() == ResponseCode.COURSE_LIST_IS_EMPTY.getCode()){
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.COURSE_LIST_IS_EMPTY.getCode(),"Course list is empty",null));
        } else if(response.getCode() == ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok().body(new ResponseCommon<>(ResponseCode.SUCCESS.getCode(),"Search course success",response.getData()));
        } else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Search course fail",null));
        }
    }

    @GetMapping("/page-course")
    public ResponseEntity<ResponseCommon<PageCourseResponse>> coursePage(PageRequestDTO pageRequestDTO){
        ResponseCommon<PageCourseResponse> response = courseService.getAllCoursePage(pageRequestDTO);
        // if response code quals empty list code -> tell user
        if(response.getCode() == ResponseCode.COURSE_LIST_IS_EMPTY.getCode()){
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.COURSE_LIST_IS_EMPTY.getCode(),"Course list is empty",null));
        } else if(response.getCode() == ResponseCode.SUCCESS.getCode()){
            return ResponseEntity.ok().body(new ResponseCommon<>(ResponseCode.SUCCESS.getCode(),"Get  course page success",response.getData()));
        } else {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Get course page fail",null));
        }
    }

    @PostMapping("/enroll-course")
    public ResponseEntity<ResponseCommon<EnrollCourseResponse>> enrollCourse(@Valid @RequestBody EnrollCourseRequest enrollCourseRequest){
        ResponseCommon<EnrollCourseResponse> response = courseService.enrollCourse(enrollCourseRequest);
        if(response.getCode() == ResponseCode.SEND_URL_PAYMENT_FAIL.getCode()){
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.SEND_URL_PAYMENT_FAIL.getCode(),"Send url payment fail",null));
        } else if(response.getCode()==ResponseCode.FAIL.getCode()){
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Exception send url",null));
        } else {
            return ResponseEntity.ok().body(new ResponseCommon<>(ResponseCode.SUCCESS.getCode(),"Send url payment success",response.getData()));
        }
    }

    @GetMapping("/confirm-payment")
    public ResponseEntity<ResponseCommon<PaymentConfirmResponse>> enrollCourse(@ParameterObject PaymentConfirmRequest paymentConfirmRequest){
        ResponseCommon<PaymentConfirmResponse> response = courseService.paymentConfirm(paymentConfirmRequest);
        if(response.getCode() == ResponseCode.ORDER_NOT_EXIST.getCode()){
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.ORDER_NOT_EXIST.getCode(),"Order not exist",null));
        } else if(response.getCode()==ResponseCode.PAYMENT_FAIL.getCode()){
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.PAYMENT_FAIL.getCode(),"Payment fail",null));
        } else if(response.getCode()==ResponseCode.FAIL.getCode()){
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(),"Confirm payment fail",null));
        } else {
            return ResponseEntity.ok().body(new ResponseCommon<>(ResponseCode.SUCCESS.getCode(),"Confirm payment success",response.getData()));
        }
    }
    @PostMapping("/check-enroll")
    public ResponseEntity<ResponseCommon<CheckEnrollCourseResponse>> checkEnrollCourse(@ParameterObject CheckEnrollCourseRequest checkEnrollCourseRequest) {
        ResponseCommon<CheckEnrollCourseResponse> response = courseService.isEnrollCourse(checkEnrollCourseRequest);
        if (response.getCode() == ResponseCode.FAIL.getCode()) {
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Check enroll course failed", null));
        } else {
            return ResponseEntity.ok().body(response);
        }
    }

    @GetMapping("/total-revenue")
    public ResponseEntity<ResponseCommon<GetTotalRevenueResponse>> getTotalRevenue() {
        try {
            ResponseCommon<GetTotalRevenueResponse> getTotalRevenueResponseResponseCommon = paymentService.getTotalRevenue();
            return ResponseEntity.ok().body(new ResponseCommon<>(ResponseCode.SUCCESS.getCode(), "Total revenue retrieved successfully", getTotalRevenueResponseResponseCommon.getData()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ResponseCommon<>(ResponseCode.FAIL.getCode(), "Failed to retrieve total revenue", null));
        }
    }

}
