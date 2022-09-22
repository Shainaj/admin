package com.cap.ts.adminservice.adminservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="AuthorizationInfo")
public class AuthorizationInfo implements Serializable {

    @Id
    @Column(name = "UserId")
    private String userId;

    @Column(name = "password")
    private String password;

    @Column(name = "lastLoginTimeStamp")
    private Date lastLoginTimeStamp;

    AuthorizationInfo(){

    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public Date getLastLoginTimeStamp() {
        return lastLoginTimeStamp;
    }
}
