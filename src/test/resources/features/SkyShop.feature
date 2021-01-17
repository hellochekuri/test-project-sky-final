Feature: To test SKY OFFERS PAGE
#  Note: You will have to handle the ‘accept cookies’ in your test.
# Home page is https://www.sky.com/
# It is better to clear the cookies for sky.com or clear your web page history.



  Scenario: Open offers page
    Given I am on the home page
    When I navigate to Deals
    Then I should see offers page

  Scenario: Login with invalid credentials
    Given I am on the home page
    When I try to sign in with invalid credentials
    Then I should see a text saying that "Sorry, we did not recognise either your username or password"

  Scenario: Check offer prices
    Given I am on the home page
    When I navigate to offers Page
    Then I see a list of offers with following prices
      | £27.50 | £66.50 | £42.50 |

  Scenario: Search results
    Given I am on the home page
    When I search ‘sky’ in the search bar
    Then I should see an editorial section

