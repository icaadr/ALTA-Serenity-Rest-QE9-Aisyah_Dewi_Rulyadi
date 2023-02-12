Feature: Reqres API Automation Testing QE-9
  @Tugas @GetSingle @Positive
  Scenario Outline: Get single user with valid parameter id
    Given Get single user with valid id <id>
    When Send request get single user
    Then Status code should be 200 OK
    Examples:
      | id |
      | 1  |
      | 12 |

  @Tugas @GetSingle @Negative
  Scenario Outline: Get single user with invalid parameter id
    Given Get single user with invalid id "<id>"
    When Send request get invalid single user
    Then Status code should be 404 Not Found
    Examples:
      | id   |
      | abc  |
      | @34a |
      | 15   |