
@tag
Feature: Error Validation
  I want to use this template for my feature file



  @tag2
  Scenario Outline: Title of your scenario outline
  	Given Ecommerce website is opened
    When User logs in with username <name> and password <password>
    Then "Incorrect email and password." message is displayed

    Examples: 
      | name  	| password 		| productName  	|
      | kjmoran | myPassword 	| Boots 			|
