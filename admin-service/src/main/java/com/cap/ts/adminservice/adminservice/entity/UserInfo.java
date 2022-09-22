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
    @Column(name = "UserId")
    private String userId;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "UserEmailId")
    private String userEmailId;

    @Column(name = "Role")
    private String role;

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
}
