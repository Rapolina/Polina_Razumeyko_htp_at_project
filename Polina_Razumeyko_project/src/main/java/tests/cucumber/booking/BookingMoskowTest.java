package tests.cucumber.booking;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import steps.booking.BaseSteps;
import web_driver.Driver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class BookingMoskowTest {

    int days;

    @Then("I find hotels in {string}, with accommodation for {int} nights after {int} days of arrival")
    public void iFindHotels(String town, Integer nights, Integer arrival) throws InterruptedException {

        days = nights;
        GeneralSteps.mainPage.setTown(town);
        GeneralSteps.mainPage.setDates(GeneralSteps.setDays(arrival), GeneralSteps.setDays(nights + arrival));
        GeneralSteps.mainPage.searchHotels();
        Thread.sleep(3000);
    }

    int hotelPerNight;
    int budgetPerNight;

    @Then("I filter hotels with the lowest cost")
    public void iFilterHootelsWithLowCost() throws InterruptedException {
        WebElement lowPriceFilter = Driver.getDriver().findElement(By.xpath("//*[@data-id='pri-1']"));
        lowPriceFilter.click();
        String budget = lowPriceFilter.getText();
        WebElement lowBudget = Driver.getDriver().findElement(By.xpath("//*[@id=\"sort_by\"]/ul/li[3]/a"));
        lowBudget.click();
        budgetPerNight = Integer.parseInt(budget.substring(budget.indexOf("-")).replaceAll("\\D+", ""));
        Thread.sleep(3000);

        String firstPrice = BaseSteps.findElementGetText(Driver.getDriver(), "(//*[contains(@class,'bui-price-display')]/div[2]/div)[1]").replaceAll("\\D+", "");
        hotelPerNight = Integer.parseInt(firstPrice) / days;
        System.out.println("Budget per night up to " + budgetPerNight);
        System.out.println("Price per night of first on the list from " + hotelPerNight);
    }

    @And("I check that the cost of the night on the first on the list is less than or equal to the maximum")
    public void iCheckLowCost() {

        assertTrue("Something wrong", hotelPerNight <= budgetPerNight);

    }
}
