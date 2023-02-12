Feature: Reqres API Automation Testing QE-9
    @Latihan @Delete
    Scenario Outline: Delete user with valid parameter id
    Given Delete user with valid id <id>
    When Send request delete user
    Then Status code should be 204 No Content
    Examples:
        | id  |
        | 1   |
        | 400 |

    @Tugas @Delete @Negative
    Scenario Outline: Delete user with invalid parameter id
        Given Delete user with invalid id "<id>"
        When Send request invalid parameter for delete user
        Then Status code should be 404 Not Found
        Examples:
            | id  |
            | acb |
            | 46@ |
