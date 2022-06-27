package com.myfirstproject;

import Utilities.TestBase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
public class Day13_Log4J extends TestBase {
    private static Logger logger = LogManager.getLogger(Day13_Log4J.class.getName());
    @Test
    public void log4JTest(){
        logger.info("Opening the URL");
        driver.get("https://www.carettahotel.com/");
        logger.info("Clicking on Login Button");
        driver.findElement(By.linkText("Log in")).click();
        logger.fatal("Fatal Log");//PRINTS by default with no configuration
        logger.error("Error Log");//ERROR by default with no configuration
        logger.debug("Debug Log");
    }
}