package org.example.usecase;

import org.example.Utils;
import org.example.pages.LoginPage;
import org.example.pages.SearchAnswer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.example.Utils.wait10Sec;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchAnswerTest {

    @Test
    void searchAnswer() {
        Utils.getDrivers().forEach(webDriver -> {
            webDriver.manage().window().maximize();
            //задержка на выполнение теста = 10 сек.
            wait10Sec(webDriver);
            webDriver.get("https://www.answers.com/");
            SearchAnswer searchAnswer = new SearchAnswer(webDriver);
            searchAnswer.getInputField().sendKeys("what is it borsh?");
            searchAnswer.getSearchButton().click();
            searchAnswer.getViewPage().click();
            String text = searchAnswer.getAnswer().getText();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            assertEquals(
                    "It's probably some variant of borscht, perhaps \"borsh.\"",
                    text
            );

            webDriver.quit();
        });

    }
}
