package com.example;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropdownTest extends LoginTestCases {

    public DropdownTest(){
        super(); 
        System.out.println("LoginTestCases constructor : inhereited Webdriver");
    }

    public void dropBrowserLaunch(){
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }

    public void dropdown(){
        driver.findElement(By.name("my-text")).sendKeys("Kalyan");
        driver.findElement(By.name("my-password")).sendKeys("Kalyan123");
        driver.findElement(By.name("my-textarea")).sendKeys("Hey kalyan \nHow are you?");
        
        WebElement dropdown = driver.findElement(By.name("my-select"));

        Select  ss = new Select(dropdown);
        ss.selectByVisibleText("Two");

        WebElement selectedOption = ss.getFirstSelectedOption();
        String actualText = selectedOption.getText();

        String expectedText = "Two";

        if(actualText.equals(expectedText)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }


    }

    
    
}
