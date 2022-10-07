Feature:AirGns

  Background:
    Given user is on the "login" page
    And user enters username "TU" and password "Test123?" in login page
    And user clicks the "EN"
    When user clicks the "airGnsButton"

  Scenario Outline:Accommodations should be added
    And user clicks the "addAccommodationButton"
    And user provides "<Name>" to name field
    And user provides "<City>" to city field
    And user provides "<Price>" to price field
    And user provides "<Organization>" to organization field
    And user clicks on "<checkbox>"
    And user clicks the "submitButton"
    Then user should add some accommodation information successfully
    Examples:
      | Name           | City    | Price | Organization             | checkbox  |
      | Villa Quintana | Kunzing | 80    | AirGnS Trialwork Testing | Available |

  Scenario: Negative test case add function without filling out required fields
    And user clicks the "addAccommodationButton"
    And user clicks the "submitButton"
    Then user should see the invalid message

  Scenario: Remove button should be clickable
    And sample data is added
    And user clicks the "accommodationButton"
    And user clicks the "sampleAccommodation"
    And user clicks the "removeButton"
    Then sample hotel should be removed

  Scenario Outline: Search button should filter through letters
    And user clicks the "accommodationButton"
    And user types "<HotelNames>" in the search box
    Then user gets information of "<HotelNames>"
    Examples:
      | HotelNames  |
      | Haus am See |

  Scenario: Search button should filter through numbers
    And user clicks the "accommodationButton"
    And user types "500" in the search box
    Then user gets information which includes "500"

  Scenario: Price input box should not accept letters
    And user clicks the "addAccommodationButton"
    And user provides "Name" to name field
    And user provides "City" to city field
    And user provides "letters" to price field
    And user provides "AirGnS Trialwork Testing" to organization field
    And user clicks the "submitButton"
    Then user should not see a successfully created message

  Scenario: Prices should be ordered
    And user clicks the "accommodationButton"
    And user clicks the "priceFilterButton"
    Then user should see prices in ascending order

  Scenario: Provide over 255 characters in Price field and get warning message
    And user clicks the "addAccommodationButton"
    And user provide 256 characters in "price" field
    Then user should see a warning message for "price" field

  Scenario Outline:Language should be changeable
    And user hover over language symbol
    And user clicks the "<language>"
    Then user should see that "language" is changed
    Examples:
      | language |
      | EN       |
      | DE       |








