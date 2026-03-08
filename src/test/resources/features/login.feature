Feature: Amazon Login

Scenario: Positive Login
Given user is on Amazon homepage
When user navigates to login page
And user enters email "7449032934"
And user enters password "Asrk@1234"
And user clicks login button
Then user should login successfully


Scenario: Negative Login
Given user is on Amazon homepage
When user navigates to login page
And user enters email "1234567890"
And user enters password "wrong_password"
And user clicks login button
Then login should fail with error message