package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class TestPage {
//    This my TestCenter page class
//    All objects in TestCenter page will go here
//    Way1: Locating the element using FUNCTION
//    public SelenideElement username(){
//        return $(By.id("exampleInputEmail1"));
//  }


//    Way2: Alternatively, we can locate the element and store it in SelenideElement
    public SelenideElement username = $(By.id("exampleInputEmail1"));
    public SelenideElement password = $(By.id("exampleInputPassword1"));
    public SelenideElement submitButton = $(By.xpath("//button[@type='submit']"));
    public SelenideElement logOutLink = $(By.partialLinkText("Logout"));

//    LOCATING CHECKBOXES
    public SelenideElement checkbox1 = $(By.id("box1"));
    public SelenideElement checkbox2 = $(By.id("box2"));

//     LOCATING RADIOS
    public SelenideElement red = $(By.id("red"));
    public SelenideElement yellow = $(By.id("yellow"));
    public SelenideElement football = $(By.id("football"));

// LOCATING DROPDOWN ELEMENTS

    public SelenideElement year = $(By.id("year"));
    public SelenideElement month = $(By.id("month"));
    public SelenideElement day = $(By.id("day"));
    public ElementsCollection allStates = $$(By.xpath("//select[@id='state']//option"));

//  LOCATING ALERT ELEMENTS

    public SelenideElement jsPromptButton = $(By.xpath("//button[@onclick='jsAlert()']"));
    public SelenideElement result = $(By.id("result"));

//  LOCATING IFRAMES
    public SelenideElement pageHeader = $(By.xpath("//h3"));
    public SelenideElement backToTechpro = $(By.xpath("//a[@type='button']"));

//  ACTIONS
    public SelenideElement source = $(By.id("draggable"));

    public SelenideElement target =$(By.id("droppable"));

//  EXPLICIT WAIT
    public SelenideElement startButton = $(By.xpath("//div[@id='start']//button"));

    public SelenideElement helloWorld = $(By.xpath("//div[@id='finish']//h4"));

//  SCREENSHOTS

    public SelenideElement dialogueIcon = $(By.xpath("//*[@id='zsiq_agtpic']"));

}
