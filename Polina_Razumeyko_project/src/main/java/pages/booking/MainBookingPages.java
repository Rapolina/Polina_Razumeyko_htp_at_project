package pages.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web_driver.Driver;

public class MainBookingPages {


    @FindBy(xpath = "//*[@id='ss']")
    private static WebElement countryChoice;

    @FindBy(xpath = "//*[@data-mode='checkin']")
    private static WebElement checkInChoice;

    @FindBy(xpath = "//*[contains(@class, \"xp__input-group xp__date-time\")]")
    private static WebElement bookingDays;

    @FindBy(xpath = "//*[@data-mode='checkout']")
    private static WebElement checkOutChoice;

    @FindBy(xpath = "//*[@class='sb-searchbox__button ']")
    public static WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"xp__guests__toggle\"]/span[2]/span[1]")
    private static WebElement guestInfo;

    @FindBy(xpath = "//*[@id=\"xp__guests__inputs-container\"]/div/div/div[1]/div/div[2]/button[2]/span")
    private static WebElement adultsInfo;

    @FindBy(xpath = "//*[@id=\"xp__guests__inputs-container\"]/div/div/div[2]/div/div[2]/button[2]")
    private static WebElement childrenInfo;

    @FindBy(xpath = "//*[@id=\"xp__guests__inputs-container\"]/div/div/div[3]/div/div[2]/button[2]/span")
    private static WebElement roomsInfo;

    @FindBy(xpath = "//*[contains(@class,\"field-adult\")]//input")
    private static WebElement adultsStartValue;

    @FindBy(xpath = "//*[contains(@class,\"field-rooms\")]//input")
    private static WebElement roomsStartValue;

    @FindBy(xpath = "//*[@id=\"group_children\"]")
    private static WebElement childrenStartValue;

    @FindBy(xpath = "//*[@id=\"xp__guests__toggle\"]")
    public static WebElement setPeople;

    public MainBookingPages(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public static void findTheRightHotelInMoscow(String city, int checkIn, int checkOut) {
        countryChoice.click();
        countryChoice.sendKeys(city);
        WebElement checkIN = Driver.getDriver().findElement(By.xpath(String.format("//*[contains(@data-date, \"%s\")]", checkIn)));
        checkIN.click();
        WebElement checkOUT = Driver.getDriver().findElement(By.xpath(String.format("//*[contains(@data-date, \"%s\")]", checkOut)));
        checkOUT.click();
        Actions builder = new Actions(Driver.getDriver());
        WebElement adults = Driver.getDriver().findElement(By.cssSelector("#group_adults"));
        builder.click(adults).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        WebElement rooms = Driver.getDriver().findElement(By.cssSelector("#no_rooms"));
        builder.click(rooms).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        searchButton.click();
    }


    public static void findTheRightHotelInOslo(String city, int chechIn, int checkOut) {
        countryChoice.click();
        countryChoice.sendKeys(city);
        WebElement checkIN = Driver.getDriver().findElement(By.xpath(String.format("//*[@data-date='%s']", chechIn)));
        checkIN.click();
        WebElement checkOUT = Driver.getDriver().findElement(By.xpath(String.format("//*[@data-date='%s']", checkOut)));
        checkOUT.click();
        guestInfo.click();
        adultsInfo.click();
        adultsInfo.click();
        childrenInfo.click();
        searchButton.click();
    }


    public static void findTheRightHotelInParis(String city, int chechIn, int checkOut) {
        countryChoice.click();
        countryChoice.sendKeys(city);
        WebElement checkIN = Driver.getDriver().findElement(By.xpath(String.format("//*[@data-date='%s']", chechIn)));
        checkIN.click();
        WebElement checkOUT = Driver.getDriver().findElement(By.xpath(String.format("//*[@data-date='%s']", checkOut)));
        checkOUT.click();
        guestInfo.click();
        adultsInfo.click();
        adultsInfo.click();
        adultsInfo.click();
        adultsInfo.click();
        roomsInfo.click();
        roomsInfo.click();
        searchButton.click();
    }

    public void setTown(String town) {
        countryChoice.click();
        countryChoice.sendKeys(town);
    }

    public void setDates(String checkIn, String checkOut) {
        bookingDays.click();
        Driver.getDriver().findElement(By.xpath(String.format("//*[contains(@data-date, \"%s\")]", checkIn))).click();
        Driver.getDriver().findElement(By.xpath(String.format("//*[contains(@data-date, \"%s\")]", checkOut))).click();
    }

    public void setAdults(int adults) throws InterruptedException {
        setPeople.click();
        Thread.sleep(300);
        int adultsStart = Integer.parseInt(adultsStartValue.getAttribute("value"));
        if (adultsStart < adults) {
            for (int i = 0; i < (adults - adultsStart); i++) {
                adultsInfo.click();
            }
        }
    }

    public void searchHotels() {
        searchButton.click();

    }

    public void setChildren(int children) {
        int childrenStart = Integer.parseInt(adultsStartValue.getAttribute("value"));
        if (childrenStart < children) {
            for (int i = 0; i < (children - childrenStart); i++) {
                childrenInfo.click();
            }
        }
    }

    public void setRooms(int rooms) {
        int roomsStart = Integer.parseInt(roomsStartValue.getAttribute("value"));
        if (roomsStart < rooms) {
            for (int i = 0; i < (rooms - roomsStart); i++) {
                roomsInfo.click();
            }
        }
    }

    public boolean elementIsDisplayed(String xpath) {
        WebElement element = Driver.getDriver().findElement(By.xpath(xpath));
        return element.isDisplayed();
    }
}
