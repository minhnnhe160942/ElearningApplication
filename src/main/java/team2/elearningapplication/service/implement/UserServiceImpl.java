package team2.elearningapplication.service.implement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import team2.elearningapplication.Enum.EnumUserStatus;
import team2.elearningapplication.Enum.ResponseCode;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.*;
import team2.elearningapplication.dto.response.*;
import team2.elearningapplication.entity.Mail;
import team2.elearningapplication.entity.User;
import team2.elearningapplication.exceptions.BussinessException;
import team2.elearningapplication.exceptions.UserNotFoundException;
import team2.elearningapplication.repository.IUserRepository;
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
    public ResponseCommon<CreateUserResponseDTO> createUser(CreateUserRequest requestDTO) {
        try {
            User user = userRepository.findByUsername(requestDTO.getUsername()).orElse(null);
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
            user.setUsername(requestDTO.getUsername());
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
            User user = userRepository.findByUsernameAndStatus(request.getUsername(), EnumUserStatus.ACTIVE).orElse(null);
            // if  user is null ->throw error
            if (Objects.isNull(user)) {
                throw new BussinessException(ResponseCode.USER_NOT_FOUND);
            }
            // step1: gen otp
            String otp = CommonUtils.getOTP();
            //step2: send email
            log.info("START... Sending email");
            emailService.sendEmail(setUpMail(user.getEmail(),otp));
            log.info("END... Email sent success");
            user.setUsername(request.getUsername());
            user.setPassword(request.getPassword());
            user.setEmail(request.getEmail());
            user.setPhone(request.getPhone());
            user.setRole(request.getRole());
            user.setFullName(request.getFullName());
            user.setGender(request.getGender());
            user.setDate_of_birth(request.getDateOfBirth());
            user.setStatus(EnumUserStatus.IN_PROCESS);
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
            Optional<User> user = userRepository.findByUsername(loginRequest.getUsername());
            // if username request not found in database -> tell user
            if(user.isEmpty()){
                throw new UserNotFoundException("User not found");
            } // else -> check password
            else {
                // if password not equals password in database -> return fail
                if(!user.orElse(null).getPassword().equals(loginRequest.getPassword())){
                    return new ResponseCommon<>(ResponseCode.PASSWORD_INCORRECT, null);
                } // else -> verify otp
                else {
                    String otp = user.orElse(null).getOtp();
                    VerifyOtpRequest request = new VerifyOtpRequest(otp,user.orElse(null).getId());
                    ResponseCommon<VerifyOtpResponse> response = new ResponseCommon<>(new VerifyOtpResponse());

                    // if code is false -> return error
                    if(response.getCode() != 0){
                        return new ResponseCommon<>(new JWTResponse(null,null,ResponseCode.FAIL.getMessage()));
                    }
                    // esle -> return access token and refresh token
                    else {
                        JWTUtils utils = new JWTUtils();
//                        Role role = userRepository.findRolesByUsername(loginRequest.getUsername());
//                        List<GrantedAuthority> authorities = new ArrayList<>();
//                        authorities.add(role);
                        UserDetailsImpl userDetails = UserDetailsImpl.build(user.get());
                        String accessToken = utils.generateAccessToken(userDetails);
                        String refreshToken = utils.generateRefreshToken(userDetails);
                        return new ResponseCommon<>(new JWTResponse(accessToken,refreshToken,ResponseCode.SUCCESS.getMessage()));
                    }
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
            Optional<User> user = userRepository.findById(verifyOtpRequest.getUserId());

            LocalDateTime localDateTime = LocalDateTime.now();
            // if otp request equals otp generate and localDate before expired otp -> return success
            if(verifyOtpRequest.getOtp().equals(user.orElse(null).getOtp())
                    && localDateTime.isBefore(user.get().getExpiredOTP())){
                return new ResponseCommon<>(ResponseCode.SUCCESS,null);
            }
            // else -> return fail
            else {
                log.debug("verify otp fail");
                return new ResponseCommon<>(ResponseCode.Expired_OTP,null);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }

    @Override
    public ResponseCommon<ForgotPasswordResponse> forgotPassword(ForgotPasswordRequest forgotPasswordRequest) {
        try {
            User user = userRepository.findByUsername(forgotPasswordRequest.getUsername()).orElse(null);
            // if email of request not exist -> tell user
            if(Objects.isNull(user)){
                return new ResponseCommon<>(new ForgotPasswordResponse("Email not exist"));
            } // else -> get otp
            else {
                GetOTPRequest requestOTP = new GetOTPRequest(user.getUsername(),user.getPassword(),user.getEmail(),
                        user.getPhone(),user.getRole(),
                        user.getFullName(),user.getGender(),
                        user.getDate_of_birth());
                getOtp(requestOTP);
                VerifyOtpRequest verifyOtpRequest = new VerifyOtpRequest(user.getOtp(),user.getId());
                // if verify fail  -> get new otp
                if(verifyOtp(verifyOtpRequest).getCode()!=0){
                    return new ResponseCommon<>(new ForgotPasswordResponse("OTP incorrect"));
                } // else -> update new password
                else {
                    // if password and repassword request equals -> update new password
                    if(forgotPasswordRequest.getPassword().equals(forgotPasswordRequest.getRePassword())){
                        user.setPassword(forgotPasswordRequest.getPassword());
                        return new ResponseCommon<>(new ForgotPasswordResponse("Success"));
                    } // else -> tell user
                    else {
                        return new ResponseCommon<>(new ForgotPasswordResponse("Password and re_pass is difference"));
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ResponseCommon<ChangePasswordResponse> changePassword(ChangePasswordRequest changePasswordRequest) {
        try {
            User user = userRepository.findByUsername(changePasswordRequest.getUsername()).orElse(null);
            // if old password not true -> return error
            if(!changePasswordRequest.getPassword().equals(user.getPassword())){
                return new ResponseCommon<>(new ChangePasswordResponse("Old password is not true"));
            } else {
                // if password and repass  difference -> tell user
                if(!changePasswordRequest.getPassword().equals(changePasswordRequest.getRePassword())){
                    return new ResponseCommon<>(new ChangePasswordResponse("Password and re_pass is difference"));
                } else {
                    // if old pass and new pass not difference -> tell user
                    if(user.getPassword().equals(changePasswordRequest.getPassword())){
                        return new ResponseCommon<>(new ChangePasswordResponse(" Old Password and new Password not difference"));
                    } else {
                        // update new password
                        user.setPassword(changePasswordRequest.getPassword());
                        return new ResponseCommon<>(new ChangePasswordResponse("Change Password Success"));
                    }
                }
            }

        } catch (Exception e){
            e.printStackTrace();
            return new ResponseCommon<>(new ChangePasswordResponse("Error"));
        }
    }
}