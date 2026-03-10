Feature: Amazon Add To Cart

  Scenario: Add product to cart
    Given user is logged into Amazon
    When user searches products from Excel file
    And user selects the first product
    And user adds the product to cart
    Then product should be added to cart
