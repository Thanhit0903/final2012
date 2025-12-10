package com.example.foob;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void registration() throws InterruptedException {
        driver.get("https://vitimex.com.vn/");
        driver.findElement(By.xpath("//a[@href='/collections/ao-nam']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@href='/products/atr5033']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"variant-swatch-2\"]/div[2]/div[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("btn-addtocart")).click();
        Thread.sleep(3000);
        assertEquals("https://vitimex.com.vn/products/atr5033", driver.getCurrentUrl());
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
