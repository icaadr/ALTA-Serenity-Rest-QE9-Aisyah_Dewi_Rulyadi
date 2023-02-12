Feature: Reqres API Automation Testing QE-9
  @Latihan @PostCreate
  Scenario: Post create new user with valid json file
    Given Create new user with valid json
    When Send request post create user
    Then Status code should be 201 OK
    And Response body name should be "AisyahDewi" and job is "QA Engineer"