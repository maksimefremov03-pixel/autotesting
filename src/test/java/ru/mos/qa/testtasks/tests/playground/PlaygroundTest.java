package ru.mos.qa.testtasks.playground;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaygroundTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void ajaxDataTest() {
        driver.get("http://uitestingplayground.com/ajax");
        WebElement triggerButton = driver.findElement(By.id("ajaxButton"));
        triggerButton.click();
        By labelLocator = By.cssSelector("div#content p.bg-success");
        WebElement successLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(labelLocator));
        String actualText = successLabel.getText();
        String expectedText = "Data loaded with AJAX get request.";
        assertEquals(expectedText, actualText);
    }

    @Test
    public void sampleAppTest() {
        driver.get("http://uitestingplayground.com/sampleapp");
        String validUsername = "MyUserName";
        String validPassword = "pwd";
        WebElement nameInput = driver.findElement(By.name("UserName"));
        WebElement passwordInput = driver.findElement(By.name("Password"));
        WebElement loginButton = driver.findElement(By.id("login"));
        nameInput.sendKeys(validUsername);
        passwordInput.sendKeys(validPassword);
        loginButton.click();
        By loginStatusLocator = By.id("loginstatus");
        WebElement loginStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(loginStatusLocator));
        String actualStatus = loginStatus.getText();
        String expectedStatus = "Welcome, " + validUsername + "!";
        assertEquals(expectedStatus, actualStatus);
    }
}