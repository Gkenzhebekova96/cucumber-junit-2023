@RunWithParameters

Feature: Wikipedia search functionality

  @wiki1
  Scenario: Wikipedia search functionality
    Given user click on wikipedia page
    When User type "Abu Dhabi " in the wiki search box
    And User click search button
    Then User see "Abu Dhabi " in the wiki page title