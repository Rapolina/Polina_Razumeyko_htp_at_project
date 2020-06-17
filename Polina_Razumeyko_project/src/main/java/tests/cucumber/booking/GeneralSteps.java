package tests.cucumber.booking;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import pages.booking.DetailsBookingPages;
import pages.booking.MainBookingPages;
import settings.Config;
import web_driver.Driver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GeneralSteps {


    public static DetailsBookingPages detailsPage;
    public static MainBookingPages mainPage;


    @Before
    public void beforeMethod() {
        Driver.initDriver(Config.CHROME);
        detailsPage = new DetailsBookingPages(Driver.getDriver());
        mainPage = new MainBookingPages(Driver.getDriver());
    }

    @After
    public void afterMethod() {
        Driver.destroy();
        Driver.driver.remove();
    }


    public static String setDays(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, days);
        Date newDate = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(newDate);
    }

}
