package com.cap.ts.adminservice.adminservice.service;

import com.cap.ts.adminservice.adminservice.dto.LeaveResponseDto;
import com.cap.ts.adminservice.adminservice.dto.LoginRequestDto;
import com.cap.ts.adminservice.adminservice.dto.LoginResponseDto;
import com.cap.ts.adminservice.adminservice.entity.ApprovalInfo;
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
    public LeaveResponseDto getLeaveDetails(Integer leaveId) {
        LeaveResponseDto leaveResponseDto = new LeaveResponseDto();
        try{
            if(leaveId!=null){
                final LeaveDetailsProjection leaveDetailsProjection = leaveInfoRepository.fetchLeaveDetailsByLeaveId(leaveId);
                log.info("Leave details {} ", leaveDetailsProjection.getUserId());
                leaveResponseDto.setResponse("Successful");
                leaveResponseDto.setResponseCode(200);
                leaveResponseDto.setLeaveDetailsProjection(leaveDetailsProjection);
            }else{

                leaveResponseDto.setResponseCode(400);
                leaveResponseDto.setResponse("Bad Request");
                leaveResponseDto.setLeaveDetailsProjection(null);

            }
        }catch (Exception e){
            log.error("Exception while fetching leave details {}", e.getMessage(), e);
            leaveResponseDto.setResponseCode(500);
            String message = e.getMessage().contains("SQL")?"Server Down":"Unknown Error";
            leaveResponseDto.setResponse(message);
        }
        return leaveResponseDto;
    }

    @Override
    public Map<String, Integer> updateLeaveStatus(ApprovalInfo approvalInfo) {
        Map<String, Integer> map = new HashMap<>();
        try {
            if(approvalInfo!=null){
                final int count = approvalInfoDao.updateLeaveStatus(approvalInfo);
                map.put("No of leaves approved", count);
                map.put("Leave Id approved", approvalInfo.getLeaveId());
            }

        }catch (Exception e){
            log.error("Error occurred while updating leave status {}", e.getMessage(),e);
            map.put(e.getMessage()+"Unknown error ", 0);
        }
        return  map;
    }
}
