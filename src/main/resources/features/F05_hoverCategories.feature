@smoke
Feature: F05_HoverCategories | Verify Hover functionality

  Scenario: Verify hover and select sub-category random of three main category
    When User select random from three main category
    And  User hover and select random from sub main categories
    Then User should redirect to new sub-category page
