package com.cap.ts.adminservice.adminservice.dto;

import com.cap.ts.adminservice.adminservice.projection.UserProjection;
import lombok.Data;

@Data
public class LoginResponseDto {

    private UserProjection userProjection;
    private Integer responseCode;
    private String response;
}
