package com.example.movieticketbookingsystem.repository;

import com.example.movieticketbookingsystem.util.PasswordHashing;

import java.util.Map;
import java.util.HashMap;

public class UserRepository {
    private static Map<String, String> userTable = new HashMap<>();

    static PasswordHashing hash = new PasswordHashing();

    static{
        userTable.put("john_doe", hash.hashPassword("John@123"));
        userTable.put("alice_smith", hash.hashPassword("Alice#2024"));
        userTable.put("bob_wilson", hash.hashPassword("Bob$Secure"));
        userTable.put("emma_davis", hash.hashPassword("Emma@789"));
        userTable.put("michael_brown", hash.hashPassword("Mike%Pass"));
        userTable.put("sarah_johnson", PasswordHashing.hashPassword("Sarah#123"));
        userTable.put("david_miller", hash.hashPassword("David!789"));
        userTable.put("lisa_anderson", hash.hashPassword("Lisa@2026"));
        userTable.put("james_thompson", hash.hashPassword("James$2024"));
        userTable.put("mary_taylor", hash.hashPassword("Mary#Secure"));
    }


}
