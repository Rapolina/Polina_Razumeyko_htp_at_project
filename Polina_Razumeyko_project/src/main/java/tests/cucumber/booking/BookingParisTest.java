package tests.cucumber.booking;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.booking.DetailsBookingPages;
import pages.booking.MainBookingPages;
import settings.Config;
import web_driver.Driver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertTrue;

public class BookingParisTest {


    public int days;



    @Given("I open website booking.com")
    public void iOpenWebsite() {
        Driver.getDriver().get("https://www.booking.com/");
    }


    @Then("I find hotels in {string}, with accommodation for {int} nights after {int} days of arrival, for {int} adults in {int} rooms")
    public void iFindHotels(String town, Integer nights, Integer arrival, Integer adults, Integer rooms) throws InterruptedException {
        // MainBookingPages.findTheRightHotelInParis(town, arrival, nights);
        days = nights;
        GeneralSteps.mainPage.setTown(town);
        GeneralSteps.mainPage.setDates(GeneralSteps.setDays(arrival), GeneralSteps.setDays(nights+arrival));
        GeneralSteps.mainPage.setAdults(adults);
        GeneralSteps.mainPage.setRooms(rooms);
        Thread.sleep(1000);
        GeneralSteps.mainPage.searchHotels();
        Thread.sleep(2000);
    }


    int hotelPerNight;
    int expensiveHotelPerNight;

    @Then("I filter the hotels with the maximum cost")
    public void iFilterTheHotelsWithTheMaximumCost() throws InterruptedException {
        WebElement budget = Driver.getDriver().findElement(By.xpath("//*[@id=\"filter_price\"]/div[2]/a[5]/label/div"));
        budget.click();
        String expensiveHotel = budget.getText().replaceAll("[^0-9]+", "");
        System.out.println("The most expensive hotel costs  per night:" + expensiveHotel);
        expensiveHotelPerNight = Integer.parseInt(expensiveHotel);
        WebElement lowBudget = Driver.getDriver().findElement(By.xpath("//*[@id=\"sort_by\"]/ul/li[3]/a"));
        lowBudget.click();
        Thread.sleep(5000);
        WebElement MinFromMax = Driver.getDriver().findElement(By.xpath("//*[@data-hotelid][1]//div[contains(@class,'bui-price-display__value')]"));
        String minPriceFromMax = MinFromMax.getText().replaceAll("[^0-9]+", "");
        hotelPerNight = Integer.parseInt(minPriceFromMax) / days;
        System.out.println("Minimum price per night from " + hotelPerNight);

    }

    @Then("I filter by cost starting from the cheapest")
    public void iCheckThatTheCost() {
        Assert.assertTrue("Something wrong", hotelPerNight >= expensiveHotelPerNight);
    }
}

