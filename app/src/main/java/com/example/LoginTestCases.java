package com.example;


import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;





public class LoginTestCases {

    WebDriver driver;
    WebElement userName;
    WebElement password;
    WebElement submitCredentials;

    public LoginTestCases(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public void closeWindow(){
        if(driver != null){
        driver.quit();
        }
    }

    public void launchingBrowser(){
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    public void initalisingCredentials(){
        userName = driver.findElement(By.id("username"));
        password = driver.findElement(By.id("password"));
        submitCredentials = driver.findElement(By.id("submit"));
    }

    public void formInputs(String username, String pass){
        userName.sendKeys(username);
        password.sendKeys(pass);
    }

    public void clickSubmit(){
        submitCredentials.click();
    }


    public void testCase01(){

        System.out.println("Starting the TestCase_01 Valid Credentials");

        launchingBrowser();

        initalisingCredentials();

        formInputs("student", "Password123");

        clickSubmit();

        String actutalTitle = driver.getTitle();

        String expctedTitle  = "Logged In Successfully | Practice Test Automation";
        
        expctedTitle = expctedTitle.toLowerCase();


        assert actutalTitle.contains(expctedTitle) : "Failed";

        WebElement logout = driver.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/div/div/div/a"));
        
        assert logout.isDisplayed() : "Logout button not displayed!";

        System.out.println("TestCase_01 successfull");
    }


    public void testCase_02(){
        System.out.println("Starting the TestCase_01 Invalid Credentials");

        launchingBrowser();

        System.out.println("Entering the Valid username and invalid password");

        initalisingCredentials();

        formInputs("student", "Passd123");

        clickSubmit();

        assert driver.getPageSource().contains("Your password is invalid!") : "Failed";

        System.out.println("Valid username and invalid password : TEST PASSED");
        System.out.println("TestCase_02 : PASSED");

        
    }

    public void testCase_03(){
        System.out.println("Entering Invalid username and valid Password");

        launchingBrowser();

        initalisingCredentials();

        formInputs("sdfsd", "Password123");

        clickSubmit();

        assert driver.getPageSource().contains("Your username is invalid!") : "Failed";

        System.out.println("Invalid username and Valid password : TEST PASSED");
        System.out.println("TestCase_03 : PASSED");

    }

    public void testCase_04(){
        System.out.println("Entering the Invalid username and invalid password");

        launchingBrowser();

        initalisingCredentials();

        formInputs("sdnfdsn", "dfbsidb");

        clickSubmit();

        assert driver.getPageSource().contains("Your username is invalid!") : "Failed";

        System.out.println("Invalid username and Invalid password : TEST PASSED");
        System.out.println("TestCase_04 : PASSED");

    }
    
    
}
