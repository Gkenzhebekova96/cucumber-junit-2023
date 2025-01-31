Feature: Verify created record using API call
  @hybridTest

  Scenario:Verify created record using API call
    Given user is logs in the airtable account
    When user selects a base
    And adds a new record
    Then will verify record was saved, using api call

