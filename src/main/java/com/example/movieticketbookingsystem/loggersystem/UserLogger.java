package com.example.movieticketbookingsystem.loggersystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.movieticketbookingsystem.properties.UserProperties;

public class UserLogger {

    private UserLogger(){}

    // Singleton design pattern
    private static final class UserLoggerInstance {
        private static final UserLogger INSTANCE = new UserLogger();
    }

    public static final UserLogger getInstance(){
        return UserLoggerInstance.INSTANCE;
    }

    // logger data add logic
    public void logit(String message, String status, String operation){

        // timestamp
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
