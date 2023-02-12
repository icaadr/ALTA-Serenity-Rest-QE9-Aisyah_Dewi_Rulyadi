Feature: Reqres API Automation Testing QE-9
  @Tugas @PostRegisters @Positive
  Scenario: Post register user with json
    Given Post register user with valid json
    When Send request post register user
    Then Status code should be 200 OK
    And Response body id should be 4 and token should be "QpwL5tke4Pnpja7X4"
    And Validate register using json scheme

  @Tugas @PostRegisters @Negative
  Scenario: Post register user with invalid json
    Given Post register user with invalid json
    When Send request post register user
    Then Status code should be 400 Bad Request
    And Response register error body should be "Note: Only defined users succeed registration"
    And Validate post register user invalid json schema

  @Tugas @PostRegisters @Negative
  Scenario: Post register user with null email
    Given Post register user with null email
    When Send request post register user
    Then Status code should be 400 Bad Request
    And Response register null email error body should be "Missing email or username"
    And Validate post register user null email json schema

  @Tugas @PostRegisters @Negative
  Scenario: Post register user with null password
    Given Post register user with null password
    When Send request post register user
    Then Status code should be 400 Bad Request
    And Response register null password error body should be "Missing password"
    And Validate post register user null password json schema