Feature: One frame game play as the second frame
    first frame is already done as a simple frame
    
    Scenario Outline: Frist two consutive frame gameplay scenario
        we have some score from the previous fame and the current frame goes on
        Given the previous frame has "<previousFrameScore>" points on the board
        And previous frame is not an strike or an spare
        When I got "<firstChanceScore>" pins knock on the first roll
        And I got "<secondChanceScore>" pins knock on the second roll
        Then I got a total of "<frameFinalScore>" score in this second frame
        
        Examples:
            | previousFrameScore | firstChanceScore | secondChanceScore | frameFinalScore |
            |                  8 |                3 |                 2 |              13 |
            |                  0 |                1 |                 8 |               9 |
            |                  6 |                2 |                 5 |              13 |
            |                  9 |                5 |                 4 |              18 |
