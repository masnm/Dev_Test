Feature: Checkout system for purchasing items
	  
  
  Scenario Outline: As a user, I can purchase items at a certain quantity, 
  given their prices, and discounts can be applied
    Given I by items "<item_name>"
    And At a certain price tag "<item_price>"
    When I buy quanty "<quantity>"
    And the price is "<special_discount>"
    Then The cost is "<actual_cost>"
    
    Examples:
		| item_name | item_price | quantity | special_discount | actual_cost |
    |         A |         50 |       30 |        3 for 130 |        1300 |
    |         B |         30 |       60 |         2 for 45 |        1350 |
    |         C |         20 |       10 |                  |         200 |
    |         D |         15 |        5 |                  |          75 |
