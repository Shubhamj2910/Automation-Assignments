Feature: Checking article of HuffingtonPost website

@featureList

Scenario: HuffingtonPost website exists

Given I have open the browser

When I open HuffingtonPost website

Then LifeStyle label should exits
	And Click on Lifestyle tab
	And verify tech link is visible
	And Select tech link 
	And verify title of tech page
	And Read Articles Data and verify links

