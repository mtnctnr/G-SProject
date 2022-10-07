package com.gs.pages;

import com.gs.utilities.BrowserUtils;
import com.gs.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddAccommodationPage extends BasePage {

    @FindBy(id = "name")
    public WebElement nameField;

    @FindBy(id = "city")
    public WebElement cityField;

    @FindBy(id = "price")
    public WebElement priceField;

    @FindBy(id = "OrganizationID")
    public WebElement organizationField;

    @FindBy(className = "p-checkbox-box")
    public WebElement checkBoxes;

    @FindBy(xpath = "//*[@type=\"submit\"]")
    public WebElement submitButton;

    @FindBy(xpath = "//li[@role='option']/span[.='AirGnS Trialwork Testing']")
    public WebElement organizationSelection;

    @FindBy(xpath = "//*[@id=\"navigation_testingTrialwork_subnav\"]/div/div/li[1]/a")
    public WebElement accommodationButton;

    @FindBy(xpath = "//simple-notification/div/div[1]/div[1][.='Element has been created']")
    public WebElement elementCreatedMessage;

    @FindBy(xpath = "/html/body/app-root/div/simple-notifications/div/simple-notification/div/div[1]/div[1]")
    public WebElement submitInvalidMessage;

    @FindBy(xpath = "(//i[@class='icon-warning2 tooltip-icon'])[3]")
    public WebElement warningIconNumberOfCharacters;

    /**
     * This method is used to dynamically locate Name/City/Price field's warning icons
     *
     * @param field
     * @return
     */
    public WebElement warningIcons(String field) {
        int index = 0;
        switch (field) {
            case "name":
                index = 1;
                break;
            case "city":
                index = 2;
                break;
            case "price":
                index = 3;
                break;
        }
        BrowserUtils.waitFor(2);
        return Driver.getDriver().findElement(By.xpath("(//div[@class='ng-star-inserted'])[" + index + "]"));
    }

    @FindBy(xpath = "//button[@class='p-ripple p-element p-paginator-next p-paginator-element p-link']")
    public WebElement nextButton;

    public void verifyAccommodationIsPresentOnTheTable(String name) {
        do {
            System.out.println("\"//span[@title='\" + name + \"']\" = " + "//span[@title='" + name + "']");
            List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//span[@title='" + name + "']"));

            if (elements.size() > 0) {
                System.out.println("found");
                return;
            } else {
                nextButton.click();
            }
        } while (isNextBtnPresent());

    }

    public boolean isNextBtnPresent() {
        return Driver.getDriver().findElements(By.xpath("//button[@class='p-ripple p-element p-paginator-next p-paginator-element p-link']")).size() > 0;
    }

    public WebElement requiredTitle(String title) {
        BrowserUtils.waitFor(2);
        return Driver.getDriver().findElement(By.xpath("//input[@id='" + title + "']"));
    }

    @FindBy(css = "legend.ng-star-inserted")
    public WebElement contentHeaderText;

    /**
     * This method is used to check if Search button search with numbers properly
     * @param string
     */
    public void checkSearchMethod(String string) {
        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//span[contains(@title,'500')]"));
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
        for (WebElement element : elements) {
            String elementValue = element.getText();
            Assert.assertTrue(elementValue.contains(string));
        }
    }
}

