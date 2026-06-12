package ru.netology.testing.appium;

import org.junit.Test;

import ru.netology.testing.appium.page.MainPage;
import ru.netology.testing.appium.page.TextActivityPage;

import static org.junit.Assert.assertEquals;

public class AppiumTests extends BaseTest {

    @Test
    public void shouldNotChangeTextWhenInputIsEmpty() {
        MainPage mainPage = new MainPage(driver);

        String textBefore = mainPage.getChangedText();

        mainPage.clearInput();
        mainPage.clickChangeText();

        String textAfter = mainPage.getChangedText();

        assertEquals(textBefore, textAfter);
    }

    @Test
    public void shouldOpenTextInNewActivity() {
        String expectedText = "Netology";

        MainPage mainPage = new MainPage(driver);

        mainPage.enterText(expectedText);
        mainPage.openTextInAnotherActivity();

        TextActivityPage textActivityPage = new TextActivityPage(driver);

        assertEquals(expectedText, textActivityPage.getText());
    }
}
