package org.example.usecase;

import org.example.Utils;
import org.example.pages.LoginPage;
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

public class LoginPageTest {

    @BeforeEach
    void init() {

    }

    @Test
    void loginTest() {
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
            webDriver.quit();
        });
    }

    @Test
    void logoutTest() {
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
            loginPage.getAvatar().click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            loginPage.getLogUot().click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            webDriver.quit();
        });
    }

    @Test
    void loginErrorTest() {
        WebDriver webDriver = Utils.getChromeDriver();
        webDriver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        wait10Sec(webDriver);
        webDriver.get("https://www.answers.com/");
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.getSignInButton().click();
        loginPage.getSignInButtonWhitEmail().click();
        loginPage.getEmailField().sendKeys("maggisapphire@finacenter.com");
        loginPage.getPasswordField().sendKeys("4234");
        loginPage.getSubmit().click();
        String text = loginPage.getErrorMessage().getText();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        webDriver.quit();
        assertEquals(
                "Passwords must be between 8 and 40 characters long",
                text
        );
    }
}
