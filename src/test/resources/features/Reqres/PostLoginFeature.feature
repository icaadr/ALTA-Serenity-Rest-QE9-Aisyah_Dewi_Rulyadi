Feature: Reqres API Automation Testing QE-9 Post Login
  @Tugas @PostLogin @Positive
  Scenario: Post login user with json
    Given Post login user with valid json
    When Send request post login user
    Then Status code should be 200 OK
    And Response body token should be "QpwL5tke4Pnpja7X4"
    And Validate post login user json schema

  @Tugas @PostLogin @Negative
  Scenario: Post login user with invalid json
    Given Post login user with invalid json
    When Send request post login user
    Then Status code should be 400 Bad Request
    And Response error body should be "user not found"
    And Validate post login user invalid json schema

  @Tugas @PostLogin @Negative
  Scenario: Post login user with null email
    Given Post login user with null email
    When Send request post login user
    Then Status code should be 400 Bad Request
    And Response null email error body should be "Missing email or username"
    And Validate post login user null email json schema

  @Tugas @PostLogin @Negative
  Scenario: Post login user with null password
    Given Post login user with null email
    When Send request post login user
    Then Status code should be 400 Bad Request
    And Response null password error body should be "Missing password"
    And Validate post login user null password json schema
