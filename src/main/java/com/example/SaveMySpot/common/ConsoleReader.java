/*
 * ConsoleReader.java
 *
 * Version 1.0
 *
 * Copyright (c) 2026 SaveMySpot. All Rights Reserved.
 *
 * Utility class that provides a single shared Scanner instance
 * for reading user input from the console throughout the application.
 * Prevents the creation of multiple Scanner objects for System.in.
 */

package com.example.SaveMySpot.common;

import java.util.Scanner;

/**
 * Utility class for reading console input.
 *
 * <p>This class exposes a single shared {@link Scanner} instance
 * that can be used throughout the application. The constructor is
 * private to prevent instantiation.</p>
 */
public final class ConsoleReader {

    /** Shared Scanner instance for reading console input. */
    public static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Prevents instantiation of this utility class.
     */
    private ConsoleReader() {
    }
}