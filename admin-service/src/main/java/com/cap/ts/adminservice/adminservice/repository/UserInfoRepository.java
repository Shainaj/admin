package com.cap.ts.adminservice.adminservice.repository;

import com.cap.ts.adminservice.adminservice.entity.UserInfo;
import com.cap.ts.adminservice.adminservice.projection.UserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

    @Query(value = "SELECT ui.userId as userId, ui.userName as userName, ui.userEmailId as userEmailId, " +
            "ui.role as userRole, ui.supervisor as supervisor" +
            " FROM UserInfo ui join AuthorizationInfo ai on ui.userId = ai.userId" +
            " WHERE ui.userId = :userId and ai.password = :pwd", nativeQuery = true)
    UserProjection authenticateUserAndGetDetails(String userId, String pwd);

}

