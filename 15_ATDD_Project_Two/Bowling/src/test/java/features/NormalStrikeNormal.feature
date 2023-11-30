Feature: Normal Strike Normal

  Scenario Outline: First frame goes normally no strike, no spare
      second frame gets an strike
      third frame goes normally with no bonus

			Given my first frame first roll gives "<FF_FR_PT>" points
			And my frist frame second roll gives "<FF_SR_PT>" points
			When my get second frame first roll "<SF_FR_PNS>" pins
			And my which makes this frame as an strike
			And my third frame first roll i got "<TF_FR_PT>" points
			And my third frame second roll i got "<TF_SR_PT>" points
			Then my first frame i got total of "<FF_T_POINTS>" points
			And my second frame i got total of "<SF_T_POINTS>" points
			And my third frame i got total of "<TF_T_POINTS>" points

    Examples: 
        | FF_FR_PT | FF_SR_PT | SF_FR_PNS | TF_FR_PT | TF_SR_PT | FF_T_POINTS | SF_T_POINTS | TF_T_POINTS |
        |        2 |        4 |        10 |        8 |        1 |           6 |          25 |          34 |
        |        4 |        1 |        10 |        0 |        5 |           5 |          20 |          25 |
        |        6 |        0 |        10 |        6 |        2 |           6 |          24 |          32 |
        |        7 |        2 |        10 |        9 |        0 |           9 |          28 |          37 |
