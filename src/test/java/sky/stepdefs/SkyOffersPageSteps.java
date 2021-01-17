package sky.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sky.pages.SkyShopHomePage;
import sky.pages.SkyShopOffersPage;

public class SkyOffersPageSteps {
    SkyShopOffersPage skyShopOffersPage =  new SkyShopOffersPage();
    @Then("I should see offers page")
    public void i_should_see_offers_page() {
        skyShopOffersPage.checkOffersPage();

    }

    @When("I navigate to offers Page")
    public void i_navigate_to_offers_page() {

    }
    @Then("I see a list of offers with following prices")
    public void i_see_a_list_of_offers_with_following_prices(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

    }

}
