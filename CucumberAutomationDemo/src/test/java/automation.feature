Feature: to test automation practise page 

  Scenario Outline: Create Account for automation page with valid details
    Given user enter url to create account
    When user enter "<username>" gender, "<firstname>", "<lastname>", "<password>", "<date>", "<month>", "<year>", "<address>", "<city>", "<state>", "<zipcode>", "<country>", "<mobile>" and click on create button
    And user enter "<username>" , "<password>" and click on login button
    And user select product and added it cart
    Then verify account is created and product is added to cart
    

 Examples:
    |username              |firstname  |lastname  |password |date |month|year |address   |city    |state   |zipcode|country       |mobile     |
    |egomathi321@gmail.com   |gomathi    |elangovan |Meenu@96 |5    |7    |1996 |AnnaNagar |Chennai |Indiana |96162  |United States |9876543210 |
    
  