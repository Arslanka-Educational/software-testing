package org.example.usecase;

//import org.example.pages.SearchCarPage;

import org.example.Utils;
import org.example.pages.LoginPage;
import org.example.pages.Profile;
import org.junit.jupiter.api.Test;

import static org.example.Utils.wait10Sec;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfileTest {

    @Test
    void profileTest() {
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
            Profile profile = new Profile(webDriver);
            profile.getClickAvatar().click();
            profile.getClickSettings().click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            profile.getClickCheckBoxEmail().click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            profile.getClickCheckBoxEmail2().click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            profile.getClickCheckBoxEmail3().click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            profile.getClickCheckBoxEmail4().click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            profile.getClickCheckBoxEmail5().click();

            webDriver.quit();
        });
    }
}
