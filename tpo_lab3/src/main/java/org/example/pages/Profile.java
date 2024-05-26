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


    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div[4]/div[3]/span/div/div/div/button[2]/a/span")
    private WebElement clickSettings;

    //*[@id="checkbox"]/input

    @FindBy(xpath = "//*[@id=\"checkbox\"]/input")
    private WebElement clickCheckBoxEmail;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/div[4]/fieldset/div/label[1]/div/input")//TODO ПОЛНЫЕ ПУТИ
    private WebElement clickCheckBoxEmail2;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/div[4]/fieldset/div/label[2]/div/input")//TODO ПОЛНЫЕ ПУТИ
    private WebElement clickCheckBoxEmail3;

    public WebElement getClickCheckBoxEmail2() {
        return clickCheckBoxEmail2;
    }

    public WebElement getClickCheckBoxEmail3() {
        return clickCheckBoxEmail3;
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