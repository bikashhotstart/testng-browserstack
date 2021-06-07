package com.browserstack.suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.browserstack.BrowserStackTestNGTest;

public class SuiteTest08 extends BrowserStackTestNGTest {

    @Test
    public void test_08() throws Exception {
        driver.get("https://www.hotstar.com/");
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.id("searchField"));
        element.sendKeys("Hotstar Test  08");
        element.submit();
        Thread.sleep(3000);

        Assert.assertEquals("Hotstar Test  08 - Google Search", driver.getTitle());
    }
}
