Feature: Login functionality test feature

Scenario: Perform google search
	Given User is on Google Home Page
	When User search for New James Bond Movies
	Then James Bond movie results should display successfully
