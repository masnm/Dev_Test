Feature: First frame has an strike ans second frame is normal game

    Scenario Outline:
        Given First frame get an strike as a result
        When first frame first roll get "<FRScore>" points
        And second frame first roll get "<SRScore1>" pointss
        And second frame second roll get "<SRScore2>" pointss
        Then first frame get a total of "<firstFrameScore>" points
        And second frame get a total of "<secondFrameScore>" points
        
        Examples:
            | FRScore | SRScore1 | SRScore2 | firstFrameScore | secondFrameScore |
            |      10 |        2 |        3 |              15 |               20 |
            |      10 |        8 |        1 |              19 |               28 |
            |      10 |        3 |        4 |              17 |               24 |
            |      10 |        2 |        6 |              18 |               26 |
            |      10 |        1 |        8 |              19 |               28 |
        