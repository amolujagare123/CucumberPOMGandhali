package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DarkSkyHome;

public class DarkSkySD {

    DarkSkyHome darkSkyHome = new DarkSkyHome();

    @Given("I am on Darksky Home Page")
    public void i_am_on_Darksky_Home_Page() {
      // assert the page title
    }

    @Then("I verify current temp is not greater or less then temps from daily timeline")
    public void i_verify_current_temp_is_not_greater_or_less_then_temps_from_daily_timeline() {

        String expected = darkSkyHome.getcurrTemp();
        String actual = darkSkyHome.gettimelineTemp();

        System.out.println("expected:"+expected);
        System.out.println("actual:"+actual);
    }


    @When("I expand todays timeline")
    public void i_expand_todays_timeline() {

        darkSkyHome.clickTodaysTimelineexapander();
    }

    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void i_verify_lowest_and_highest_temp_is_displayed_correctly() throws Throwable {

        System.out.println(darkSkyHome.getListTodaysTemp());
        System.out.println(darkSkyHome.getListTodaysTimelineTemp());

    }
}
