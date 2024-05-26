package org.example.usecase;

import org.example.Utils;
import org.example.pages.LoginPage;
import org.example.pages.SearchAdvanceAnswer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.example.Utils.wait10Sec;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SearchAdvanceAnswerTest {

    @AfterEach
    void tearDown() {
        Utils.getDrivers().forEach(WebDriver::quit);
    }

    @Test
    void searchAdvance() {
        Utils.getDrivers().forEach(webDriver -> {
            webDriver.manage().window().maximize();
            //задержка на выполнение теста = 10 сек.
            wait10Sec(webDriver);
            webDriver.get("https://www.answers.com/");
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.getSignInButton().click();
            loginPage.getSignInButtonWhitEmail().click();
            loginPage.getEmailField().sendKeys("maggisapphire@finacenter.com");
            loginPage.getPasswordField().sendKeys("ww2N0mpD");
            loginPage.getSubmit().click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            webDriver.get("https://www.answers.com/search?filter=all");
            SearchAdvanceAnswer searchAdvanceAnswer = new SearchAdvanceAnswer(webDriver);
            wait10Sec(webDriver);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            searchAdvanceAnswer.getOpenAdvanceSearch().click(); //TODO Не кликается и дальше не проверял
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            searchAdvanceAnswer.getSearchTerm().sendKeys("Barack Obama");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            searchAdvanceAnswer.getContentType().click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            searchAdvanceAnswer.getCategory().click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            searchAdvanceAnswer.getSubject().click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            webDriver.quit();
        });
    }
}
