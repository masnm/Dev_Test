Feature: Normal Spare Spare Normal

  Scenario Outline: First frame normal
    second frame spare
    third frame spare
    fourth frame normal
    Given first frame first roll gives "<FF_FR_PT>" points
    And frist frame second roll gives "<FF_SR_PT>" points
    When i get second frame first roll "<SF_FR_PNS>" pins
    And i get second frame second roll "<SF_SR_PNS>" pins
    And which makes this frame as an spare
    And i get third frame first roll "<TF_FR_PNS>" pins
    And i get third frame second roll "<TF_SR_PNS>" pins
    And which makes this frame as spare again
    And fourth frame first roll i got "<FRF_FR_PT>" points
    And fourth frame second roll i got "<FRF_SR_PT>" points
    Then first frame i got total of "<FF_T_POINTS>" points
    And second frame i got total of "<SF_T_POINTS>" points
    And third frame i got total of "<TF_T_POINTS>" points
    And fourth frame i got total of "<FRF_T_POINTS>" points

    Examples: 
        | FF_FR_PT | FF_SR_PT | SF_FR_PNS | SF_SR_PNS | TF_FR_PNS | TF_SR_PNS | FRF_FR_PT | FR_SR_PT | FF_T_POINTS | SF_T_POINTS | TF_T_POINTS | FRF_T_POINTS |
        |        2 |        4 |         2 |         8 |         8 |         2 |         1 |        8 |           6 |          18 |          11 |            9 |
        |        4 |        1 |         1 |         9 |         0 |        10 |         2 |        7 |           5 |          10 |          12 |            9 |
        |        6 |        0 |         6 |         4 |         6 |         4 |         3 |        6 |           6 |          16 |          13 |            9 |
        |        7 |        2 |         0 |        10 |         9 |         1 |         4 |        5 |           9 |          19 |          14 |            9 |
