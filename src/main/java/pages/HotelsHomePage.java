package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import stepdefinitions.SharedSD;

public class HotelsHomePage extends  BasePage{


    By cityTextBox = By.xpath("//input[@id='qf-0q-destination']");
    By searchButton = By.xpath("//button[contains(@type,'submit')]");


    public  void setCityTextBox(String city)
    {
        JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
        js.executeScript("arguments[0].setAttribute('value','"+city+"')",driver.findElement(cityTextBox));

    }


    public void clickSearchButton()
    {
        clickOn(searchButton);
    }
}
