Feature: As a user i can search in google and expect the search result
  i am expedting to find our website as the first result of the search page.
	
  Scenario Outline: Searching for our page and expecting it as first answer.
      Given Open your prefered web browser
      And load the google search web page
      When i search for "<companyName>" in google
      And go to the first search result
      Then i found the "<companyUrl>" as the webpage link
      And the title should be "<companyWebTitle>"
      And close the web browser
      
      Examples:
          | companyName | companyUrl                    | companyWebTitle |
          | Swag Labs   | https://www.saucedemo.com/v1/ | Swag Labs       |