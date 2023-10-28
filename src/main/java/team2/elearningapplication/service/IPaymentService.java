package team2.elearningapplication.service;

import team2.elearningapplication.dto.common.PaymentRes;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.response.admin.GetTotalRevenueResponse;

import java.io.UnsupportedEncodingException;

public interface IPaymentService {
    ResponseCommon<PaymentRes> addPayment(double amount)throws UnsupportedEncodingException;

    ResponseCommon<GetTotalRevenueResponse> getTotalRevenue();
}
