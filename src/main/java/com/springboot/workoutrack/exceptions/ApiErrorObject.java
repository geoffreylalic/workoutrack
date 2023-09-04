package com.springboot.workoutrack.exceptions;

import java.util.Date;

public class ApiErrorObject {
    private Integer statusCode;
    private String message;
    private Date timeStamp;

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public ApiErrorObject() {
    }

    public ApiErrorObject(Integer statusCode, String message, Date timeStamp) {
        this.statusCode = statusCode;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
