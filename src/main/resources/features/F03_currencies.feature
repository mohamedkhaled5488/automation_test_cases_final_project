@smoke
Feature: F03_Currencies | Verify currencies changes to the products in the home page

  Background: Home Page is opened

  Scenario Outline: Verify currencies is shown on the products displayed in Home page
    When  User select currency "<currency>"
    Then The products displayed in home page with prices shown as "<Symbol>" of currency
    Examples:
      | currency  | Symbol |
      | US Dollar | $      |
      | Euro      | €      |

