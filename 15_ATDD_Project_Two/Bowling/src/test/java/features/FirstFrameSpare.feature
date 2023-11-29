Feature: Frist frame got an spare and second frame is normal

  Scenario Outline: first frame will get an spare and second frame will 
      finish with no extra spare or strike
      Given first frame first roll got "<FF_FR>" points
      And first frame second roll got "<FF_SR>" points
      And which makes it as spare
      When second frame first roll get "<SF_FR>" points
      And second frame second roll get "<SF_SR>" points
      Then first frame got a total of "<FF_F_POINTS>" points
      And second frame got a total of "<SR_F_POINTS>" points

	    Examples: 
	        | FF_FR | FF_SR | SF_FR | SF_SR | FF_F_POINTS | SF_F_POINTS |
	        |     5 |     5 |     4 |     2 |          16 |          22 |
	        |     3 |     7 |     2 |     7 |          19 |          28 |
	        |     2 |     8 |     6 |     1 |          17 |          24 |
	        |     1 |     9 |     0 |     2 |          12 |          14 |
	        |     4 |     6 |     2 |     3 |          15 |          20 |