@smoke
Feature: F08_Wishlist | Verify wishlist button is working properly

  Scenario: Verify that product has been added to wishlist
    When User clicks on wishlist button on HTC product
    Then Verify that success message will be displayed and color of wishlist

  Scenario: Verify that quantity of wishlist increase after adding a product
    When  User clicks on wishlist button on HTC product
    And   User clicks on wishlist icon on the top of the page
    Then  Verify that quantity value is increased
