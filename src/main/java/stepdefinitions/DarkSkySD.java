package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DarkSkyHome;

import java.util.ArrayList;
import java.util.Collections;

public class DarkSkySD {

    DarkSkyHome darkSkyHome = new DarkSkyHome();

    @Given("I am on Darksky Home Page")
    public void i_am_on_Darksky_Home_Page() {
      // assert the page title


        Assert.assertEquals(SharedSD.getDriver().getTitle(),
                "Dark Sky - Range Hills Road, Pune, Maharashtra",
                "This is not a dark sky home page");
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

        Assert.assertEquals(darkSkyHome.getListTodaysTemp(),
                darkSkyHome.getListTodaysTimelineTemp(),
                "the todays temprature & timeline temp doesnot match");

    }


    @Then("I verify timeline is displayed with two hours incremented")
    public void i_verify_timeline_is_displayed_with_two_hours_incremented() {

        System.out.println(darkSkyHome.getTimelistInt());

        ArrayList<Integer> timeList = darkSkyHome.getTimelistInt();
        ArrayList<Integer> timeDiffList = new ArrayList<>();


        for(int i=0;i<timeList.size()-1;i++)
        {
            int time1 = timeList.get(i);
            int time2 = timeList.get(i+1);


            int timeDiff =0;

            if(time2>time1)
             timeDiff = time2-time1;
            else if(time2<time1)
                timeDiff = (time2+12)-time1;

            timeDiffList.add(timeDiff);


        }

        System.out.println(timeDiffList);

        int occuranceOfTimeDiff = Collections.frequency(timeDiffList,2);
        int size = timeDiffList.size();

       boolean result =  occuranceOfTimeDiff==size;

       Assert.assertTrue(result,"The time difference is not 2 everywhere " +
               "\n see the list of time diff."
       +timeDiffList);

    }
}
