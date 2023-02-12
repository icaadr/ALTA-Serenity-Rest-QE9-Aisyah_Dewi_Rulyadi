Feature: Reqres API Automation Testing QE-9
  @Tugas @GetResource @Positive
  Scenario: Get list resource with valid parameter
    Given Get list resource with valid parameter unknown
    When Send request get list resource
    Then Status code should be 200 OK
    And Validate get List resource json schema