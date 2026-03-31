Feature: Checkout functionality

  Scenario: Successful checkout
    Given user is logged in
    When user adds product to cart
    And user clicks checkout
    And user enters checkout information
    Then user should complete the order