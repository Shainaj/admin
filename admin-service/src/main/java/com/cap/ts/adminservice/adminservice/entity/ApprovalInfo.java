package com.cap.ts.adminservice.adminservice.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ApprovalInfo")
public class ApprovalInfo  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ApprovalId", nullable = false)
    private int approvalId;

    @Column(name = "UserId", nullable = false)
    private String userId;

    @Column(name = "LeaveId", nullable = false )
    private Integer leaveId;

    @Column(name = "ApprovalStatus", nullable = false)
    private String approvalStatus;

    @Column(name = "ApprovedTimeStamp", nullable = false)
    private Date approvedTimeStamp;

    ApprovalInfo(){

    }

    public int getApprovalId() {
        return approvalId;
    }

    public String getUserId() {
        return userId;
    }

    public Integer getLeaveId() {
        return leaveId;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public Date getApprovedTimeStamp() {
        return approvedTimeStamp;
    }
}
