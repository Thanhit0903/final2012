package com.example.cotrang;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class VitimexTest {
    WebDriver driver;

    String email = "testselenium12345@gmail.com";
    String password = "Test@123";

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://vitimex.com.vn/");
    }

    @Test
    public void testRegisterAndLogin() throws InterruptedException {

        // đăng ký
        driver.findElement(By.cssSelector(".icon-user")).click(); // mở menu tài khoản
        driver.findElement(By.linkText("Đăng ký")).click();

        driver.findElement(By.id("last_name")).sendKeys("Nguyen");
        driver.findElement(By.id("first_name")).sendKeys("Van nam");
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("password_confirmation")).sendKeys(password);

        driver.findElement(By.cssSelector("button.btn-register")).click();

        Thread.sleep(2000);

        // Kiểm tra đăng ký thành công bằng cách kiểm tra tên user xuất hiện
        WebElement userName = driver.findElement(By.cssSelector(".account-name"));
        System.out.println("Đăng ký thành công: " + userName.getText());


        // đăng xuất
        driver.findElement(By.cssSelector(".icon-user")).click();
        driver.findElement(By.linkText("Đăng xuất")).click();


        // đăng nhập nhập lại
        driver.findElement(By.cssSelector(".icon-user")).click();
        driver.findElement(By.linkText("Đăng nhập")).click();

        driver.findElement(By.id("customer_email")).sendKeys(email);
        driver.findElement(By.id("customer_password")).sendKeys(password);

        driver.findElement(By.cssSelector("button.btn-login")).click();

        Thread.sleep(2000);

        WebElement userName2 = driver.findElement(By.cssSelector(".account-name"));
        System.out.println("Đăng nhập thành công: " + userName2.getText());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
