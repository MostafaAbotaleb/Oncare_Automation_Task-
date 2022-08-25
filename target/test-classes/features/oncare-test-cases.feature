Feature: Buy added item in the cart

  Scenario: Verify the entire purchase order
    Given open sign in page
    And the correct Url is loaded
    And create a new account
    And the account page is loaded
    And open the dresses category
    And select a dress
    And add to the cart
    And proceed to checkout
    And choose the payment
    When confirm the order
    Then the order request is completed
    And the same order placed in the history order page

