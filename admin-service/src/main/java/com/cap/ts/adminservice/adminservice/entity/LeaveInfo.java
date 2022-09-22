package com.cap.ts.adminservice.adminservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="LeaveInfo")
public class LeaveInfo implements Serializable {

    @Id
    @Column(name = "LeaveId", nullable = false )
    private Integer leaveId;

    @Column(name = "UserId", nullable = false)
    private String userId;

    @Column(name = "LeaveType", nullable = false)
    private String leaveType;

    @Column(name = "NoOfDays", nullable = false)
    private String noOfDays;

    @Column(name = "LeaveOnDate",nullable = false)
    private Date leaveOnDate;

    @Column(name = "leaveAppliedTimeStamp", nullable = false)
    private Date leaveAppliedTimeStamp;

   LeaveInfo(){

   }

    public Integer getLeaveId() {
        return leaveId;
    }

    public String getUserId() {
        return userId;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public String getNoOfDays() {
        return noOfDays;
    }

    public Date getLeaveOnDate() {
        return leaveOnDate;
    }

    public Date getLeaveAppliedTimeStamp() {
        return leaveAppliedTimeStamp;
    }
}
