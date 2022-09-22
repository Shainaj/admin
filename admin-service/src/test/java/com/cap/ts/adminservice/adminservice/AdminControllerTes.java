package com.cap.ts.adminservice.adminservice;


import com.cap.ts.adminservice.adminservice.controller.AdminController;
import com.cap.ts.adminservice.adminservice.dto.LeaveResponseDto;
import com.cap.ts.adminservice.adminservice.dto.LoginRequestDto;
import com.cap.ts.adminservice.adminservice.dto.LoginResponseDto;
import com.cap.ts.adminservice.adminservice.projection.LeaveDetailsProjection;
import com.cap.ts.adminservice.adminservice.projection.UserProjection;
import com.cap.ts.adminservice.adminservice.service.AdminService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({AdminController.class})
class AdminControllerTest {

    @Autowired
    protected MockMvc mvc;

    @MockBean
    private AdminService adminService;

    ProjectionFactory factory = new SpelAwareProxyProjectionFactory();
    Map<String, Object> map = Map.of("userId", "sanadaf", "userName", "Saleem Nadaf",
            "userEmailId","saleem.nadaf@capgemini.com",
            "userRole", "admin"  );

    Map<String, Object> leaveMap = Map.of("userName", "Abhilasha", "userId", "abhilasha", "leaveOnDate", "2022-09-20",
            "leaveType", "Privilege Leave", "noOfDays", "Full Day","leaveId", 1122);


    UserProjection projection = factory.createProjection(UserProjection.class, map);
    LeaveDetailsProjection leaveDetailsProjection = factory.createProjection(LeaveDetailsProjection.class, leaveMap);

    @Test
    void testGetEmployeeAfterLogin() throws Exception {
        String uri= "http://localhost:8081/admin/login";
        LoginResponseDto loginResponseDto= new LoginResponseDto();
        loginResponseDto.setResponse("Successful");
        loginResponseDto.setResponseCode(200);
        loginResponseDto.setUserProjection(projection);
        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setLoginId("sanadaf");
        loginRequestDto.setPassword("Saleem@123");
        when(adminService.getUserDataPostLogin(loginRequestDto)).thenReturn(loginResponseDto);

        mvc.perform(MockMvcRequestBuilders.post(uri)
                        .content(new ObjectMapper().writeValueAsString((loginRequestDto)))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testGetLeaveDetails() throws Exception {
        String uri= "/admin/leaveDetails?leaveId=1122";
        LeaveResponseDto leaveResponseDto= new LeaveResponseDto();
        leaveResponseDto.setResponse("Successful");
        leaveResponseDto.setResponseCode(200);
        leaveResponseDto.setLeaveDetailsProjection(leaveDetailsProjection);

        when(adminService.getLeaveDetails(1122)).thenReturn(leaveResponseDto);

        mvc.perform(MockMvcRequestBuilders.get(uri))
                .andExpect(status().is5xxServerError());
    }
}
