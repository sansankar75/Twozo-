package com.example.SaveMySpot.loggersystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.SaveMySpot.properties.UserProperties;

public class UserLogger {

    private UserLogger(){}

    private static final class UserLoggerInstance {
        private static final UserLogger INSTANCE = new UserLogger();
    }

    public static final UserLogger getInstance(){
        return UserLoggerInstance.INSTANCE;
    }

    public void logit(String message, String status, String operation){

        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern(UserProperties.getProperty("log.date.format")));

        try(BufferedWriter writer = new BufferedWriter(
                new FileWriter(UserProperties.getProperty("userLog.file.path"), true))) {
            writer.write("-----------------------------------");
            writer.newLine();
            writer.write("TimeStamp:"+ timeStamp);
            writer.newLine();
            writer.write("Message :"+ message);
            writer.newLine();
            writer.write("Status :"+ status);
            writer.newLine();
            writer.write("File operation :"+ operation);
            writer.newLine();

        } catch (IOException e) {
            throw new RuntimeException("Failed to write log:"+ e);
        }
    }
}
