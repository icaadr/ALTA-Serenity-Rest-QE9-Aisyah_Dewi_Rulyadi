Feature: Reqres API Automation Testing QE-9 Get List
  @Latihan @Get
  Scenario Outline: Get list users with valid parameter page
    Given Get list users with valid parameter page <page>
    When Send request get list users
    Then Status code should be 200 OK
    And Response body page should be <page>
    And Validate get List user json schema
    Examples:
      |page|
      |1   |
      |2   |