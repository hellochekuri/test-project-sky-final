package sky.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sky.pages.SkyShopHomePage;

public class SkyHomePageSteps {
    SkyShopHomePage skyShopHomePage =  new SkyShopHomePage();


    @Given("I am on the home page")
    public void i_am_on_the_home_page() throws InterruptedException {
        skyShopHomePage.openHomePage();
    }

    @When("I navigate to Deals")
    public void i_navigate_to_deals() {
        skyShopHomePage.navigateToDealPage();
    }


    @When("I try to sign in with invalid credentials")
    public void i_try_to_sign_in_with_invalid_credentials() {
        String username = "test@test.com";
        String password = "password";
        skyShopHomePage.login(username, password);

    }
    @Then("^I should see a text saying that (.*)$")
    public void i_should_see_a_text_saying_that(String loginFailMessage) {

        skyShopHomePage.assertLoginFailureMessage(loginFailMessage);

    }

    @When("^I search ‘(.*)’ in the search bar$")
    public void i_search_sky_in_the_search_bar(String searchTerm) {

        skyShopHomePage.searchForSky(searchTerm);
    }
    @Then("I should see an editorial section")
    public void i_should_see_an_editorial_section() {
        skyShopHomePage.checkEditorial();

    }


}
