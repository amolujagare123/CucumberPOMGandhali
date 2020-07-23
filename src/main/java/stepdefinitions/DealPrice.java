package stepdefinitions;

import io.cucumber.java.en.Then;
import pages.HotelsSearchResult;

public class DealPrice {

    HotelsSearchResult hotelsSearchResult = new HotelsSearchResult();

    @Then("^I verify todays deal is less than \"([^\"]*)\" rs$")
    public void i_verify_todays_deal_is_less_than_something_rs(String dealPrice) {

        int dealPricInt = Integer.parseInt(dealPrice);
        System.out.println(dealPrice);

        System.out.println(hotelsSearchResult.getDealPrice());


    }
}
