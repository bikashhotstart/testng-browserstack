package com.browserstack;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SingleTest extends BrowserStackTestNGTest {

    @Test
    public void test() throws Exception {

        driver.get("https://www.hotstar.com/");
        //Declare and initialise a fluent wait
        FluentWait wait = new FluentWait(driver);
//Specify the timout of the wait
        wait.withTimeout(2000, TimeUnit.MILLISECONDS);
//Sepcify polling time
        wait.pollingEvery(250, TimeUnit.MILLISECONDS);
//Specify what exceptions to ignore
        wait.ignoring(NoSuchElementException.class);

//This is how we specify the condition to wait on.
//This is what we will explore more in this chapter
        wait.until(ExpectedConditions.alertIsPresent());


       // Thread.sleep(3000);
        WebElement element = driver.findElement(By.id("searchField"));
        element.sendKeys("Hotstar");
        element.sendKeys(Keys.ENTER);
        //element.submit();
        wait.withTimeout(2000, TimeUnit.MILLISECONDS);
        wait.pollingEvery(250, TimeUnit.MILLISECONDS);
        wait.ignoring(NoSuchElementException.class);
        //Thread.sleep(5000);
        Assert.assertEquals("Disney+ Hotstar", driver.getTitle());
    }
}
