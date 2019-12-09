package com.labapi.tamperelogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TampereLogin
{
    WebDriver driver;

    public void getLogin(){
        System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://logintolabra.tre.nsn-rdnet.net/dana/home/infranet.cgi");
        WebElement element = driver.findElement( By.id( "username" ) );
        element.sendKeys( "zzakariy@nsn-intra" );
        WebElement elementPass = driver.findElement( By.id( "password" ) );
        elementPass.sendKeys( "BooBoo#8" );
        driver.findElement( By.id( "btnSubmit_6" ) ).click();
        driver.close();
    }
    
    
}
