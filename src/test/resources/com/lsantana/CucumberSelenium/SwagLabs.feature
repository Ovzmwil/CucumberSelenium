Feature: Swag Labs Flows

  Scenario: Login invalid user
    Given I go to the login page of Swag Labs
    When I fill the field username "<username>"
    And I fill the field password "<password>"
    And I click login button
    Then an error message should open
    
  Examples:
  | username        | password     |
  | locked_out_user | secret_sauce |
  
  Scenario: Checkout all products
  	Given I go to the login page of Swag Labs
  	And I fill the field username "<username>"
  	And I fill the field password "<password>"
  	And I click login button
  	And I add all products to the cart
  	And I go to the checkout page
  	And I click checkout button
  	And I fill the field firstName "<firstName>"
  	And I fill the field lastName "<lastName>"
  	And I fill the field postalCode "<postalCode>"
  	And I click continue button
  	And I click finish button
  	Then the checkout is completed
  	And a message informing my purchase is done should be visible
  	
	Examples:
  | username      | password     | firstName | lastName | postalCode |
  | standard_user | secret_sauce | Leandro   | Santana  | 12231000   |
  	