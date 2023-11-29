Feature: First frame has an strike ans second frame is normal game

    Scenario Outline:
        Given First frame get an strike as a result
        When second frame first roll get "<FRScore>" points
        And second frame second roll get "<SRScore>" points
        Then first frame get a total of "<firstFrameScore>" points
        And second frame get a total of "<secondFrameScore>" points
        
        Examples:
            | FRScore | SRScore | firstFrameScore | secondFrameScore |
            |       4 |       2 |              16 |               22 |
            |       1 |       8 |              19 |               28 |
            |       3 |       3 |              16 |               22 |
            |       5 |       2 |              17 |               24 |
            |       6 |       1 |              17 |               24 |
        