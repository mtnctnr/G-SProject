package com.gs.step_definitions;

import com.gs.pages.AccommodationOverviewPage;
import com.gs.pages.AddAccommodationPage;
import com.gs.pages.AirGnsPage;
import com.gs.pages.LogInPage;
import com.gs.utilities.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class AirGnsStepDefs {

    LogInPage loginPage = new LogInPage();
    AirGnsPage airGnsPage = new AirGnsPage();
    AddAccommodationPage addAccommodationPage = new AddAccommodationPage();
    AccommodationOverviewPage accommodationOverviewPage = new AccommodationOverviewPage();
    TestDataGenerator testDataGenerator = new TestDataGenerator();
    ButtonGenerator buttonGenerator = new ButtonGenerator();
    private static String name;

    @Given("user enters username {string} and password {string} in login page")
    public void userEntersUsernameAndPasswordInLoginPage(String userName, String password) {
        loginPage.userName.sendKeys(userName);
        loginPage.password.sendKeys(password);
        loginPage.login.click();
    }

    @When("user clicks add Accommodation button")
    public void user_clicks_add_accommodation_button() {
        BrowserUtils.clickWithJse(airGnsPage.addAccommodationButton);
    }

    @When("user provides {string} to name field")
    public void user_provides_to_name_field(String n) {
        name = testDataGenerator.suffix(n);
        addAccommodationPage.nameField.sendKeys(name);
    }

    @When("user provides {string} to city field")
    public void user_provides_to_city_field(String city) {
        addAccommodationPage.cityField.sendKeys(city);
    }
    @When("user provides {string} to price field")
    public void user_provides_to_price_field(String price) {
        addAccommodationPage.priceField.sendKeys(price);
    }

    @When("user provides {string} to organization field")
    public void user_provides_to_organization_field(String organization) {
        addAccommodationPage.organizationField.sendKeys(organization);
        addAccommodationPage.organizationSelection.click();
    }

    @When("user clicks on {string}")
    public void user_clicks_on(String checkbox) {
        addAccommodationPage.checkBoxes.click();
    }

    @When("user clicks SUBMIT button")
    public void user_clicks_submit_button() {
        addAccommodationPage.submitButton.click();
    }

    @Then("user should add some accommodation information successfully")
    public void user_should_add_some_accommodation_information_successfully(){
        BrowserUtils.waitFor(2);
        String text = addAccommodationPage.elementCreatedMessage.getText();
        Assert.assertEquals("Element has been created", addAccommodationPage.elementCreatedMessage.getText());
        airGnsPage.airGnsButton.click();
        addAccommodationPage.accommodationButton.click();
        addAccommodationPage.verifyAccommodationIsPresentOnTheTable(name);
    }

    @Then("sample hotel should be removed")
    public void SampleHotelShouldBeRemoved() {
        Assert.assertFalse(accommodationOverviewPage.sampleAccommodation.isDisplayed());
    }

    @Then("user should see the invalid message")
    public void userShouldSeeTheInvalidMessage() {
        String expected = "The form is invalid and could not be submitted";
        Assert.assertEquals("Invalid Message", expected, addAccommodationPage.submitInvalidMessage.getText());
    }

    @And("user types {string} in the search box")
    public void userTypesInTheSearchBox(String see) {
        accommodationOverviewPage.searchBox.click();
        accommodationOverviewPage.searchBox.sendKeys(see);
        BrowserUtils.waitFor(2);
    }

    @Then("user gets information of {string}")
    public void userGetsInformationOfHausAmSee(String expectedHotelName) {
        String actualText = accommodationOverviewPage.hotelName.getText();
        Assert.assertEquals(expectedHotelName, actualText);
    }

    @And("sample data is added")
    public void sampleDataIsAdded() {
        user_clicks_add_accommodation_button();
        user_provides_to_name_field("Sample hotel");
        user_provides_to_city_field("Hamburg");
        user_provides_to_price_field("100");
        user_provides_to_organization_field("AirGnS Trialwork Testing");
        user_clicks_on("Available");
        user_clicks_submit_button();
    }

    @Then("user should not see a successfully created message")
    public void user_should_not_see_a_successfully_created_message() {
        Assert.assertFalse(addAccommodationPage.elementCreatedMessage.isDisplayed());
    }

    @Then("user gets information which includes {string}")
    public void user_gets_information_which_includes(String string) {
        addAccommodationPage.checkSearchMethod(string);
    }

    @Then("user should see prices in ascending order")
    public void userShouldSeePricesInAscendingOrder() {
        accommodationOverviewPage.checkPricesInAscendingOrder();
    }

    @When("user clicks the {string}")
    public void userClicksTheButton(String buttonName) {
        buttonGenerator.clickButton(buttonName);
    }

    @And("user provide {int} characters in {string} field")
    public void userProvideOverCharactersInField(int numberOfCharacter, String title) {
        addAccommodationPage.requiredTitle(title).sendKeys(testDataGenerator.generateRandomText(numberOfCharacter));
        BrowserUtils.waitFor(2);
    }

    @Then("user should see a warning message for {string} field")
    public void userShouldSeeWarningMessage(String requiredField) {
        Assert.assertTrue(addAccommodationPage.warningIcons(requiredField).isDisplayed());
    }

    @Given("user is on the {string} page")
    public void userIsOnThePage(String page) {
        String url=ConfigurationReader.getProperty(page);
        Driver.getDriver().get(url);
    }

    @And("user hover over language symbol")
    public void userHoverOverLanguageSymbol() {
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(airGnsPage.earthIcon);
    }

    @Then("user should see that {string} is changed")
    public void userShouldSeeThatIsChanged(String language) {
        airGnsPage.checkLanguage(language);
    }
}




