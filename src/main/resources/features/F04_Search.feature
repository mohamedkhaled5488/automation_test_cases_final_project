@smoke
Feature: F04_Search | Verify search functionality is working

  Background: Home Page is Opened

  Scenario Outline: User could search using product name
    When   User enter product name "<ProductName>"
    Then  All products contains "<ProductName>" appear in search
    Examples:
      | ProductName |
      | nike        |
      | laptop      |
     # | book |

  Scenario Outline: User Could search using product SKU
    When   User enter product sku "<ProductSKU>"
    Then  All products contains SKU "<ProductSKU>" appear in search
    Examples:
      | ProductSKU |
      | SCI_FAITH  |
      | APPLE_CAM  |
      | SF_PRO_11  |
