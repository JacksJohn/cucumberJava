
@FeatureSearch
Feature: Querying Used Books

  Scenario: Search Used books and Validate data displayed  
    Given The Trademe Sandbox Page is open
    When the user clicks on Market Place
    And clicks on the Books
    And filters with condition as Used
    And clicks the book of choice
    Then the books details are displayed
   
