package com.example.movieticketbookingsystem.repository;

import com.example.movieticketbookingsystem.util.PasswordHashing;

import java.util.Map;
import java.util.HashMap;

public class UserRepository {
    private static Map<String, String> userTable = new HashMap<>();


    static{
        // fake data
        userTable.put("john_doe", PasswordHashing.hashPassword("John@123"));
        userTable.put("alice_smith", PasswordHashing.hashPassword("Alice#2024"));
        userTable.put("bob_wilson", PasswordHashing.hashPassword("Bob$Secure"));
        userTable.put("emma_davis", PasswordHashing.hashPassword("Emma@789"));
        userTable.put("michael_brown", PasswordHashing.hashPassword("Mike%Pass"));
        userTable.put("sarah_johnson", PasswordHashing.hashPassword("Sarah#123"));
        userTable.put("david_miller", PasswordHashing.hashPassword("David!789"));
        userTable.put("lisa_anderson", PasswordHashing.hashPassword("Lisa@2026"));
        userTable.put("james_thompson", PasswordHashing.hashPassword("James$2024"));
        userTable.put("mary_taylor", PasswordHashing.hashPassword("Mary#Secure"));
    }

    public static boolean getUserName(String userName){
        return userTable.containsKey(userName);
    }

    public static String getUserPassword(String userName){
        return userTable.get(userName);
    }


}
