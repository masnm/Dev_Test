Feature: playing a full game
    Scenario Outline: doing roll untill the game is over
    		Given i just started the game
    		When i do roll untill the game is over
    		Then i make sure nothing goes bad