package com.edwardchome.demo.exception;


import java.util.Date;

public class ExceptionResponse {

    private Date timestamp;
    private String message;
    private String details;
    private String httpCodeMessage;

    public ExceptionResponse(Date timestamp, String msg, String detail,String httpCodeMessage) {
        super();
        this.timestamp = timestamp;
        this.message = msg;
        this.details = detail;
        this.httpCodeMessage=httpCodeMessage;
    }

    public ExceptionResponse(String detail){
        super();
        this.details = detail;
    }

    public String getHttpCodeMessage() {
        return httpCodeMessage;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
