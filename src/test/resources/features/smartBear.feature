
Feature:Smartbear login feature verifications
  #@smartbearLogin
  #Feature: Smartbear login feature verifications
  #
  #  Agile Story: When user is on the login page of SmartBear app user should
  #  be able to login using correct test data
  #  A/C:
  #  1- Only authenticated user should be able to login
  #  Link: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
  #  Authenticated test data:
  #  Username: Tester
  #  Password: test
  #  2- User should see "Welcome, Tester!" displayed when logged in.

  @smartBear
  Scenario:login feature verifications
    Given user is on the login page
    When user should be able to login
    And  user should able to click login
    Then User should be logged in and be able to verify Welcome text is displayed


    @smartBearNegative
    Scenario: When user enters correct username and incorrect password user should see error message
      When User is on SmartBear login page
      And User enters correct username
      And User enters incorrect password
      And User clicks to login button
      Then User should see the error message displayed on the page
