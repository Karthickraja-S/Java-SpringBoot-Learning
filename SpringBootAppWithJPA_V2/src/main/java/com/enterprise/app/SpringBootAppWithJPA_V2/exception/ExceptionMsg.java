package com.enterprise.app.SpringBootAppWithJPA_V2.exception;

import java.time.LocalDate;

public class ExceptionMsg {
    private LocalDate timeStamp;
    public ExceptionMsg(LocalDate timeStamp, String message, String details) {
        super();
        this.timeStamp = timeStamp;
        this.message = message;
        this.url = details;
    }
    public LocalDate getTimeStamp() {
        return timeStamp;
    }
    public String getMessage() {
        return message;
    }
    public String getUrl() {
        return url;
    }
    private String message;
    private String url;
}
