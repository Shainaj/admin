package com.cap.ts.adminservice.adminservice.controller;

import com.cap.ts.adminservice.adminservice.dto.LeaveResponseDto;
import com.cap.ts.adminservice.adminservice.dto.LoginRequestDto;
import com.cap.ts.adminservice.adminservice.dto.LoginResponseDto;
import com.cap.ts.adminservice.adminservice.entity.ApprovalInfo;
import com.cap.ts.adminservice.adminservice.entity.AuthorizationInfo;
import com.cap.ts.adminservice.adminservice.entity.LeaveInfo;
import com.cap.ts.adminservice.adminservice.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@Slf4j
@Tag(name = "Admin Api details")
public class AdminController {
    @Autowired
    AdminService adminService;

    @Operation(summary = "Gives the detail of the user based on the logged in UserId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully logged in  user details",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AuthorizationInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "No records found",
                    content = @Content) })
    @PostMapping("/login")
    public LoginResponseDto getEmployeeAfterLogin(@RequestBody LoginRequestDto loginServiceDto){

        return  adminService.getUserDataPostLogin(loginServiceDto);

    }

    @Operation(summary = "Gives the detail of the leave application by leaveId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully fetched  leave details",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = LeaveInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "No records found",
                    content = @Content) })
    @GetMapping("/leaveDetails")
    public LeaveResponseDto getLeaveDetails(@RequestParam Integer leaveId){

        return  adminService.getLeaveDetails(leaveId);

    }

    @Operation(summary = "Leave application to be approved for given leaveId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully approved  leave details",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApprovalInfo.class)) }),
            @ApiResponse(responseCode = "404", description = "No records found",
                    content = @Content) })
    @PostMapping("/approveLeave")
    public Map<String, Integer> getLeaveDetails(@RequestBody ApprovalInfo approvalInfo){

        return  adminService.updateLeaveStatus(approvalInfo);

    }


}
