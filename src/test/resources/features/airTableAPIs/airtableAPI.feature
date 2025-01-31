Feature: Airtable API Tests

  @api

  Scenario: Verify status code for get endpoint
    When use call a GET endpoint
    Then user will receive status "200"


    @postApi
    Scenario: Verify a status code for get a single record endpoint
      When  user call a GET single endpoint
      Then user will receive status "200"
      And user verify the first name

      @apiPostMethod
      Scenario: Verify Post Endpoint
        When a user creates a record
        Then user will receive status "200"
        When  a user is saving the recordID
        And a user updates email
        Then user will receive status "200"
        When  user delete the recordID
        Then user will receive status "200"

        @apiNegativeTestExample
        Scenario: Create a request with a wrong request body
          When a user tries to create a record with invalid payload
          Then user will receive status: 422


