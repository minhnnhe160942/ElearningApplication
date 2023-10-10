package team2.elearningapplication.service.implement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import team2.elearningapplication.Enum.EnumUserStatus;
import team2.elearningapplication.Enum.ResponseCode;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.user.*;
import team2.elearningapplication.dto.response.user.ChangePasswordResponse;
import team2.elearningapplication.dto.response.user.CreateUserResponseDTO;
import team2.elearningapplication.dto.response.user.GetOTPResponse;
import team2.elearningapplication.dto.response.user.VerifyOtpResponse;
import team2.elearningapplication.entity.Mail;
import team2.elearningapplication.entity.User;
import team2.elearningapplication.repository.IUserRepository;
import team2.elearningapplication.security.SecurityUtils;
import team2.elearningapplication.security.UserDetailsImpl;
import team2.elearningapplication.security.jwt.JWTResponse;
import team2.elearningapplication.security.jwt.JWTUtils;
import team2.elearningapplication.service.IUserService;
import team2.elearningapplication.utils.CommonUtils;
import java.time.LocalDateTime;
import java.util.*;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;
    private final EmailService emailService;

    @Value("minhnnde258@gmail.com")
    private String mailFrom;
    @Value("${otp.valid.minutes}")
    private int otpValid;

    @Override
    public String genUserFromEmail(String email) {
        return email.substring(0, email.indexOf("@"));
    }

    @Override
    public ResponseCommon<CreateUserResponseDTO> createUser(CreateUserRequest requestDTO) {
        try {
            User user = userRepository.findByUsername(genUserFromEmail(requestDTO.getEmail())).orElse(null);
            // if username exist and status equals inprocess -> get new otp
//            log.debug("check user get by username and status{}",requestDTO.getUsername(),user.getStatus());
            if(Objects.nonNull(user) && user.getStatus() != EnumUserStatus.IN_PROCESS){
                return new ResponseCommon<>(ResponseCode.USER_EXIST,null);
            }
            // if user is null -> new user
            log.debug("check user is null{}",user);
            if(Objects.isNull(user)){
                user = new User();
            }
            user.setUsername(genUserFromEmail(requestDTO.getEmail()));
            user.setPassword(requestDTO.getPassword());
            user.setEmail(requestDTO.getEmail());
            user.setPhone(requestDTO.getPhone());
            user.setRole(requestDTO.getRole());
            user.setFullName(requestDTO.getFullName());
            user.setGender(requestDTO.getGender());
            user.setDate_of_birth(requestDTO.getDateOfBirth());
            LocalDateTime localDateTime = LocalDateTime.now();
            LocalDateTime expired = localDateTime.plusMinutes(Long.valueOf(otpValid));
            user.setStatus(EnumUserStatus.IN_PROCESS);
            log.debug("Value of expired{}",expired);
            user.setExpiredOTP(expired);
            user.setCreatedAt(LocalDateTime.now());
            user.setOtp(CommonUtils.getOTP());
            User createdUser = userRepository.save(user);
            log.info("START... Sending email");
            emailService.sendEmail(setUpMail(user.getEmail(),user.getOtp()));
            log.info("END... Email sent success");
            CreateUserResponseDTO responseDTO = new CreateUserResponseDTO();
            responseDTO.setId(createdUser.getId());
            responseDTO.setUsername(createdUser.getUsername());
            responseDTO.setEmail(createdUser.getEmail());
            responseDTO.setCreatedAt(createdUser.getCreatedAt());

            return new ResponseCommon<>(ResponseCode.SUCCESS, responseDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }

    private Mail setUpMail(String mailTo, String otp) {
        Mail mail = new Mail();
        mail.setFrom(mailFrom);
        mail.setTo(mailTo);
        mail.setSubject("OTP ELEARNING APPLICATION!");
        Map<String, Object> model = new HashMap<>();
        model.put("otp_value", otp);
        mail.setPros(model);
        mail.setTemplate("index");
        return mail;
    }

    @Override
    public User updateUser(User user) {
        try {
            Optional<User> existingUser = userRepository.findById(user.getId());
            if (existingUser.isPresent()) {
                User updatedUser = existingUser.get();
                updatedUser.setUsername(user.getUsername());
                updatedUser.setPassword(user.getPassword());
                updatedUser.setEmail(user.getEmail());
                updatedUser.setPhone(user.getPhone());
                updatedUser.setRole(user.getRole());
                updatedUser.setCreatedAt(user.getCreatedAt());
                updatedUser.setFullName(user.getFullName());
                updatedUser.setGender(user.getGender());
                updatedUser.setDate_of_birth(user.getDate_of_birth());
                return userRepository.save(updatedUser);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public User getUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public ResponseCommon<GetOTPResponse> getOtp(GetOTPRequest request) {
        try {
            User user = userRepository.findByUsernameAndStatus(genUserFromEmail(request.getEmail()), EnumUserStatus.ACTIVE).orElse(null);
            // if  user is null ->throw error
            if (Objects.isNull(user)) {
                return new ResponseCommon<>(ResponseCode.USER_NOT_FOUND,null);
            }
            // step1: gen otp
            String otp = CommonUtils.getOTP();
            //step2: send email
            log.info("START... Sending email");
            emailService.sendEmail(setUpMail(user.getEmail(),otp));
            log.info("END... Email sent success");
            user.setUsername(genUserFromEmail(request.getEmail()));
            if (request.isCreate()) {
                user.setStatus(EnumUserStatus.IN_PROCESS);
            }
            LocalDateTime localDateTime = LocalDateTime.now();
            LocalDateTime expired = localDateTime.plusMinutes(Long.valueOf(otpValid));
            log.debug("Value of expired{}",expired);
            user.setExpiredOTP(expired);
            user.setOtp(otp);
            User createdUser = userRepository.save(user);
            GetOTPResponse response = new GetOTPResponse(user.getUsername(), user.getEmail());
            return new ResponseCommon<>(ResponseCode.SUCCESS, response);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }


    @Override
    public ResponseCommon<JWTResponse> login(LoginRequest loginRequest) {
        try {
            Optional<User> user = userRepository.findByUsername(genUserFromEmail(loginRequest.getUsername()));
            // if username request not found in database -> tell user
            if(user.isEmpty()){
                return new ResponseCommon<>(ResponseCode.USER_NOT_FOUND,null);
            } // else -> check password
            else {
                // if password not equals password in database -> return fail
                if (!user.orElse(null).getPassword().equals(loginRequest.getPassword())) {
                    return new ResponseCommon<>(ResponseCode.PASSWORD_INCORRECT, null);
                } // else -> verify otp
                else {

                    JWTUtils utils = new JWTUtils();
                    UserDetailsImpl userDetails = UserDetailsImpl.build(user.get());
                    String accessToken = utils.generateAccessToken(userDetails);
                    String refreshToken = utils.generateRefreshToken(userDetails);
                    return new ResponseCommon<>(new JWTResponse(accessToken, refreshToken, ResponseCode.SUCCESS.getMessage()));
//
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }



    @Override
    public ResponseCommon<VerifyOtpResponse> verifyOtp(VerifyOtpRequest verifyOtpRequest) {
        try {
            User user = userRepository.findByUsername(genUserFromEmail(verifyOtpRequest.getEmail())).orElse(null);
            if(Objects.isNull(user)) return new ResponseCommon<>(ResponseCode.USER_NOT_FOUND,null);
            LocalDateTime localDateTime = LocalDateTime.now();
            // if otp request equals otp generate and localDate before expired otp -> return success
            if(verifyOtpRequest.getOtp().equals(user.getOtp())
                    && localDateTime.isBefore(user.getExpiredOTP())){
                return new ResponseCommon<>(ResponseCode.SUCCESS,null);
            }
            // else -> return fail
            else {
//                log.debug("verify otp fail");
                return new ResponseCommon<>(ResponseCode.Expired_OTP,null);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }


    @Override
    public ResponseCommon<ChangePasswordResponse> changePassword(ChangePasswordRequest changePasswordRequest) {
        try {
            String username = SecurityUtils.getUsernameAuth();
            User user = userRepository.findByUsername(username).orElse(null);
            // if user is null -> tell error
            log.debug("change passsword with username{}",username);
            if(Objects.isNull(user)){
                return new ResponseCommon<>(ResponseCode.USER_NOT_FOUND,null);
            } else {
                // if oldPassword not correct -> tell user
                if(!changePasswordRequest.getOldPassword().equals(user.getPassword())){
                    return new ResponseCommon<>(ResponseCode.PASSWORD_INCORRECT,null);
                } else {
                    user.setPassword(changePasswordRequest.getNewPassword());
                    userRepository.save(user);
                    return new ResponseCommon<>(ResponseCode.SUCCESS,null);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseCommon<>(new ChangePasswordResponse("Error"));
        }
    }
}
