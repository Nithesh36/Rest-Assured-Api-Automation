Feature: GETPosts
  Verify GET operations

  Scenario: Verify one author of the post
    Given I perform GET operation for "/posts"
    And I perform get opertaion for port number "1"
    Then I should see the author name as "Jaisurya"

  Scenario: Verify Collection of author of the post
    Then I should see the author name

  Scenario: Verify PathParameter of get
    Then I should see verify get parameter

  Scenario: Verify QueryParameter of get
    Then I should see verify get Queryparameter

  Scenario: Verify Post request
    Given Here I am Perform a PostRequest "/posts"



#  Scenario: Verify one author of the post
#    Given I perform GET operation for "/posts"
#    Then I should see the author name as "Jaisurya"
#
#  Scenario: Verify Collection of author of the post
#    Then I should see the author name
#
#  Scenario: Verify PathParameter of get
#    Then I should see verify get parameter
#
#  Scenario: Verify QueryParameter of get
#    Then I should see verify get Queryparameter