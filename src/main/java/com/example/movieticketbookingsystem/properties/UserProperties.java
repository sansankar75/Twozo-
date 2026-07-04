package com.example.movieticketbookingsystem.properties;

import java.io.InputStream;
import java.util.Properties;
import java.io.IOException;

public class UserProperties {
    private static final Properties properties = new Properties();
    private static final String applicationProperties = "application.properties";
    private UserProperties(){
        loadProperties();
    }

    private static final class UserPropertiesInstance{
        private static final UserProperties INSTANCE = new UserProperties();
    }

    public static UserProperties getInstance(){
        return UserPropertiesInstance.INSTANCE;
    }

    private static void loadProperties(){
        try(InputStream input = UserProperties.class
                .getClassLoader()
                .getResourceAsStream(applicationProperties)) {
            if (input == null){
                throw new RuntimeException("Application properties file is not found");
            }
            properties.load(input);
        }catch(IOException e){
            throw new RuntimeException("Failed to load application.properties:"+ e.getMessage());
        }
    }

    public static String getProperty(String key){
        String propertyValue = properties.getProperty(key);
        if(propertyValue == null){
            throw new RuntimeException(" Given properties name not found");
        }
        return propertyValue.trim();
    }

}
