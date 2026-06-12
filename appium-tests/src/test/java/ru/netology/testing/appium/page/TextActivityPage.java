package ru.netology.testing.appium.page;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;

public class TextActivityPage {

    private final AndroidDriver driver;

    private final By text = By.id("ru.netology.testing.uiautomator:id/text");

    public TextActivityPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public String getText() {
        return driver.findElement(text).getText();
    }
}
