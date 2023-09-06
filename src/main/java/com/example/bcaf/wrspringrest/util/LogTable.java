package com.example.bcaf.wrspringrest.util;

import com.example.bcaf.wrspringrest.model.LogRequest;
import com.example.bcaf.wrspringrest.repo.LogRequestRepo;

public class LogTable {

    private LogRequestRepo logRequestRepo;

    public static void inputLogRequest(LogRequestRepo logRequestRepo, String[] datax, Exception e, String flag) {
        if (flag.equalsIgnoreCase("y")) {
            LogRequest logRequest = new LogRequest();
            logRequest.setDataRequest(datax[1]);
            logRequest.setCreatedBy(1L);
            logRequest.setClassName(datax[0]);
            logRequest.setErrorMessagez(e.getMessage());
            logRequest.setErrorMessagez(e.getMessage());
            logRequestRepo.save(logRequest);
        }
    }
}