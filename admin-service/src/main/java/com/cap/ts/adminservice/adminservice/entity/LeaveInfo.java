package com.cap.ts.adminservice.adminservice.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="LeaveInfo")
public class LeaveInfo implements Serializable {

    @Id
    @Column(name = "LeaveId", nullable = false )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer leaveId;

    @Column(name = "UserId", nullable = false)
    private String userId;

    @Column(name = "LeaveType", nullable = false)
    private String leaveType;

    @Column(name = "NoOfDays", nullable = false)
    private String noOfDays;

    @Column(name = "LeaveFrom",nullable = false)
    private Date leaveFrom;

    @Column(name = "LeaveTo",nullable = false)
    private Date leaveTo;

    @Column(name = "LeaveReason", nullable = false)
    private String leaveReason;

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

    public Date getLeaveFrom() {
        return leaveFrom;
    }

    public Date getLeaveTo() {
        return leaveTo;
    }

    public String getLeaveReason() {
        return leaveReason;
    }
}
