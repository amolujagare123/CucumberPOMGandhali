package pages;

import org.openqa.selenium.By;
import stepdefinitions.SharedSD;

import java.util.ArrayList;

public class HotelsSearchResult extends  BasePage{

   By starRatings = By.xpath("//span[contains(@class,'star-rating-text')]");
   By dealPrice = By.xpath("//li[contains(@class,'deal-of-the-day')]//ins");

    public int getDealPrice()
    {
        String dealPriceRaw = getTextFromElement(dealPrice);

        String dealPriceWithoutRs = dealPriceRaw.substring(2); //"6,123"

        String dealpriceWithoutComma ="";

        for(int i=0;i<dealPriceWithoutRs.length();i++)
        {
            if(dealPriceWithoutRs.charAt(i)!=',')
              dealpriceWithoutComma = dealpriceWithoutComma + dealPriceWithoutRs.charAt(i);
        }


        return  Integer.parseInt(dealpriceWithoutComma);
    }




   public ArrayList<String> getStarList()
   {
       System.out.println(getElementTextList(starRatings));
       return getElementTextList(starRatings);
   }





    public void clickStarRating(String star)
    {
        SharedSD.getDriver().navigate().refresh();
        SharedSD.getDriver().findElement(By.xpath("//input[@id='f-star-rating-"+star+"']")).click();

    }

}
