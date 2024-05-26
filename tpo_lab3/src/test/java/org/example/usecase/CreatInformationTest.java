package org.example.usecase;

import org.example.Utils;
import org.example.pages.CreatInformation;
import org.example.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.example.Utils.wait10Sec;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreatInformationTest {

    @AfterEach
    void tearDown() {
        Utils.getDrivers().forEach(WebDriver::quit);
    }

    @Test
    void creatQuestion() {
        Utils.getDrivers().forEach(webDriver -> {
            webDriver.manage().window().maximize();
            //задержка на выполнение теста = 10 сек.
            wait10Sec(webDriver);
            webDriver.get("https://www.answers.com/");
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.getSignInButton().click();
            loginPage.getSignInButtonWhitEmail().click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            loginPage.getEmailField().sendKeys("maggisapphire@finacenter.com");
            loginPage.getPasswordField().sendKeys("ww2N0mpD");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            loginPage.getSubmit().click();
            CreatInformation creatInformation = new CreatInformation(webDriver);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            creatInformation.getCreatSomeThing().click();

            creatInformation.getCreatQuestion().click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            creatInformation.getTextQuestion().sendKeys("What color are the socks???");
            creatInformation.getSubmitQuestion().click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String text = creatInformation.getAnswer().getText();
            assertEquals(
                    "What color are the socks?",
                    text
            );
            creatInformation.getClickForAnswer().click();
            webDriver.quit();
        });
    }

    @Test
    void CreatStudyGuide() throws RuntimeException {
        Utils.getDrivers().forEach(webDriver -> {
            webDriver.manage().window().maximize();
            //задержка на выполнение теста = 10 сек.
            wait10Sec(webDriver);
            webDriver.get("https://www.answers.com/");
            LoginPage loginPage = new LoginPage(webDriver);
            loginPage.getSignInButton().click();
            loginPage.getSignInButtonWhitEmail().click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            loginPage.getEmailField().sendKeys("maggisapphire@finacenter.com");
            loginPage.getPasswordField().sendKeys("ww2N0mpD");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            loginPage.getSubmit().click();
            CreatInformation creatInformation = new CreatInformation(webDriver);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            creatInformation.getCreatSomeThing().click();

            creatInformation.getStudyGuide().click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            creatInformation.getAddATitle().sendKeys("What color are the socks!!!!!");
            creatInformation.getAddADescription().sendKeys("About socks");
            creatInformation.getAddTags1().sendKeys("socks");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            creatInformation.getAddTags2().sendKeys("blue");
            creatInformation.getAddTags3().sendKeys("black");
            creatInformation.getAddTerm().sendKeys("fitst socks");
            creatInformation.getAddDefinition().sendKeys("black");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            creatInformation.getAddNewCard().click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            creatInformation.getAddTerm1().sendKeys("second socks");
            creatInformation.getAddDefinition1().sendKeys("blue");
            creatInformation.getAddDefinition1().click();
            creatInformation.getCreatGuide().click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String text = creatInformation.getTextGuide().getText();
            assertEquals(
                    "What color are the socks!!!!!",
                    text
           );
            webDriver.quit();
        });
    }
}
