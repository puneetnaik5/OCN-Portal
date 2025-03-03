Feature: To Test Login Functionality

  Scenario: Verify the Signup functionality
    Given User click on Get Started
    When User waits for 1000 milliseconds
    When User Enters Username "abc@mail.com"
    And User enter a password "Abc@abc22"
    And User confirms the password "Abc@abc22"
    Then User clicks on Sign up
    And User waits for 5000 milliseconds
    Then An alert with message "Provided E-Mail is already in use" should be displayed and accepted

    @sanity
    Scenario: Verify SignIn and SignOut Functionality
      Given User click on Get Started
      When User clicks on Already have an account link below
      When User Enters Username "abc@mail.com"
      And User enter a password "Abc@abc22"
      And User clicks on SignIN Button
      And User waits for 5000 milliseconds
      Then "SIGN OUT" should be displayed on Successful login
      And User waits for 2000 milliseconds
      Then User Clicks on SignOut
      Then "SIGN IN" should be displayed on Sign Out

      Scenario: Verify if user is able to login with invalid credentials
        Given User click on Get Started
        When User clicks on Already have an account link below
        When User Enters Username "abc@YYmail.com"
        And User enter a password "Abc@YYabc22"
        And User clicks on SignIN Button
        Then An alert with message "User not found" should be displayed and accepted




