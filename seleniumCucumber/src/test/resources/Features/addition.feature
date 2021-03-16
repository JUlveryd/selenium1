Feature: Adding two numbers on page
@myTag
Scenario: Add two numbers
Given I have entered 70 into the calculator
And I have also entered 50 into the calculator
When I press Find Addition
Then the result should be 120 on the screen