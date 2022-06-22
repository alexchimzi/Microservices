package com.tsi.uae.demo;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.time.Duration;


public class seleniumTest {


    WebDriver driver = new SafariDriver();

@Test
public void test() {
    driver.navigate().to("http://localhost:3000/");

    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

    driver.findElement(By.id("customer_link")).click();

    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

// Click on the search text box and send value
    //driver.findElement(By.id("lst-ib")).sendKeys("BrowserStack");

// Click on the search button
    //driver.findElement(By.name("btnK")).click();

// Close the Browser
    driver.close();
}

}
