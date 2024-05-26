package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchAnswer {

    public SearchAnswer(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//*[@id=\"search-input\"]")
    private WebElement inputField;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/main/section[1]/div[2]/button")
    private WebElement searchButton;

    @FindBy(xpath = " //*[@id=\"best-answer\"]/div[4]/div[2]/button[2]")
    private WebElement viewPage;

    @FindBy(xpath = "//*[@id=\"top-answer\"]/div[2]/div[1]/div/p")
    private WebElement answer;
    public WebElement getInputField() {
        return inputField;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getViewPage() {
        return viewPage;
    }

    public WebElement getAnswer(){return answer;}

}
