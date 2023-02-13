package com.nhsPatient.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    //private variable
    private static WebDriver driver;
    //Private constructor to make sure they do not create an object
    //from this class
    private Driver(){}

    public static WebDriver getDriver(){
        if(driver==null){//I am checking driver whether it is null or not.
            //if driver is null I am going to create a new one
            //if not,It is not going to create a new Driver.It will use the existing(current) one.
            String browser = ConfigurationReader.getProperty("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                default:
                    throw new RuntimeException("No such a browser yet!");

            }
        }
        return driver;
    }
    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

}

