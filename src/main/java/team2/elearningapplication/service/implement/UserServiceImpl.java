package team2.elearningapplication.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team2.elearningapplication.Enum.EnumUserStatus;
import team2.elearningapplication.Enum.ResponseCode;
import team2.elearningapplication.dto.common.ResponseCommon;
import team2.elearningapplication.dto.request.CreateUserRequest;
import team2.elearningapplication.dto.request.GetOTPRequest;
import team2.elearningapplication.dto.response.CreateUserResponseDTO;
import team2.elearningapplication.dto.response.GetOTPResponse;
import team2.elearningapplication.entity.User;
import team2.elearningapplication.exceptions.BussinessException;
import team2.elearningapplication.repository.IUserRepository;
import team2.elearningapplication.service.IUserService;
import team2.elearningapplication.utils.CommonUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;
    private final EmailService emailService;

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
//            emailService.sendEmail();

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
            
            // step3: check expired time otp
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
}
