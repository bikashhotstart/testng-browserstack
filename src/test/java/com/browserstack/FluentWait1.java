package com.browserstack;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;
import com.google.common.base.Function;

public class FluentWait1 {
        @Test
        public static void main(String [] args){
        //public void fluentWaitMethod(){
            System.setProperty("webdriver.gecko.driver","C:\\Selenium\\selenium-java-3.141.59\\Geckodriver\\geckodriver.exe");
            WebDriver driver = new FirefoxDriver();
            driver.get("https://www.hotstar.com/");
            //WebElement e1 = driver.findElement(By.id("searchField"));
            FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofMillis(5000))
                       .pollingEvery(Duration.ofMillis(1000))
                       .ignoring(NoSuchElementException.class);
            WebElement element = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    WebElement element = driver.findElement(By.id("searchField"));
                    element.sendKeys("Hotstar");
                    element.sendKeys(Keys.ENTER);
                    String S=driver.getTitle();
                    if(S.equals("Disney+ Hotstar - Watch TV Shows, Movies, Live Cricket Matches & News Online")){
                        System.out.println(S);
                        return element;
                    }else{
                        System.out.println("FluentWait Failed");
                        return null;
                    }
                }
            });
        }
    }

