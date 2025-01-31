Feature: BTCBIT client registration on the website

  @btcbitRegistration
  Scenario: Client registration
    Given user is on the main page
    When user should able to click the "Get Started button"
    And user should be able type the email
    And user should be able type the password
    And user should be able confirm the password
    And user should able to to tick to agreement term and condition of website checkbox
    Then user should able to click "Sign up" button



