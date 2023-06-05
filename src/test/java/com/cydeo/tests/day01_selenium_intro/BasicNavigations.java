package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();

        driver.get("https://www.tesla.com");
        driver.manage().window().maximize();
        driver.navigate().back();

            Thread.sleep(2000);


        driver.navigate().forward();
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){

        }
        driver.navigate().refresh();
        String current_title=driver.getTitle();
        System.out.println("current Title = " + current_title);
        String current_url=driver.getCurrentUrl();
        System.out.println("current_url = " + current_url);

        Thread.sleep(1000);
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);
        driver.close();



    }
}
