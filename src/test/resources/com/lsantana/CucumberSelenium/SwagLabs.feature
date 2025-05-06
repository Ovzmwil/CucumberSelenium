Feature: Swag Labs Flows

  Scenario: Login invalid user
    Given I go to the login page of Swag Labs
    When I try to login with "<username>" and "<password>"
    Then an error message should open
    
  Examples:
  | username        | password     |
  | locked_out_user | secret_sauce |
  | invalid_user    | secret_sauce |
  | standard_user   | wrong_pass   |
  
  Scenario: Checkout all products
  	Given I go to the login page of Swag Labs
  	And I login with valid credentials
  	And I add all products to the cart
  	And I go to the checkout page
  	And I fill the personal information "<firstName>", "<lastName>", "<postalCode>"
  	Then I check the overview
  	And I click finish button
  	And the checkout is completed
  	And a message informing my purchase is done should be visible
  	
	Examples:
  | username      | password     | firstName | lastName | postalCode |
  | standard_user | secret_sauce | Leandro   | Santana  | 12231000   |
  
  Scenario: Checkout with wrong information
  Given I go to the login page of Swag Labs
	And I login with valid credentials
  And I add all products to the cart
  And I go to the checkout page
	And I fill the personal information "<firstName>", "<lastName>", "<postalCode>"
  Then an error message should open
  
  Examples:
  | username      | password     | firstName | lastName | postalCode |
  | standard_user | secret_sauce |           | Santana  | 12231000   |
  | standard_user | secret_sauce | Leandro   |          | 12231000   |
  | standard_user | secret_sauce | Leandro   | Santana  |            |
  
  Scenario: Logout
  Given I go to the login page of Swag Labs
  And I login with valid credentials
  When I logout
  Then I go back to the login page