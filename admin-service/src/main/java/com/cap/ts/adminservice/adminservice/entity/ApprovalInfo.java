package com.cap.ts.adminservice.adminservice.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ApprovalInfo")
public class ApprovalInfo implements Serializable {

    @Id
    @Column(name = "ApprovalId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int approvalId;

    @Column(name = "UserId", nullable = false)
    private String userId;

    @Column(name = "IdTobeApproved", nullable = false )
    private Integer idTobeApproved;

    @Column(name = "ApprovalStatus", nullable = false)
    private String approvalStatus;

    @Column(name = "Comments", nullable = false)
    private String comments;

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


    public Integer getIdTobeApproved() {
        return idTobeApproved;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public String getComments() {
        return comments;
    }

    public Date getApprovedTimeStamp() {
        return approvedTimeStamp;
    }
}
