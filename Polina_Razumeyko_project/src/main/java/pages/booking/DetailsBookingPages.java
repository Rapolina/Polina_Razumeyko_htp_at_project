package pages.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.applet.AppletResourceLoader;
import web_driver.Driver;

public class DetailsBookingPages {

    Actions actions;
    private Driver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(xpath = "//*[@data-id='pri-1']")
    private WebElement lowestPriceInfo;

    // @FindBy(xpath =)
    //private WebElement priceInfo;

    @FindBy(xpath = "//*[@data-id='class-3']")
    private WebElement starsThree;

    @FindBy(xpath = "//*[@data-id='class-4']")
    private WebElement startsFour;

    @FindBy(xpath = "//*[@data-hotelid][10]")
    private WebElement findTenthHotel;

    @FindBy(xpath ="//*[@id=\\\"filter_price\\\"]/div[2]/a[5]/label/div")
    private WebElement maxFilter;

    @FindBy(xpath = "//*[@id=\\\"sort_by\\\"]/ul/li[3]/a")
    private WebElement minFilter;

public DetailsBookingPages(WebDriver driver){
    PageFactory.initElements(driver,this);

}

    public int getHotelsWithLowestPriceInMoscow() {
        lowestPriceInfo.click();
        return 0;
    }

    public int getHotelWithPriceInMoscow() {
        return 0;
    }

    public void selectStars() {
        starsThree.click();
        startsFour.click();
    }

    public void findTenthHotel() {
        findTenthHotel.click();

    }

    public int getMaxPrice() {
        maxFilter.click();
        String expensiveHotel = maxFilter.getText().replaceAll("[^0-9]+", "");
        System.out.println("The most expensive hotel costs  per night:" + expensiveHotel);
        int expensiveHotelPerNight = Integer.parseInt(expensiveHotel);
        return expensiveHotelPerNight;
    }

    public int getMinPrice() {
        minFilter.click();
        WebElement MinFromMax = Driver.getDriver().findElement(By.xpath("//*[@data-hotelid][1]//div[contains(@class,'bui-price-display__value')]"));
        String minPriceFromMax = MinFromMax.getText().replaceAll("[^0-9]+", "");
        int hotelPerNight = Integer.parseInt(minPriceFromMax) / 7;
        return hotelPerNight;
    }

    public int getMinPriceMoscow(){
        minFilter.click();
        WebElement MinFromMax = Driver.getDriver().findElement(By.xpath("//*[@data-hotelid][1]//div[contains(@class,'bui-price-display__value')]"));
        String minPriceFromMax = MinFromMax.getText().replaceAll("[^0-9]+", "");
        int hotelPerNight = Integer.parseInt(minPriceFromMax) / 7;
        System.out.println("Minimum price per night from " + hotelPerNight);
        return hotelPerNight;
    }
}
