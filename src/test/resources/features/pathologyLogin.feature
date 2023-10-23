
Feature: Login To the pathology website

  @tag1
  Scenario Outline: Successful Login With Valid Credentials
    Given Chrome Browser is open
    When User Opens the URL <url>
    And User Enters the Email as<email> and password as<password>
    And click on login
    And Validate whether page title and url as <title> and <url>
    And view the list of todos
 Examples:
 
 | flow | url | email | Password |
 |Valid | https://gor-pathology.web.app/| test@kennect.io|Qwerty@1234|
 ##|invalid|https://gor-pathology.web.app/ |test@gmail.com |Test@1234|
 