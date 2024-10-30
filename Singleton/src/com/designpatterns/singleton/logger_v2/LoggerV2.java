package com.designpatterns.singleton.logger_v2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LoggerV2 {
    private final String fileName = "logger_singleton_v2.txt";
    private PrintWriter printWriter;
    private static LoggerV2 singletonLogger = null;

    private LoggerV2(){
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            printWriter = new PrintWriter(fileWriter, true);
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public static LoggerV2 getInstance(){
        if(singletonLogger == null){
           singletonLogger = new LoggerV2();  // if the instance doesn't already exist then create a new instance
        }
        return singletonLogger;      // if the instance already exists, then just return the existing instance.
    }

    public void logMeesageSent(String message, String recepiant){
        printWriter.println("Message " + message + " to " + recepiant + " \n ");
    }

    public void logReceived(String sender, String message){
        printWriter.println(sender + " says: " + message + " \n ");
    }
}
