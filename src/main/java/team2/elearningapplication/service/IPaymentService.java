package team2.elearningapplication.service;

import team2.elearningapplication.dto.common.PaymentRes;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.admin.payment.GetPaymentByCourseRequest;
import team2.elearningapplication.dto.request.admin.payment.GetPaymentStaticRequest;
import team2.elearningapplication.dto.request.user.payment.GetPaymentByUserRequest;
import team2.elearningapplication.dto.response.admin.payment.GetPaymentByCourseResponse;
import team2.elearningapplication.dto.response.admin.payment.GetPaymentStaticResponse;
import team2.elearningapplication.dto.response.admin.payment.GetTotalRevenueResponse;
import team2.elearningapplication.dto.response.user.payment.ResponsePayment;

import java.io.UnsupportedEncodingException;

public interface IPaymentService {
    ResponseCommon<PaymentRes> addPayment(double amount)throws UnsupportedEncodingException;

    ResponseCommon<GetTotalRevenueResponse> getTotalRevenue();

    ResponseCommon<ResponsePayment> getPaymentByUser(GetPaymentByUserRequest getPaymentByUserRequest);

    ResponseCommon<ResponsePayment> getAllPayment();

    ResponseCommon<GetPaymentStaticResponse> getPaymentStatic(GetPaymentStaticRequest getPaymentStaticRequest);

    ResponseCommon<GetPaymentByCourseResponse> getPaymentByCourse(GetPaymentByCourseRequest getPaymentByCourseRequest);
}
