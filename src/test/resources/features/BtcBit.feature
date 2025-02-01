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
    Then user should ba able to land on profile page

    @BtcBitPositiveLogin
   Scenario: User logins successfully
      Given user is on the main page
      When user should be able to click Login button
      And user should be able to input email address
      And user should be able to input password
      And user should be able to click Sign in button
      Then user should land on user profile page

      @BtcBitNegativeLogin
      Scenario: Invalid login scenario
        Given user is on the main page
        When user should be able to click Login button
        And user should input incorrect email address
        And user should input incorrect password
        And user should be able to click Sing in button
        Then user should see the error message displayed on the page

        @CheckingDataOnTheContactPage

        Scenario: Verify the presence and accuracy of elements on the Contacts page
          Given user is on the main page
          When user should be able to click Login button
          And user should be able to input email address
          And user should be able to input password
          And user should be able to click Sign in button
          When  user should land on user profile page

          Then user  should see the phone number displayed correctly
          And user  should see the email address displayed correctly
          And user should see the address displayed correctly
          And user  should see the email link working
          And user  should see the map link working






