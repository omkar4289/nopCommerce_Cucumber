Feature: Customers

  Background: common steps
    Given User Launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on customers menu
    And click on customers Menu Item

  Scenario: Add a new customer
    And click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And click on save button
    Then User can view confirmation message "The new customer has been added successfully"
    And close browser

  Scenario: Search customer by EmailID
    And enter customer email
    When click on search button
    Then user should found Email in the search table
    And close browser

 
  Scenario: Search customer by Name
    And enter customer FirstName
    And enter customer LastName
    When click on search button
    Then user should found Name in the search table
    And close browser
 @smoke
  Scenario: Check registered customer role customers
   And select customer role
    When click on search button
    Then user should see only "Guests" customers in the search table
    And close browser
