package com.browserstack.suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.browserstack.BrowserStackTestNGTest;

public class SuiteTest07 extends BrowserStackTestNGTest {

    @Test
    public void test_07() throws Exception {
        driver.get("https://www.hotstar.com/");
        WebElement element = driver.findElement(By.id("searchField"));
        element.sendKeys("Hotstar Test  07");
        element.submit();
        Thread.sleep(3000);

        Assert.assertEquals("Hotstar", driver.getTitle());
    }
}
