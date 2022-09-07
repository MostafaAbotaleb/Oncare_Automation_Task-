Feature: Buy added item in the cart

  Scenario: Verify the entire purchase order
    Given open sign in page
    And the correct Url is loaded
    And using random email "Mostafa1010@yahoo.com0101" to create a new account
    And create a new account
      | name              | Mostafa                |
      | lastname          | Abotaleb               |
      | password          | 123456                 |
      | company           | ONCARE                 |
      | address           | 101 Manhattan New Yourk|
      | city              | Manhattan              |
      | postcode          | 12913                  |
      | mobile            | 010123456789           |
      | addressalias      | in Manhattan           |
    And the account page is loaded
    And open the dresses category
    And select a dress name "Printed Summer Dress"
    And add to the cart
    And proceed to checkout
    And choose the payment
    When confirm the order
    Then the order request is completed
    And the same order placed in the history order page

