package com.browserstack;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.NoSuchElementException;
import com.google.common.base.Function;

public class SingleTest extends BrowserStackTestNGTest {

    @Test
    public void test() throws Exception {

        driver.get("https://www.hotstar.com/");
        //Declare and initialise a fluent wait
        FluentWait wait = new FluentWait(driver);
        wait.pollingEvery(250, TimeUnit.MILLISECONDS);
        wait.withTimeout(5000, TimeUnit.MILLISECONDS);

       // Thread.sleep(3000);
        Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver arg0) {
                System.out.println("Checking for the object!!");
                WebElement element = arg0.findElement(By.id("searchField"));
                if (element != null) {
                    System.out.println("A new dynamic object is found.");
                }
                return element;
            }
        };
        wait.until(function);
        WebElement element = driver.findElement(By.id("searchField"));
        element.sendKeys("Hotstar");
        element.sendKeys(Keys.ENTER);
        //element.submit();
        wait.pollingEvery(250, TimeUnit.MILLISECONDS);
        wait.withTimeout(5000, TimeUnit.MILLISECONDS);

        //wait.ignoring(NoSuchElementException.class);
        //wait.until(ExpectedConditions.alertIsPresent());
        //Thread.sleep(5000);
        Assert.assertEquals("Disney+ Hotstar - Watch TV Shows, Movies, Live Cricket Matches & News Online", driver.getTitle());
    }
}
