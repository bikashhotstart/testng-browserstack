package com.browserstack.suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.browserstack.BrowserStackTestNGTest;

public class SuiteTest04 extends BrowserStackTestNGTest {

    @Test
    public void test_04() throws Exception {
        driver.get("https://www.hotstar.com/");
        WebElement element = driver.findElement(By.id("searchField"));
        element.sendKeys("Hotstar Test  04");
        element.submit();
        Thread.sleep(7000);

        Assert.assertEquals("Hotstar Test  04 - Google Search", driver.getTitle());
    }
}
