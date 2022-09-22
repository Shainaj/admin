package com.cap.ts.adminservice.adminservice.exception;

public class AdminServiceException extends  Exception{

    public AdminServiceException(String msg){
        super(msg);

    }

    public AdminServiceException(String msg, Throwable cause){
        super(msg, cause);

    }
}
