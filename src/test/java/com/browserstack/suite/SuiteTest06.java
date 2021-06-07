package com.browserstack.suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.browserstack.BrowserStackTestNGTest;

public class SuiteTest06 extends BrowserStackTestNGTest {

    @Test
    public void test_06() throws Exception {
        driver.get("https://www.hotstar.com/");
        Thread.sleep(7000);
        WebElement element = driver.findElement(By.id("searchField"));
        element.sendKeys("Hotstar Test  06");
        Thread.sleep(7000);
        element.submit();
        Thread.sleep(7000);

        Assert.assertEquals("Hotstar", driver.getTitle());
    }
}
