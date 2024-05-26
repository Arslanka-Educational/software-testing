package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchAdvanceAnswer {

    private WebDriver webDriver;

    public SearchAdvanceAnswer(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div/div[4]/form/div/div[1]/svg")
    private WebElement openAdvanceSearch;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[4]/div/div[2]/input")
    private WebElement searchTerm;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[4]/div/div[2]/div[2]/button/div")
    private WebElement contentType;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[4]/div/div[2]/div[3]/button/div")
    private WebElement subject;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[4]/div/div[2]/div[4]/button/div")
    private WebElement category;





    public WebElement getOpenAdvanceSearch() {
        return openAdvanceSearch;
    }

    public WebElement getSearchTerm() {
        return searchTerm;
    }

    public WebElement getContentType() {
        return contentType;
    }

    public WebElement getSubject() {
        return subject;
    }

    public WebElement getCategory() {
        return category;
    }


}
