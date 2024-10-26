package com.fy658.javaspring.service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class MailService {
    private ZoneId zoneId = ZoneId.systemDefault();

    public void setZoneId(ZoneId zoneId) {
        this.zoneId = zoneId;
    }
    public String getTime(){
        return ZonedDateTime.now(this.zoneId).format(DateTimeFormatter.ISO_DATE_TIME);
    }
    public void snedLoginMail(User user){
        System.err.println(String.format("Hi, %s! you are login in at %s", user.getName(), getTime()));
    }
    public void sendRegistrationMail(User user) {
        System.err.println(String.format("Welcome, %s!", user.getName()));
    }
}
