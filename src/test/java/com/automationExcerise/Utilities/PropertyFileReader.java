package com.automationExcerise.Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import java.util.Properties;

public class PropertyFileReader {
     Properties prob;
     private Logger log;
    public String readDataFromPropertyFile(String keyName){
        log = LogManager.getLogger(this.getClass().getName());
        prob = new Properties();
        try{
            log.info("Reading the "+keyName+" from property file");
            prob.load(PropertyFileReader.class.getClassLoader().getResourceAsStream("Configuration.properties"));
        }
        catch (Exception e){
            log.error("Reading the "+keyName+" from property file is failed");
            e.printStackTrace();
        }
        return prob.getProperty(keyName);
    }
}
