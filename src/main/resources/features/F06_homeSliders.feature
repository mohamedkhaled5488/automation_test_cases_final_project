@smoke
Feature: F06_HomeSliders| Verify HomeSliders are clickable on home page

  Scenario: Verify that First slider "Galaxy" and navigate into the product
    When User select on First Slider home page
    And  User click on First selected slider
    Then User should direct into First product link

  Scenario: Verify that Second slider "Iphone" and navigate into the product
    When User select on Second Slider home page
    And  User click on Second selected slider
    Then User should direct into Second product link






