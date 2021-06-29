package com.browserstack;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SingleTest1  {

    @Test
    public void test() throws Exception {

        WebDriver driver =null;
        try {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            driver = new RemoteWebDriver(
                    new URL("http://localhost:4444/wd/hub"), capabilities);


            driver.get("https://www.hotstar.com/");
            //Declare and initialise a fluent wait
            FluentWait wait = new FluentWait(driver);
            wait.pollingEvery(250, TimeUnit.MILLISECONDS);
            wait.withTimeout(5000, TimeUnit.MILLISECONDS);
            wait.ignoring(NoSuchElementException.class);


            WebElement element = driver.findElement(By.id("searchField"));
            element.sendKeys("Hotstar");
            element.sendKeys(Keys.ENTER);
            //element.submit();
            wait.pollingEvery(250, TimeUnit.MILLISECONDS);
            wait.withTimeout(5000, TimeUnit.MILLISECONDS);
            wait.ignoring(NoSuchElementException.class);

            //Thread.sleep(5000);
            Assert.assertEquals("Disney+ Hotstar", driver.getTitle());
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
        finally {
            if (driver !=null )
            driver.quit();

        }

    }
}
