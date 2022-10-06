package com.cap.ts.adminservice.adminservice.service;

import com.cap.ts.adminservice.adminservice.dto.*;
import com.cap.ts.adminservice.adminservice.entity.ApprovalInfo;

import java.util.Map;

public interface AdminService {

     LoginResponseDto getUserDataPostLogin(LoginRequestDto loginRequestDto);



     UserResponseDto getUserData(String userId);

     ApprovalResponseDto updateLeaveStatus(ApprovalInfo approvalInfo);
}
