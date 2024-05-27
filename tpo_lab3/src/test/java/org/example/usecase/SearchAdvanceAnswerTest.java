package org.example.usecase;

import org.example.Utils;
import org.example.pages.LoginPage;
import org.example.pages.SearchAdvanceAnswer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.Utils.wait10Sec;

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
            webDriver.get("https://www.answers.com/search");
            SearchAdvanceAnswer searchAdvanceAnswer = new SearchAdvanceAnswer(webDriver);
            wait10Sec(webDriver);
            System.out.println( webDriver.getCurrentUrl());
     //       webDriver.findElements(By.xpath("//*[@id=\"root\"]")).forEach(WebElement::);
//            var fsdf =43;
//            var fdsf = webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[1]/div/div[3]/form/div/div/div/div[1]/svg/use"));
//            var dsad = searchAdvanceAnswer.getOpenAdvanceSearch();
         //   searchAdvanceAnswer.getOpenAdvanceSearch().click();
            new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[name()='use' and @*='#adv-config']/.."))).click();
            System.out.println(searchAdvanceAnswer.getOpenAdvanceSearch().getText());
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
            searchAdvanceAnswer.getSelectСontentType().click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            searchAdvanceAnswer.getCategory().click();
            searchAdvanceAnswer.getSelectCategory().click();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            searchAdvanceAnswer.getSubject().click();
            searchAdvanceAnswer.getSelectsubject().click();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            searchAdvanceAnswer.getSelectRadio().click();
            searchAdvanceAnswer.getAddNumber().sendKeys("3");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            searchAdvanceAnswer.getSortBy().click();
            searchAdvanceAnswer.getSelectSortBy().click();
            searchAdvanceAnswer.getSearch().click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            webDriver.quit();
        });
    }
}
