package com.gs.pages;

import com.gs.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccommodationOverviewPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"content\"]/div/ng-component/gs-rest-grid/gs-grid/div/div/div/div[1]/p-header/button[3]")
    public WebElement removeButton;

    @FindBy(xpath = "//*[@id=\"content\"]/div/ng-component/gs-rest-grid/gs-grid/div/div/div/div[3]/div[1]/input")
    public WebElement searchBox;

    @FindBy(xpath = "//tr//td[2]//span[2][contains(@title, '')]")
    public WebElement hotelName;

    @FindBy(xpath = "//span[contains(@title,'Sample hotel')]")
    public WebElement sampleAccommodation;

    @FindBy(xpath = "(//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt'])[4]")
    public WebElement priceFilterButton;

    /**
     * This method is used to check if prices are ordered
     */
    public void checkPricesInAscendingOrder() {
        List<String> actualSortedPrices = prices();

        List<Integer> expectedSortedPrices = new ArrayList<>();
        for (String prices : actualSortedPrices) {
            expectedSortedPrices.add(Integer.valueOf(prices));
        }

        Collections.sort(expectedSortedPrices);
        Assert.assertEquals(expectedSortedPrices, actualSortedPrices);
    }


    public List<String> prices(){
        List<WebElement> pricesOfElements = Driver.getDriver().findElements(By.xpath("//tr//td[4]//span[2][contains(@title, '')]"));

        List<String> prices = new ArrayList<>();

        for (WebElement pricesOfElement : pricesOfElements) {
           prices.add(pricesOfElement.getText());
        }
        return prices;
    }


}
