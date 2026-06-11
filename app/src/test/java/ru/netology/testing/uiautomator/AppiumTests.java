package ru.netology.testing.uiautomator;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class AppiumTests {

    private AndroidDriver driver;

    private static final String APP_PATH =
            "/Users/antonborodin/Web/Netology/2.1_auto/mqa-homeworks/2.2 UI Automator/sample/app/build/intermediates/apk/debug/app-debug.apk";

    private static final String PACKAGE_NAME = "ru.netology.testing.uiautomator";

    @Before
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setDeviceName("emulator-5554")
                .setApp(APP_PATH)
                .setAppWaitActivity("*")
                .setAllowTestPackages(true);

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723/"),
                options
        );

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void shouldNotChangeTextWhenInputIsEmpty() {
        WebElement textToBeChanged = driver.findElement(
                By.id(PACKAGE_NAME + ":id/textToBeChanged")
        );

        String textBefore = textToBeChanged.getText();

        WebElement userInput = driver.findElement(
                By.id(PACKAGE_NAME + ":id/userInput")
        );

        userInput.clear();

        WebElement buttonChange = driver.findElement(
                By.id(PACKAGE_NAME + ":id/buttonChange")
        );

        buttonChange.click();

        String textAfter = textToBeChanged.getText();

        assertEquals(textBefore, textAfter);
    }

    @Test
    public void shouldOpenTextInNewActivity() {
        String expectedText = "Netology";

        WebElement userInput = driver.findElement(
                By.id(PACKAGE_NAME + ":id/userInput")
        );

        userInput.clear();
        userInput.sendKeys(expectedText);

        WebElement buttonActivity = driver.findElement(
                By.id(PACKAGE_NAME + ":id/buttonActivity")
        );

        buttonActivity.click();

        WebElement text = driver.findElement(
                By.id(PACKAGE_NAME + ":id/text")
        );

        assertEquals(expectedText, text.getText());
    }
}