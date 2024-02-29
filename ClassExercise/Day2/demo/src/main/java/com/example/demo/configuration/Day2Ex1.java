package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
public class Day2Ex1 {
    
    @Value("rcb")
    private String appName;
    @Value("rcbb")
    private String appVersion;

    

    public Day2Ex1() {
        this.appName = "2020";
        this.appVersion = "ak";
    }

    public String getAppName() {
        return appName;
    }
    
    public String getAppVersion() {
        return appVersion;
    }
    
    public void setAppName(String appName){
        this.appName=appName;
    }
    public void setAppVersion(String appVersion){
        this.appVersion=appVersion;
    }
    

}






