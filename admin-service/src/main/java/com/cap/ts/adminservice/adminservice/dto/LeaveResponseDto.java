package com.cap.ts.adminservice.adminservice.dto;

import com.cap.ts.adminservice.adminservice.projection.LeaveDetailsProjection;
import com.cap.ts.adminservice.adminservice.projection.UserProjection;
import lombok.Data;

@Data
public class LeaveResponseDto {

    private LeaveDetailsProjection leaveDetailsProjection;
    private Integer responseCode;
    private String response;
}
