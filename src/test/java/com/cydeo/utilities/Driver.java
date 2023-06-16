package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    private Driver() {
    }

    private static WebDriver driver;

   public static WebDriver getDriver(){

        String browserType= ConfigurationReader.getProperty("browser");
        String url=ConfigurationReader.getProperty("env3");
        if(driver==null){

            switch(browserType){
                case "chrome":

                    WebDriverManager.chromedriver().setup();
                    driver= new ChromeDriver();
                    driver.get(url);
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

                case "firefox":
                    WebDriverManager.chromedriver().setup();
                    driver= new FirefoxDriver();
                    driver.get(url);
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

            }





        }

        return driver;
    }

    public static void closeDriver(){
       if(driver!=null) {
           driver.quit();

           driver=null;

       }
    }
}
