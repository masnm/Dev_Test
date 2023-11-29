Feature: One frame of the gameplay
    In one frame there are two chance to knock down all the pins
    
    Scenario Outline: This is how a simple frame works
        Given I just started the game
        When I got "<firstChanceScore>" pins knock on the first try
        And I got "<secondChanceScore>" pins knock on the second try
        Then I got a total of "<frameFinalScore>" score in this frame
        
        Examples:
        | firstChanceScore | secondChanceScore | frameFinalScore |
        |                3 |                 2 |               5 |
        |                1 |                 8 |               9 |
        |                2 |                 5 |               7 |
        |                5 |                 4 |               9 |