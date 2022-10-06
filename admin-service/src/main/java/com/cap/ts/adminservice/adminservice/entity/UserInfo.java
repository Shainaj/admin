package com.cap.ts.adminservice.adminservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="UserInfo")
public class UserInfo implements Serializable {

    @Id
    @Column(name = "UserId", nullable = false)
    private String userId;

    @Column(name = "UserName", nullable = false)
    private String userName;

    @Column(name = "UserEmailId")
    private String userEmailId;

    @Column(name = "Role")
    private String role;

    @Column(name = "Supervisor")
    private String supervisor;

    UserInfo(){

    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public String getRole() {
        return role;
    }

    public String getSupervisor() {
        return supervisor;
    }
}
