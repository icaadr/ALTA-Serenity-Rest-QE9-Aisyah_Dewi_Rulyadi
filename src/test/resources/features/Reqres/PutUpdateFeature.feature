Feature: Reqres API Automation Testing QE-9
  @Latihan @Put
  Scenario Outline: Put update user with json and valid parameter id
    Given Update user with valid json and parameter id <id>
    When Send request put update users
    Then Status code should be 200 OK
    And Response body name should be "AisyahDewi" and job is "QA Engineer"
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |

  @Tugas @PutUpdate @Positive
  Scenario Outline: Put update user with json and valid parameter id
    Given Update user with valid json and parameter id <id>
    When Send request put update users
    Then Status code should be 200 OK
    And Response body name should be "AisyahDewi" and job is "QA Engineer"
    And Validate put update json scheme
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |


  @Tugas @PutUpdate @Negative
  Scenario Outline: Put update user with valid json and invalid parameter id
    Given Update user with valid json body and invalid parameter id "<id>"
    When Send request put update users
    Then Status code should be 404 Not Found
    Examples:
      | id  |
      | @#4 |
      | avg |

  @Tugas @PutUpdate @Negative
  Scenario: Put update user with invalid json and valid id
    Given Put update user with invalid json and valid id 2
    When Send request put update users
    Then Status code should be 400 Bad Request
    And Response update error body should be "Note: Only defined users succeed update"

  @Tugas @PutUpdate @Negative
  Scenario: Put update user with null name and valid id
    Given Put update user with null name and valid id 2
    When Send request put update users
    Then Status code should be 400 Bad Request
    And Response update null name error body should be "Missing name"

  @Tugas @PutUpdate @Negative
  Scenario: Put update user with null job and valid id
    Given Put update user with null job and valid id 2
    When Send request put update users
    Then Status code should be 400 Bad Request
    And Response update with null job error body should be "Missing job"
