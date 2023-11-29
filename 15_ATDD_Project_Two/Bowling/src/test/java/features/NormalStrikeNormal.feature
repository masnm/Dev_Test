Feature: Normal Strike Normal

  Scenario Outline: First frame goes normally no strike, no spare
      second frame gets an strike
      third frame goes normally with no bonus

			Given first frame first roll gives "<FF_FR_PT>" points
			And frist frame second roll gives "<FF_SR_PT>" points
			When i get second frame first roll "<SF_FR_PNS>" pins
			And which makes this frame as an strike
			And third frame first roll i got "<TF_FR_PT>" points
			And third frame second roll i got "<TF_SR_PT>" points
			Then first frame i got total of "<FF_T_POINTS>" points
			And second frame i got total of "<SF_T_POINTS>" points
			And third frame i got total of "<TF_T_POINTS>" points

    Examples: 
        | FF_FR_PT | FF_SR_PT | SF_FR_PNS | TF_FR_PT | TF_SR_PT | FF_T_POINTS | SF_T_POINTS | TF_T_POINTS |
        |        2 |        4 |        10 |        8 |        1 |           6 |          19 |           9 |
        |        4 |        1 |        10 |        0 |        5 |           5 |          15 |           5 |
        |        6 |        0 |        10 |        6 |        2 |           6 |          18 |           8 |
        |        7 |        2 |        10 |        9 |        0 |           9 |          19 |           9 |
