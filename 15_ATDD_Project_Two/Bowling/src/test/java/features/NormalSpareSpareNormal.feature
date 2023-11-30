Feature: Normal Spare Spare Normal

  Scenario Outline: First frame normal
    second frame spare
    third frame spare
    fourth frame normal
    Given first frame first roll gives "<FF_FR_PT>" pointss
    And frist frame second roll gives "<FF_SR_PT>" pointss
    When i get second frame first roll "<SF_FR_PNS>" pinss
    And i get second frame second roll "<SF_SR_PNS>" pinss
    And which makes this frame as an sparee
    And i get third frame first roll "<TF_FR_PNS>" pinss
    And i get third frame second roll "<TF_SR_PNS>" pinss
    And which makes this frame as spare againn
    And fourth frame first roll i got "<FRF_FR_PT>" pointss
    And fourth frame second roll i got "<FRF_SR_PT>" pointss
    Then first frame i got total of "<FF_T_POINTS>" pointss
    And second frame i got total of "<SF_T_POINTS>" pointss
    And third frame i got total of "<TF_T_POINTS>" pointss
    And fourth frame i got total of "<FRF_T_POINTS>" pointss

    Examples: 
        | FF_FR_PT | FF_SR_PT | SF_FR_PNS | SF_SR_PNS | TF_FR_PNS | TF_SR_PNS | FRF_FR_PT | FRF_SR_PT | FF_T_POINTS | SF_T_POINTS | TF_T_POINTS | FRF_T_POINTS |
        |        2 |        4 |         2 |         8 |         8 |         2 |         1 |         8 |           6 |          24 |          35 |           44 |
        |        4 |        1 |         1 |         9 |         0 |        10 |         2 |         7 |           5 |          15 |          27 |           36 |
        |        6 |        0 |         6 |         4 |         6 |         4 |         3 |         6 |           6 |          22 |          35 |           44 |
        |        7 |        2 |         0 |        10 |         9 |         1 |         4 |         5 |           9 |          28 |          42 |           51 |
