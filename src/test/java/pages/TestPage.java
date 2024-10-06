package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

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
}
