package team2.elearningapplication.service;

import team2.elearningapplication.dto.common.PaymentRes;
import team2.elearningapplication.dto.common.ResponseCommon;

import java.io.UnsupportedEncodingException;

public interface IPaymentService {
    ResponseCommon<PaymentRes> addPayment(double amount)throws UnsupportedEncodingException;
    ResponseCommon<?> getPaymentInformation(String amount, String bankCode, String order, String responseCode)throws UnsupportedEncodingException;
}
