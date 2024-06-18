Feature: Login scenarios

  Scenario : Launch the Application
    
    Given I Launch the Appication
    And Verify the App Launch
   
   Scenario Outline : Login with the correct username & password
   
   Given I Launch the Appication
   When I enter "<username>" and "<pasword>"
   And I click on the Login Button
   Then  Home page is shown
  
   Examples:
      | username               |     password        | Message    |
      | rushisonar431517@gmail | Rushi@554           | WelCome    |
      | rushisonar431517@gmail | Rushi@123           | Error Msg  |

  

