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

    @FindBy(xpath = "//*[name()='use' and @*='#adv-config']")
    private WebElement openAdvanceSearch;

    @FindBy(xpath = "//*[@type=\"text\"]")
    private WebElement searchTerm;

    @FindBy(xpath = "//*[@role=\"dialog\"]/div[2]/button/div")
    private WebElement contentType;

    @FindBy(xpath = "//*[@role=\"dialog\"]/div[2]/div/div/span[1]/span")
    private WebElement selectСontentType;

    @FindBy(xpath = "//*[@role=\"dialog\"]/div[3]/button/div")
    private WebElement subject;

    @FindBy(xpath = "//*[@role=\"dialog\"]/div[3]/div/div/span[1]/span")
    private WebElement selectsubject;

    @FindBy(xpath = "//*[@role=\"dialog\"]/div[4]/button/div")
    private WebElement category;

    @FindBy(xpath = "//*[@role=\"dialog\"]/div[4]/div/div/span[2]/span")
    private WebElement selectCategory;

    @FindBy(xpath = "//*[@role=\"dialog\"]/div[5]/div[3]/input")
    private WebElement selectRadio;


    @FindBy(xpath = "//*[@role=\"dialog\"]/div[6]/button/div")
    private WebElement sortBy;

    @FindBy(xpath = "//*[@role=\"dialog\"]/div[6]/div/div/span[1]")
    private  WebElement selectSortBy;

    @FindBy(xpath = "//*[@role=\"dialog\"]/div[7]/button")
    private  WebElement search;

    @FindBy(xpath = "//*[@type=\"number\"]")
    private WebElement addNumber;

    public WebElement getSelectSortBy() {
        return selectSortBy;
    }
    public WebElement getSearch() {
        return search;
    }
    public WebElement getAddNumber() {
        return addNumber;
    }

    public WebElement getSortBy() {
        return sortBy;
    }

    public WebElement getSelectRadio() {
        return selectRadio;
    }
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
    public WebElement getSelectСontentType() {
        return selectСontentType;
    }
    public WebElement getSelectsubject() {
        return selectsubject;
    }

    public WebElement getSelectCategory() {
        return selectCategory;
    }


}
