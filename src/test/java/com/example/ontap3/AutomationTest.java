package com.example.ontap3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AutomationTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test(priority = 1)
    public void testClickAoNamMenu() {
        driver.get("https://vitimex.com.vn/");
        WebElement aoNamMenu = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='ÁO NAM']"))
        );
        aoNamMenu.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("ao-nam"));
        System.out.println("✅ Đã truy cập vào menu ÁO NAM");
    }

    @Test(priority = 2)
    public void testAddProductToCart() {
        driver.get("https://vitimex.com.vn/collections/ao-nam");

        // B1. Mở sản phẩm đầu tiên
        WebElement firstProduct = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("a.product-loop--link"))
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstProduct);
        System.out.println("🛍️ Đã mở trang chi tiết sản phẩm");

        // B2. Click nút “CHỌN SIZE”
        WebElement chooseSizeBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("#btn-addtocart.req-size")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", chooseSizeBtn);
        System.out.println("📏 Đã nhấn nút 'CHỌN SIZE'");

        // B3. Chờ modal chọn size hiển thị
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-content, .modal-dialog")));

        // B4. Chờ và chọn size (ưu tiên 46 nếu có)
        List<WebElement> sizes = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("label.aspect-ratio"))
        );

        WebElement sizeToClick = sizes.stream()
                .filter(e -> e.getAttribute("data-value").equals("46"))
                .findFirst()
                .orElse(sizes.get(0));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sizeToClick);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sizeToClick);
        System.out.println("✅ Đã chọn size: " + sizeToClick.getAttribute("data-value"));

        // B5. Click nút “THÊM VÀO GIỎ HÀNG” trong modal
        WebElement addToCartModalBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("modal-btn-addtocart")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartModalBtn);
        System.out.println("🛒 Đã nhấn nút 'THÊM VÀO GIỎ HÀNG' trong modal");

        // B6. Chờ modal đóng lại
        wait.until(ExpectedConditions.invisibilityOf(addToCartModalBtn));
        System.out.println("✅ Modal chọn size đã đóng");

        // B7. Click nút “THÊM VÀO GIỎ” trên trang chi tiết
        WebElement addToCartFinalBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("#btn-addtocart.add-cart")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartFinalBtn);
        System.out.println("🎯 Đã nhấn nút 'THÊM VÀO GIỎ' trên trang chi tiết");

        // B8. Xác nhận giỏ hàng có sản phẩm (nếu muốn chắc chắn)
        Assert.assertTrue(driver.getPageSource().toLowerCase().contains("giỏ hàng")
                        || driver.getPageSource().toLowerCase().contains("cart"),
                "❌ Không phát hiện nội dung giỏ hàng!");
        System.out.println("✅ Sản phẩm đã được thêm vào giỏ hàng thành công!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
