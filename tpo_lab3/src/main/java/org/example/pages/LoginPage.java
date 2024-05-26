package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[4]/div[3]/span/button")
    private WebElement logInButton;


    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div/div[4]/div/div[2]/div/div[2]/div[2]/div/button[4]")
    private WebElement logInWithEmail;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div/div[4]/div/div[2]/div[2]/form/button")
    private WebElement submit;


    @FindBy(xpath = "//*[@id=\"email-input\"]")
    private WebElement emailField;


    @FindBy(xpath = "//*[@id=\"outlined-adornment-password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"profile-menu\"]/span/img")
    private WebElement avatar;


    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[4]/div[3]/span/div/div/div/button[3]/a/span")
    private WebElement logUot;

    @FindBy(xpath = "//*[@id=\"loginUser\"]/div[2]/span")
    private WebElement errorMessage;

    public WebElement getEmailField() {
        return emailField;
    }


    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getSignInButton() {
        return logInButton;
    }

    public WebElement getSignInButtonWhitEmail() {
        return logInWithEmail;
    }
    public WebElement getSubmit() {
        return submit;
    }

    public WebElement getAvatar() {
        return avatar;
    }

    public WebElement getLogUot() {
        return logUot;
    }


    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }
}
