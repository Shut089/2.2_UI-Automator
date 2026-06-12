package ru.netology.testing.appium.page;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage {

    private final AndroidDriver driver;

    private final By userInput = By.id("ru.netology.testing.uiautomator:id/userInput");
    private final By buttonChange = By.id("ru.netology.testing.uiautomator:id/buttonChange");
    private final By buttonActivity = By.id("ru.netology.testing.uiautomator:id/buttonActivity");
    private final By textToBeChanged = By.id("ru.netology.testing.uiautomator:id/textToBeChanged");

    public MainPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public String getChangedText() {
        return driver.findElement(textToBeChanged).getText();
    }

    public void clearInput() {
        WebElement input = driver.findElement(userInput);
        input.clear();
    }

    public void enterText(String text) {
        WebElement input = driver.findElement(userInput);
        input.clear();
        input.sendKeys(text);
    }

    public void clickChangeText() {
        driver.findElement(buttonChange).click();
    }

    public void openTextInAnotherActivity() {
        driver.findElement(buttonActivity).click();
    }
}
