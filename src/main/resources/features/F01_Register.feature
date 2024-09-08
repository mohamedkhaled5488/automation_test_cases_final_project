@smoke
Feature: F01_Register | Users could register with new accounts

  Scenario Outline: User could register with valid data successfully
    When User click on RegisterIcon
    And  User select Gender
    And  User enter FirstName "<First>"
    And  User enter LastName  "<Last>"
    And  User select DateOfBirth
    And  User enter Email
    And  User enter CompanyName
    And  User enter Password & ConfirmationPassword
    And  User click on RegisterButton
    Then User create new account successfully
    Examples:
      | First | Last |
      | Ah    | Mo   |
