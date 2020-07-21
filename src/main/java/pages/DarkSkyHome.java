package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import stepdefinitions.SharedSD;

import java.util.ArrayList;

public class DarkSkyHome extends  BasePage{
    By currTemp = By.xpath("//span[@class='summary swap']");
    By timelineTemp  = By.xpath("//span[@class='first']//span");
    //By todaysTimelineExapnder = By.xpath("//a[@data-day='0']");

    By todayMinTemp = By.xpath("//a[@class='day revealed']//span[@class='minTemp']");
    By todayMaxTemp = By.xpath("//a[@class='day revealed']//span[@class='maxTemp']");
    By todayTimelineMinTemp = By.xpath("//div[@class='dayDetails revealed']//span[@class='highTemp swip']//span[@class='temp']");
    By todayTimelineMaxTemp = By.xpath("//div[@class='dayDetails revealed']//span[@class='lowTemp swap']//span[@class='temp']");

    By  expanderIcon = By.xpath("//body[@class='forecast']/div[@id='week']/a[1]/span[3]");
    By timeList = By.xpath("//span[@class='hour']//span");

    public ArrayList<Integer> getTimelistInt()
    {
         ArrayList<String> timeListStr = getElementTextList(timeList) ; // {2pm, 1am}

        ArrayList<Integer> timeListint = new ArrayList<>();

        for(int i=0;i<timeListStr.size();i++)
        {
            int l = timeListStr.get(i).length();

            timeListint.add( Integer.parseInt(timeListStr.get(i).substring(0,l-2)));
        }
           return  timeListint;
    }



    // write a method that will give us a list of number (time)

    public void  clickTodaysTimelineexapander()
    {
        JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
        js.executeScript("window. scrollBy(0,800)", "");

        clickOn(expanderIcon);

        // js.executeScript("arguments[0].click",driver.findElement(expanderIcon));
    }


    /*public void clickTodaysTimelineexapander()
    {
       // clickOn(todaysTimelineExapnder);

        JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();

        js.executeScript("window.scrollBy(0,1200)","");

       js.executeScript("arguments[0].click",driver.findElement(todaysTimelineExapnder));
      //  clickOn(todaysTimelineExapnder);
    }*/

    public ArrayList<String> getListTodaysTemp()
    {
        ArrayList<String> todaysMinmaxlist = new ArrayList<>();

        todaysMinmaxlist.add(getTextFromElement(todayMinTemp).split("˚")[0]);
        todaysMinmaxlist.add(getTextFromElement(todayMaxTemp).split("˚")[0]);

        return todaysMinmaxlist;
    }

    public ArrayList<String> getListTodaysTimelineTemp()
    {
        ArrayList<String> todaysTimelineMinmaxlist = new ArrayList<>();

        todaysTimelineMinmaxlist.add(getTextFromElement(todayTimelineMinTemp).split("˚")[0]);
        todaysTimelineMinmaxlist.add(getTextFromElement(todayTimelineMaxTemp).split("˚")[0]);

        return todaysTimelineMinmaxlist;
    }




    public String getcurrTemp() // 77˚ Humid and Overcast.
    {
          return getTextFromElement(currTemp).split("˚")[0];
    }
    public String gettimelineTemp() // 78°
    {
        return getTextFromElement(timelineTemp).split("°")[0];
    }

}
