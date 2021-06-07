package com.browserstack.suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.browserstack.BrowserStackTestNGTest;

public class SuiteTest10 extends BrowserStackTestNGTest {

    @Test
    public void test_10() throws Exception {
        driver.get("https://www.hotstar.com/");
        WebElement element = driver.findElement(By.id("searchField"));
        element.sendKeys("Hotstar Test  10");
        element.submit();
        Thread.sleep(10000);

        Assert.assertEquals("Hotstar", driver.getTitle());
    }
}
