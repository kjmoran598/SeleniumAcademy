
@tag
Feature: Purchase Order from ECommerce website

Background: 
Given Ecommerce website is opened

  @tag1
  Scenario Outline: Submit an order
    Given User logs in with username <name> and password <password>
    When Add Prouduct <prouductName> to cart
    And Click checkout button
    And Submit order
    Then "Order Complete" message displays on screen
    
    Examples: 
      | name  	| password 		| productName  	|
      | kjmoran | myPassword 	| Boots 			|
     
