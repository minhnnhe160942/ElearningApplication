package team2.elearningapplication.service.implement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import team2.elearningapplication.Enum.EnumUserStatus;
import team2.elearningapplication.Enum.ResponseCode;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.CreateUserRequest;
import team2.elearningapplication.dto.request.GetOTPRequest;
import team2.elearningapplication.dto.request.LoginRequest;
import team2.elearningapplication.dto.request.VerifyOtpRequest;
import team2.elearningapplication.dto.response.CreateUserResponseDTO;
import team2.elearningapplication.dto.response.GetOTPResponse;
import team2.elearningapplication.dto.response.VerifyOtpResponse;
import team2.elearningapplication.entity.Mail;
import team2.elearningapplication.entity.User;
import team2.elearningapplication.exceptions.BussinessException;
import team2.elearningapplication.repository.IUserRepository;
import team2.elearningapplication.security.Role;
import team2.elearningapplication.security.UserDetailsImpl;
import team2.elearningapplication.security.jwt.JWTResponse;
import team2.elearningapplication.security.jwt.JWTUtils;
import team2.elearningapplication.service.IUserService;
import team2.elearningapplication.utils.CommonUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

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
            User user = new User();
            user.setUsername(requestDTO.getUsername());
            user.setPassword(requestDTO.getPassword());
            user.setEmail(requestDTO.getEmail());
            user.setPhone(requestDTO.getPhone());
            user.setRole(requestDTO.getRole());
            user.setFullName(requestDTO.getFullName());
            user.setGender(requestDTO.getGender());
            user.setDate_of_birth(requestDTO.getDateOfBirth());

            User createdUser = userRepository.save(user);
            log.info("START... Sending email");
            emailService.sendEmail(setUpMail(user.getEmail()));
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

    private Mail setUpMail(String mailTo) {
        Mail mail = new Mail();
        mail.setFrom(mailFrom);
        mail.setTo(mailTo);
        mail.setSubject("Email with Spring boot and thymeleaf template!");
        Map<String, Object> model = new HashMap<>();
        model.put("otp_value", CommonUtils.getOTP());
        mail.setPros(model);
        mail.setTemplate("index");
        return mail;
    }

    @Override
    public User updateUser(User user) {
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
            emailService.sendEmail(setUpMail(user.getEmail()));
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
            user.setExpiredOTP(LocalDateTime.now());
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
                return new ResponseCommon<>(ResponseCode.USER_NOT_FOUND,null);
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

                    }
                    // esle -> return access token and refresh token
                    else {
                        JWTUtils utils = new JWTUtils();
                        List<String> roles = userRepository.findRolesByUsername(loginRequest.getUsername());
                        List<GrantedAuthority> authorities = new ArrayList<>();
                        for (String role : roles) {
                            authorities.add(new SimpleGrantedAuthority(role));
                        }
                        UserDetailsImpl userDetails = new UserDetailsImpl(user.get().getId(),user.get().getUsername(),user.get().getPassword(),authorities);
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
        return null;
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
                return new ResponseCommon<>(ResponseCode.FAIL,null);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseCommon<>(ResponseCode.FAIL, null);
        }
    }


}
