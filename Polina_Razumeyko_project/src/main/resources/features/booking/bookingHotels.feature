Feature: Booking Test

  Scenario: Find the most expensive hotel in Paris
    Given I open website booking.com
    Then I find hotels in "Paris", with accommodation for 7 nights after 3 days of arrival, for 4 adults in 2 rooms
    And I filter the hotels with the maximum cost
    And I filter by cost starting from the cheapest

  Scenario: Find the hotel with the lowest price in Moscow
    Given I open website booking.com
    Then I find hotels in "Moskow", with accommodation for 5 nights after 10 days of arrival
    And I filter hotels with the lowest cost
    And I check that the cost of the night on the first on the list is less than or equal to the maximum


  Scenario: Find the right hotel in Oslo and check that the text is red
    Given I open website booking.com
    Then I find hotels in "Oslo", with accommodation for 1 nights after 1 days of arrival, for 2 adults and 1 child in 1 room
    And I filter hotels with 3 and 4 stars
    And I scroll the page to the 10th hotel on top
    And I change the background color to green and the title text color to reds
    And I check that the name is red


