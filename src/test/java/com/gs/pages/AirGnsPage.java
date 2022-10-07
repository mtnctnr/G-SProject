package com.gs.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AirGnsPage extends BasePage {
    AddAccommodationPage addAccommodationPage=new AddAccommodationPage();

    @FindBy(xpath = "(//a[@id=\"navigation_testingTrialwork\"])[2]")
    public WebElement airGnsButton;

    @FindBy(xpath = "(//a[@href=\"/accomodation/accomodation/add\"])[2]")
    public WebElement addAccommodationButton;

    @FindBy(xpath = "(//i[@class='icon icon-earth2'])[2]")
    public WebElement earthIcon;

    @FindBy(xpath = "//a[.='en']")
    public WebElement englishButton;

    @FindBy(xpath = "//a[.='de']")
    public WebElement germanButton;

    /**
     * This method is used to check language alteration
     * @param language
     */
    public void checkLanguage(String language) {
        switch (language){
            case"EN":
                Assert.assertEquals("General",addAccommodationPage.contentHeaderText.getText());
               break;
            case"DE":
                Assert.assertEquals("Allgemein",addAccommodationPage.contentHeaderText.getText());
                break;
        }
    }
}
