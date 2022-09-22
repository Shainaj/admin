package com.cap.ts.adminservice.adminservice.service;

import com.cap.ts.adminservice.adminservice.dto.LeaveResponseDto;
import com.cap.ts.adminservice.adminservice.dto.LoginRequestDto;
import com.cap.ts.adminservice.adminservice.dto.LoginResponseDto;
import com.cap.ts.adminservice.adminservice.entity.ApprovalInfo;

import java.util.Map;

public interface AdminService {

     LoginResponseDto getUserDataPostLogin(LoginRequestDto loginRequestDto);

     LeaveResponseDto getLeaveDetails(Integer leaveId);

     Map<String, Integer> updateLeaveStatus(ApprovalInfo approvalInfo);
}
