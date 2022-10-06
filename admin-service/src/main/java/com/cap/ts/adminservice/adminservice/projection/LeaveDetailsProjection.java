package com.cap.ts.adminservice.adminservice.projection;

import java.util.Date;

public interface LeaveDetailsProjection {

    public Integer getLeaveId();

    public String getUserId();

    public String getLeaveType();

    public String getNoOfDays();

    public Date getLeaveFrom();

    public Date getLeaveTo();

    public String getLeaveReason();

    public  String getUserName();


}
