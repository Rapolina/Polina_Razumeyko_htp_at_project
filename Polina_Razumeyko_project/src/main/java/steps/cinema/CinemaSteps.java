package steps.cinema;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import settings.Config;
import steps.booking.BaseSteps;
import web_driver.Driver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CinemaSteps {
    private String messageBox = "//*[contains(text(),'%s')]";
    private String movieTitle = "//*[@class= \"sc-iKIEpe bLYdTB\"]/div/div/a";
    private String movieDescription = "//*[@class=\"sc-whdbJ ghEKaE\"]";
    private String discoveredMovieNumb = "//*[@class= \"sc-iKIEpe bLYdTB\"][%s]/div/div/a";
    private String searchField = "//*[contains(@placeholder, \"Поиск\")]";
    private String searchButton = "//*[@id= \"svg-icon-search\"]";
    private String loginBox = "//*[@class=\"sc-fyjhYU eVJmYW\"]";
    private String loginField = "//*[@type= \"email\"]";
    private String passwordField = "//*[@type= \"password\"]";
    private String submit = "//*[text()= \"Войти\"]";

    @Before
    public void preCondition() {
        Driver.initDriver(Config.CHROME);
        Driver.getDriver().manage().window().maximize();
    }

    @After
    public void postCondition() {
        Driver.destroy();
        Driver.driver.remove();
    }

    //search movies
    @Given("I open an app")
    public void iOpenAnApp() throws InterruptedException {
        Driver.getDriver().get("https://silverscreen.by/");
        TimeUnit.SECONDS.sleep(1);
    }

    @When("I search for {string} word")
    public void iSearchForSearchWordWord(String searchWord) throws InterruptedException {
        List<WebElement> searchButtons = Driver.getDriver().findElements(By.xpath(searchButton));
        Thread.sleep(500);
        searchButtons.get(0).click();
        Thread.sleep(500);
        BaseSteps.findElementSendKeys(Driver.getDriver(), searchField, searchWord);
        searchButtons.get(1).click();
        TimeUnit.SECONDS.sleep(2);
    }

    @Then("I see the list of movie items")
    public void iSeeTheListOfMovieItems() {

    }

    @And("each item name or description contains {string}")
    public void eachItemNameOrDescriptionContainsSearchWord(String searchWord) throws InterruptedException {
        boolean check = true;
        List<WebElement> movieTitlesAmount = Driver.getDriver().findElements(By.xpath(movieTitle));
        for (int i = 0; i < movieTitlesAmount.size(); i++) {
            String sampleTitle = Driver.getDriver().findElement(By.xpath(String.format(discoveredMovieNumb, (i + 1)))).getText().toLowerCase();
            if (!matching(sampleTitle, searchWord)) {
                Driver.getDriver().findElement(By.xpath(String.format(discoveredMovieNumb, i + 1))).click();
                TimeUnit.SECONDS.sleep(1);
                String sampleDescription = Driver.getDriver().findElement(By.xpath(movieDescription)).getText().toLowerCase();
                if (!matching(sampleDescription, searchWord)) {
                    check = false;
                    break;
                }
                Driver.getDriver().navigate().back();
                TimeUnit.SECONDS.sleep(1);
            }
        }
        Assert.assertTrue(check);
    }

    public static boolean matching(String sample, String predicate) {
        Pattern pattern = Pattern.compile(".*" + predicate + ".*");
        Matcher matcher = pattern.matcher(sample);
        return matcher.find();
    }

    // log in steps
    @When("I login with {string} and {string}")
    public void iLoginWithLoginAndPassword(String login, String password) throws InterruptedException {
        openLoginPanel();
        Thread.sleep(500);
        enterLogin(login);
        enterPassword(password);
        clickSubmit();
        Thread.sleep(1000);
    }

    public void openLoginPanel() throws InterruptedException {
        Thread.sleep(1000);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath(loginBox))).build().perform();
    }

    public void enterLogin(String login) {
        Driver.getDriver().findElement(By.xpath(loginField)).sendKeys(Keys.chord(Keys.CONTROL, "a"), login);
    }

    public void enterPassword(String password) {
        Driver.getDriver().findElement(By.xpath(passwordField)).sendKeys(Keys.chord(Keys.CONTROL, "a"), password);
    }

    public void clickSubmit() {
        Driver.getDriver().findElement(By.xpath(submit)).click();
    }


    @Then("I can see Red Carpet Club {string} in upper right corner")
    public void iCanSeeRedCarpetClubLevelInUpperRightCorner(String level) {
        String statusText = Driver.getDriver().findElement(By.xpath(loginBox)).getText();
        Pattern pattern = Pattern.compile(level);
        Assert.assertTrue(pattern.matcher(statusText.toLowerCase()).find());
    }

    //log in black filed

    @When("I left blank {string} field")
    public void iLeftBlankLoginField(String field) throws InterruptedException {
        openLoginPanel();
        if (field == "login") {
            enterPassword(field);
            clickSubmit();
        } else if (field == "password") {
            enterLogin(field);
            clickSubmit();
        }
        TimeUnit.SECONDS.sleep(1);
    }

    @Then("I see {string} message")
    public void iSeeMessage(String message) {
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath(String.format(messageBox, message))).isDisplayed());
    }
}
