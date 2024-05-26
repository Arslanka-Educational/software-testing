package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Profile {

    private WebDriver webDriver;

    public Profile(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//*[@id=\"profile-menu\"]/span/img")
    private WebElement clickAvatar;


    @FindBy(xpath = "//*[@href=\'https://www.answers.com/user/profile']/span")
    private WebElement clickSettings;

    //*[@id="checkbox"]/input

    @FindBy(xpath = "//*[@value=\"optInEmail\"]/input")
    private WebElement clickCheckBoxEmail;

    @FindBy(xpath = "//*[@value=\"optInEmailNotifications\"]/input")
    private WebElement clickCheckBoxEmail2;

    @FindBy(xpath = "//*[@value=\"optInDatabaseNotifications\"]/input")
    private WebElement clickCheckBoxEmail3;

    @FindBy(xpath = "//*[@value=\"optInNotifications\"]/input")
    private WebElement clickCheckBoxEmail4;

    @FindBy(xpath = "//*[@value=\"optInPpid\"]/input")
    private WebElement clickCheckBoxEmail5;


    public WebElement getClickCheckBoxEmail2() {
        return clickCheckBoxEmail2;
    }

    public WebElement getClickCheckBoxEmail3() {
        return clickCheckBoxEmail3;
    }

    public WebElement getClickCheckBoxEmail5() {
        return clickCheckBoxEmail5;
    }

    public WebElement getClickCheckBoxEmail4() {
        return clickCheckBoxEmail4;
    }

    public WebElement getClickAvatar() {
        return clickAvatar;
    }

    public WebElement getClickSettings() {
        return clickSettings;
    }

    public WebElement getClickCheckBoxEmail() {
        return clickCheckBoxEmail;
    }




}