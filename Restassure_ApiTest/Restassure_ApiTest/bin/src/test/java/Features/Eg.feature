Feature: Get oper
@smoke
Scenario: Verify GET operation with bearer authentication token
Given I perform authentication operation for "/auth/login" with body
| email              | password  |
| karthik@email.com | haha123 |
Given I perform a GET operation for "/posts/1"
Then I should see a author name as "Jaisurya"