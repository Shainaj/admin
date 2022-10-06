package com.cap.ts.adminservice.adminservice.service;

import com.cap.ts.adminservice.adminservice.dto.*;
import com.cap.ts.adminservice.adminservice.entity.ApprovalInfo;
import com.cap.ts.adminservice.adminservice.entity.UserInfo;
import com.cap.ts.adminservice.adminservice.exception.AdminServiceException;
import com.cap.ts.adminservice.adminservice.projection.LeaveDetailsProjection;
import com.cap.ts.adminservice.adminservice.projection.UserProjection;
import com.cap.ts.adminservice.adminservice.repository.AuthorizationRepository;
import com.cap.ts.adminservice.adminservice.repository.LeaveInfoRepository;
import com.cap.ts.adminservice.adminservice.repository.UserInfoRepository;
import com.cap.ts.adminservice.adminservice.repository.dao.ApprovalInfoDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class AdminServiceImpl implements  AdminService{


    @Autowired
    AuthorizationRepository authorizationRepository;

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    LeaveInfoRepository leaveInfoRepository;

    @Autowired
    ApprovalInfoDao approvalInfoDao;

    public LoginResponseDto getUserDataPostLogin(LoginRequestDto loginRequestDto){
        LoginResponseDto loginResponseDto = new LoginResponseDto();

        try{
            loginResponseDto.setResponseCode(200);
            String message = "Successful";
            UserProjection userProjection = null;
            if(loginRequestDto!=null && loginRequestDto.getLoginId()!=null){
                final Optional<String> passwordByUserId = authorizationRepository.findPasswordByUserId(loginRequestDto.getLoginId());
                log.info("password by repo {}", passwordByUserId);
                if(passwordByUserId.isPresent()){
                    final String password = passwordByUserId.get();
                    if(password.equals(loginRequestDto.getPassword())){
                        log.info("Fetch logged in user details {} ", loginRequestDto.getLoginId());
                        userProjection = userInfoRepository.authenticateUserAndGetDetails(loginRequestDto.getLoginId(), loginRequestDto.getPassword());
                        log.info("User details {} ", userProjection);
                        loginResponseDto.setResponse(message);
                        loginResponseDto.setUserProjection(userProjection);
                    }else {
                        loginResponseDto.setUserProjection(null);
                        loginResponseDto.setResponseCode(400);
                        loginResponseDto.setResponse("Unauthorised User");

                    }
                }else{
                    throw new AdminServiceException("Invalid login credentials");
                }
            }else{
                loginResponseDto.setResponseCode(400);
                loginResponseDto.setResponse("Bad Request");
                loginResponseDto.setUserProjection(null);

            }

        }catch (Exception e){
            log.error("Exception while validating login {}", e.getMessage(), e);
            loginResponseDto.setResponseCode(500);
            String message = e.getMessage().contains("SQL")?"Server Down":"Unknown Error";
            loginResponseDto.setResponse(message);
        }

        return loginResponseDto;

    }


    @Override
    public UserResponseDto getUserData(String userId){
        UserResponseDto userResponseDto = new UserResponseDto();

        try{
            userResponseDto.setResponseCode(200);
            String message = "Successful";
            Optional<UserInfo> userProjection;
                if(userId!=null && !userId.isBlank()){
                    log.info("Fetch  user details {} ", userId);
                    userProjection = userInfoRepository.findById(userId);
                    log.info("User details {} ", userProjection.isPresent());
                    userResponseDto.setResponse(message);
                    userResponseDto.setUserProjection(userProjection);
                    }else {
                    userResponseDto.setResponseCode(400);
                    userResponseDto.setResponse("Bad Request");
                    userResponseDto.setUserProjection(null);

                    }

        }catch (Exception e){
            log.error("Exception while validating login {}", e.getMessage(), e);
            userResponseDto.setResponseCode(500);
            String message = e.getMessage().contains("SQL")?"Server Down":"Unknown Error";
            userResponseDto.setResponse(message);
        }

        return userResponseDto;

    }



    @Override
    public ApprovalResponseDto updateLeaveStatus(ApprovalInfo approvalInfo) {
       ApprovalResponseDto approvalResponseDto = new ApprovalResponseDto();
        try {
            if(approvalInfo !=null){
                final int count = approvalInfoDao.updateLeaveStatus(approvalInfo);
                approvalResponseDto.setResponse("Successful");
                approvalResponseDto.setResponseCode(200);
                approvalResponseDto.setCount(count);
                approvalResponseDto.setApprovedDetails("No of leaves or timecard approved");
                approvalResponseDto.setId(approvalInfo.getIdTobeApproved());
            }

        }catch (Exception e){
            log.error("Error occurred while updating leave status {}", e.getMessage(),e);
            approvalResponseDto.setResponse(e.getMessage()+"Unknown error ");
            approvalResponseDto.setId(approvalInfo.getIdTobeApproved());
            approvalResponseDto.setResponseCode(400);
        }
        return  approvalResponseDto;
    }
}
