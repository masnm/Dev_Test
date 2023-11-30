Feature: Normal Strike Strike Normal

  Scenario Outline: First frame goes normally no strike, no spare
      second grame gets an strike
      third frame get and strike again
      fourth frame goes normally with no bonus

			Given my first frame first roll gives "<FF_FR_PT>" pointss
			And my frist frame second roll gives "<FF_SR_PT>" pointss
			When my get second frame first roll "<SF_FR_PNS>" pinss
			And my which makes this frame as an strikee
			And my get third frame first roll "<TF_FR_PNS>" pinss
			And my which makes this frame as an strike againn
			And my fourth frame first roll i got "<FRF_FR_PT>" pointss
			And my fourth frame second roll i got "<FRF_SR_PT>" pointss
			Then my first frame i got total of "<FF_T_POINTS>" pointss
			And my second frame i got total of "<SF_T_POINTS>" pointss
			And my third frame i got total of "<TF_T_POINTS>" pointss
			And my fourth frame i got total of "<FRF_T_POINTS>" pointss

    Examples: 
        | FF_FR_PT | FF_SR_PT | SF_FR_PNS | TF_FR_PNS | FRF_FR_PT | FRF_SR_PT | FF_T_POINTS | SF_T_POINTS | TF_T_POINTS | FRF_T_POINTS |
        |        2 |        4 |        10 |        10 |         3 |         6 |           6 |          29 |          48 |           57 |
        |        4 |        1 |        10 |        10 |         4 |         2 |           5 |          29 |          45 |           51 |
        |        6 |        0 |        10 |        10 |         5 |         1 |           6 |          31 |          47 |           53 |
        |        7 |        2 |        10 |        10 |         6 |         2 |           9 |          35 |          53 |           61 |

