package com.cap.ts.adminservice.adminservice.repository;

import com.cap.ts.adminservice.adminservice.entity.LeaveInfo;
import com.cap.ts.adminservice.adminservice.projection.LeaveDetailsProjection;
import com.cap.ts.adminservice.adminservice.projection.UserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveInfoRepository extends JpaRepository<LeaveInfo, Integer> {

    @Query(value = "SELECT li.leaveId as leaveId, li.userId as userId, li.leaveType as leaveType, " +
            "li.noOfDays as noOfDays, li.leaveOnDate as leaveOnDate, li.leaveAppliedTimeStamp as leaveAppliedTimeStamp, " +
            "ui.userName as userName FROM LeaveInfo li join UserInfo ui on ui.userId = li.userId" +
            " WHERE li.leaveId = :leaveId", nativeQuery = true)
    LeaveDetailsProjection fetchLeaveDetailsByLeaveId(Integer leaveId);
}
