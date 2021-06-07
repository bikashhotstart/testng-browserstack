package com.browserstack.suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.browserstack.BrowserStackTestNGTest;

public class SuiteTest01 extends BrowserStackTestNGTest {

    @Test
    public void test_01() throws Exception {
        driver.get("https://www.hotstar.com/");
        WebElement element = driver.findElement(By.id("searchField"));
        element.sendKeys("Hotstar Test  01");
        element.submit();
        Thread.sleep(5000);

        Assert.assertEquals("Hotstar Test  01 - Google Search", driver.getTitle());
    }
}
