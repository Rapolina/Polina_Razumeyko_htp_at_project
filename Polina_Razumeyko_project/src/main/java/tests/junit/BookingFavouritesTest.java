package tests.junit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import settings.Config;
import steps.booking.BaseSteps;
import steps.booking.SpecialSteps;
import web_driver.Driver;

import java.util.concurrent.TimeUnit;

import static tests.junit.BookingNewAccoutTest.yandexEmail;
import static tests.junit.BookingNewAccoutTest.yandexPassword;

public class BookingFavouritesTest {
    static String BOOKING_URL = "https://www.booking.com/";
    int arrival = 30;
    int nights = 5;

    @Before
    public void beforeMethod() {
        Driver.initDriver(Config.CHROME);
    }

    @Test
    public void addToFavoritesTest() throws InterruptedException {
        Driver.getDriver().get(BOOKING_URL);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"current_account\"]")).click();
        TimeUnit.SECONDS.sleep(3);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(yandexEmail);
        TimeUnit.SECONDS.sleep(3);
        Driver.getDriver().findElement(By.xpath("//*[@type=\"submit\"]")).click();
        TimeUnit.SECONDS.sleep(4);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(yandexPassword);
        Driver.getDriver().findElement(By.xpath("//*[@type=\"submit\"]")).click();
        TimeUnit.SECONDS.sleep(4);
        Driver.getDriver().findElement(By.xpath("//*[@id='ss']")).click();
        BaseSteps.findElementClick(Driver.getDriver(), "//*[@data-mode='checkin']");
        BaseSteps.findElementClick(Driver.getDriver(), String.format("//*[@data-date='%s']", SpecialSteps.setDays(arrival)));
        BaseSteps.findElementClick(Driver.getDriver(), String.format("//*[@data-date='%s']", SpecialSteps.setDays(arrival + nights)));
        BaseSteps.findElementClick(Driver.getDriver(), "(//*[contains(@type,'submit')])[1]");
        TimeUnit.SECONDS.sleep(3);
    }

    public void setFavoritesCheckClolor() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"hotellist_inner\"]/div[1]/div[1]/div/button")).click();
        Driver.getDriver().findElement(By.xpath("//*[@id=\"hotellist_inner\"]/div[1]/div[1]/div/button/*[1]"));
        TimeUnit.SECONDS.sleep(2);


    }
}
