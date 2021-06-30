package com.browserstack;
import java.time.Duration;
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
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
        wait.withTimeout(Duration.ofMillis(5000))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);
        WebElement element=wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("searchField"));
            }
        });
        //WebElement element = driver.findElement(By.id("searchField"));
        element.sendKeys("Hotstar");
        element.sendKeys(Keys.ENTER);
        //Thread.sleep(5000);
        Assert.assertEquals("Disney+ Hotstar - Watch TV Shows, Movies, Live Cricket Matches & News Online", driver.getTitle());
    }
}
