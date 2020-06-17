package tests.cucumber.booking;

import cucumber.api.java.en.Then;
import steps.booking.BaseSteps;
import steps.booking.SpecialSteps;
import web_driver.Driver;

import java.util.concurrent.TimeUnit;

public class BookingOsloTest {

    int days;

    @Then("I find hotels in {string}, with accommodation for {int} nights after {int} days of arrival, for {int} adults and {int} child in {int} room")
    public void iFindHotels(String town, Integer nights, Integer arrival, Integer adults, Integer children, Integer rooms) throws InterruptedException {
        days = nights;
        GeneralSteps.mainPage.setTown(town);
        GeneralSteps.mainPage.setDates(GeneralSteps.setDays(arrival), GeneralSteps.setDays(nights + arrival));
        GeneralSteps.mainPage.setAdults(adults);
        GeneralSteps.mainPage.setRooms(rooms);
        GeneralSteps.mainPage.setChildren(children);
        Thread.sleep(1000);
        GeneralSteps.mainPage.searchHotels();
        Thread.sleep(2000);
    }


    @Then("I filter hotels with {int} and {int} stars")
    public void iFilterHotelsWithAndStars(Integer int1, Integer int2) throws InterruptedException {
        BaseSteps.findElementClick(Driver.getDriver(), "//*[@data-id='class-3']");
        BaseSteps.findElementClick(Driver.getDriver(), "//*[@data-id='class-4']");
        TimeUnit.SECONDS.sleep(3);
    }

    @Then("I scroll the page to the {int}th hotel on top")
    public void iScrollThePageToTheThHotelOnTop(Integer int1) throws InterruptedException {
        SpecialSteps.findElementScrollIntoView(Driver.getDriver(), "//*[@data-hotelid][10]");
        TimeUnit.SECONDS.sleep(3); //just to have time to see this action

    }

    @Then("I change the background color to green and the title text color to reds")
    public void iChangeTheBackgroundColorToGreenAndTheTitleTextColorToReds() throws InterruptedException {
        BaseSteps.findElementHighlight(Driver.getDriver(), "//*[@data-hotelid][10]//span[contains(@class,'sr-hotel__name')]");
        TimeUnit.SECONDS.sleep(3); //just to have time to see this action
        SpecialSteps.findElementSetAttribute(Driver.getDriver(), "//*[@data-hotelid][10]", "backgroundColor", "green");
        TimeUnit.SECONDS.sleep(3); //just to have time to see this action
        SpecialSteps.findElementSetAttribute(Driver.getDriver(), "//*[@data-hotelid][10]//span[contains(@class,'sr-hotel__name')]", "color", "red");
        TimeUnit.SECONDS.sleep(3); //just to have time to see this action

    }

    @Then("I check that the name is red")
    public void iCheckThatTheNameIsRed() {
        BaseSteps.findElementCheckAttribute(Driver.getDriver(), "//*[@data-hotelid][10]//span[contains(@class,'sr-hotel__name')]", "style", "color: red;");

    }


}
