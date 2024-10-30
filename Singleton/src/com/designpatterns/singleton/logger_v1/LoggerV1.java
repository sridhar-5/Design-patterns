package com.designpatterns.singleton.logger_v1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LoggerV1 {
    private final String fileName = "logger_v1.txt";
    private PrintWriter printWriter;

    public LoggerV1(){
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            printWriter = new PrintWriter(fileWriter, true);
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public void logMeesageSent(String message, String recepiant){
        printWriter.println("Message " + message + " to " + recepiant + " \n ");
    }

    public void logReceived(String sender, String message){
        printWriter.println(sender + " says: " + message + " \n ");
    }
}