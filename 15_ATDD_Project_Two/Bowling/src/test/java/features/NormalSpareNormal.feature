Feature: Normal Spare Normal

  Scenario Outline: First frame normal
    second frame spare
    third frame normal
    Given first frame first roll gives "<FF_FR_PT>" points
    And frist frame second roll gives "<FF_SR_PT>" points
    When i get second frame first roll "<SF_FR_PNS>" pins
    And i get second frame second roll "<SF_SR_PNS>" pins
    And which makes this frame as an spare
    And third frame first roll i got "<TF_FR_PT>" points
    And third frame second roll i got "<TF_SR_PT>" points
    Then first frame i got total of "<FF_T_POINTS>" points
    And second frame i got total of "<SF_T_POINTS>" points
    And third frame i got total of "<TF_T_POINTS>" points

    Examples: 
        | FF_FR_PT | FF_SR_PT | SF_FR_PNS | SF_SR_PNS | TF_FR_PT | TF_SR_PT | FF_T_POINTS | SF_T_POINTS | TF_T_POINTS |
        |        2 |        4 |         2 |         8 |        8 |        1 |           6 |          18 |           9 |
        |        4 |        1 |         1 |         9 |        0 |        5 |           5 |          10 |           5 |
        |        6 |        0 |         6 |         4 |        6 |        2 |           6 |          16 |           8 |
        |        7 |        2 |         0 |        10 |        9 |        0 |           9 |          19 |           9 |