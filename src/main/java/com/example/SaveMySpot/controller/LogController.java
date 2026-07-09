package com.example.SaveMySpot.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogController {

    private static final Logger logger = LogManager.getLogger(LogController.class);

    public static void process(){

        // services
        logger.trace("From the trace method hi");
        logger.info("info from INFO");
        logger.debug("debug from DEBUG");
        logger.warn("warning from WARNING");
        logger.error("error from ERROR ");
        logger.fatal("fatal from FATAL");
    }

    public static void main(String[] args) {
        process();
    }
}
