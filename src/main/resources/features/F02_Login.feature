@smoke
Feature: F02_LogIn | User could use login functionality to use their account

  Scenario Outline: User could logIn with valid email
    When User click on LoginIcon
    And  User enter ValidEmail "<Email>"
    And  User enter ValidPassword "<Password>"
    And  User click on LoginButton
    Then User successfully login to their account
    Examples:
      | Email                 | Password |
      | test88888@example.com | A1234567 |

  Scenario Outline: User could LogIn with Invalid email
    When User click on LoginIcon
    And  User enter InvalidEmail "<Email>"
    And  User enter ValidPassword "<Password>"
    And  User click on LoginButton
    Then User failed login to their account
    Examples:
      | Email             | Password   |
      | wrong@example.com | ahmed@123@ |