package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreatInformation {

    public CreatInformation(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//*[@class=\"block focus:outline-none\"]/button")
    private WebElement creatSomeThing;

    @FindBy(xpath = "//*[@class=\"undefined undefined\"]/../span[1]/button/img")
    private WebElement creatQuestion;

    @FindBy(xpath = "//*[@class=\"undefined undefined\"]/../span[2]/button/img")
    private WebElement studyGuide;

    @FindBy(xpath = "//*[@role=\"dialog\"]/div/div[2]/div[1]/textarea")
    //*[@id="root"]/div/div[4]/div/div[2]
    //*[@id="root"]/div/div[4]/div/div[2]/div/div[2]/div[1]/textarea
    private WebElement textQuestion;

    @FindBy(xpath = "//*[@role=\"dialog\"]/div/div[1]/button[2]")
    private WebElement submitQuestion;

    @FindBy(xpath = "//*[@id=\"question-title\"]")
    private WebElement answer;

    @FindBy(xpath = "//*[@role=\"dialog\"]/div/div[2]/div/div[2]/button/span\n")
    private WebElement clickForAnswer;

    @FindBy(xpath = "//*[@class=\"p-4 bg-white md:rounded shadow-cardGlow\"]/div[3]/textarea")
    private WebElement addATitle;

    @FindBy(xpath = "//*[@class=\"p-4 bg-white md:rounded shadow-cardGlow\"]/div[5]/textarea")
    private WebElement addADescription;

    @FindBy(xpath = "//*[@class=\" relative flex flex-row whitespace-nowrap space-x-2 no-scrollbar \"]/div[1]/input")
    private WebElement addTags1;

    @FindBy(xpath = "//*[@class=\" relative flex flex-row whitespace-nowrap space-x-2 no-scrollbar \"]/div[2]/input")
    private WebElement addTags2;

    @FindBy(xpath = "//*[@class=\" relative flex flex-row whitespace-nowrap space-x-2 no-scrollbar \"]/div[3]/input")
    private WebElement addTags3;

    @FindBy(xpath = "//*[@id=\"editGuides\"]/div/div[1]/div[1]")

    private WebElement addTerm;

    @FindBy(xpath = "//*[@id=\"editGuides\"]/div/div[2]/div[1]")
    private WebElement addDefinition;

    @FindBy(xpath = "//*[@class=\"p-4 mt-4 bg-white md:rounded shadow-cardGlow\"]/div[2]/button[1]")
    private WebElement addNewCard;
    @FindBy(xpath = "//*[@id=\"editGuides\"]/../../div[2]/div/div/div[1]/div[1]")
    private WebElement addTerm1;

    @FindBy(xpath = "//*[@id=\"editGuides\"]/../../div[2]/div/div/div[2]/div[1]")
    private WebElement addDefinition1;

    @FindBy(xpath = "//*[text()='What color are the socks!!!!!']")
    private WebElement textGuide;

    @FindBy(xpath = "//*[@id=\"createButton\"]")
    private WebElement creatGuide;


    public WebElement getClickForAnswer() {
        return clickForAnswer;
    }

    public WebElement getTextGuide() {
        return textGuide;
    }
    public WebElement getCreatGuide() {
        return creatGuide;
    }
    public WebElement getAddTerm1() {
        return addTerm1;
    }
    public WebElement getAddDefinition1() {
        return addDefinition1;
    }
    public WebElement getAddNewCard() {
        return addNewCard;
    }
    public WebElement getAddTerm() {
        return addTerm;
    }
    public WebElement getAddDefinition() {
        return addDefinition;
    }

    public WebElement getAddTags1() {
        return addTags1;
    }
    public WebElement getAddTags2() {
        return addTags2;
    }
    public WebElement getAddTags3() {
        return addTags3;
    }

    public WebElement getAddATitle() {
        return addATitle;
    }
    public WebElement getAddADescription() {
        return addADescription;
    }

    public WebElement getCreatSomeThing() {
        return creatSomeThing;
    }
    public WebElement getAnswer() {
        return answer;
    }
    public WebElement getSubmitQuestion() {
        return submitQuestion;
    }
    public WebElement getTextQuestion(){
        return textQuestion;
    }

    public WebElement getCreatQuestion() {
        return creatQuestion;
    }
    public WebElement getStudyGuide() {
        return studyGuide;
    }
}
