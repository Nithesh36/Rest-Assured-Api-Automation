@Blob
Feature: Create a Blob
  As a user i want to create a blob so that I can parse and validate the json elements.


  @Regression
  Scenario Outline: Create a data file
    Given I read a Json data file "BLOB"
    When I post the Request
    Then the response status code should be "201"
    #And response is "<id>","<title>","<author>"
#    And response "<path>" should include "<expected>"



  #Excel
#And response "<SheetName>" should include a "<Path>"
#    Examples:

#      |SheetName        |path  |
#      |sheet1       |D:\api\ApiData.csv       |

