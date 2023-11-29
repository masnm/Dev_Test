Feature: Normal Strike Strike Normal

  Scenario Outline: First frame goes normally no strike, no spare
      second grame gets an strike
      third frame get and strike again
      fourth frame goes normally with no bonus

			Given first frame first roll gives "<FF_FR_PT>" points
			And frist frame second roll gives "<FF_SR_PT>" points
			When i get second frame first roll "<SF_FR_PNS>" pins
			And which makes this frame as an strike
			And i get third frame first roll "<TF_FR_PNS>" pins
			And which makes this frame as an strike again
			And fourth frame first roll i got "<FRF_FR_PT>" points
			And fourth frame second roll i got "<FRF_SR_PT>" points
			Then first frame i got total of "<FF_T_POINTS>" points
			And second frame i got total of "<SF_T_POINTS>" points
			And third frame i got total of "<TF_T_POINTS>" points
			And fourth frame i got total of "<FRF_T_POINTS>" points

    Examples: 
        | FF_FR_PT | FF_SR_PT | SF_FR_PNS | TF_FR_PNS | FRF_FR_PT | FRF_SR_PT | FF_T_POINTS | SF_T_POINTS | TF_T_POINTS | FRF_T_POINTS |
        |        2 |        4 |        10 |        10 |         3 |         6 |           6 |          23 |          19 |            9 |
        |        4 |        1 |        10 |        10 |         4 |         2 |           5 |          24 |          16 |            6 |
        |        6 |        0 |        10 |        10 |         5 |         1 |           6 |          25 |          16 |            6 |
        |        7 |        2 |        10 |        10 |         6 |         2 |           9 |          26 |          18 |            8 |

