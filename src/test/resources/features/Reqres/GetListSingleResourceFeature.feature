Feature: Reqres API Automation Testing QE-9
  @Tugas @GetResource @Positive
  Scenario Outline: Get list single resource with valid parameter
    Given Get list single resource with valid parameter <id>
    When Send request get list single resource
    Then Status code should be 200 OK
    And Validate get List single resource json schema
  Examples:
    | id |
    | 2  |
    | 4  |

  @Tugas @GetResource @Negative
  Scenario Outline: Get list single resource with invalid parameter
    Given Get list single resource with invalid parameter "<id>"
    When Send request get list single resource
    Then Status code should be 404 Not Found
    And Validate get List single resource not found json schema
    Examples:
      | id     |
      | abcdde |
      | 793#42 |