package tests.cucumber.web_service;

import com.google.gson.Gson;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import steps.utils.webservice.Data;
import steps.utils.webservice.GetDataUtils;
import steps.utils.webservice.Search;
import web_driver.Driver;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;


public class WebServiceTest {
    public static final String WEB_SERVICE = "src/main/resources/properties";
    public static final String SEARCH_ALL_USERS = "src/main/resources/properties/searchAllUsers.json";
    public static final String PARTIAL_NAME_SHORT = "/src/main/resources/properties/partialNameShort.json";
    public static final String PARTIAL_NAME_LONG = "src/main/resources/properties/partialNameLong.json";
    public static final String FULL_NAME_SHORT = "src/main/resources/properties/fullNameShort.json";
    public static final String FULL_NAME_LONG = "src/main/resources/properties/fullNameLong.json";


    static Gson gson;
    static Properties properties;
    static Search search;
    static Data result;
    static Data response;
    private GetDataUtils GetDataUtils;

    @Before
    public void beforeMethod() throws IOException {
        gson = new Gson();
        GetDataUtils = new GetDataUtils();
        properties = Driver.getProperties(WEB_SERVICE);
    }

    @Given("I check all json users")
    public void checkAllUsers() throws IOException, URISyntaxException {
        search = GetDataUtils.getDataSearch(gson, 0, properties);
        result = GetDataUtils.getResultData(gson, search);
        response = GetDataUtils.getResponseData(gson, properties, SEARCH_ALL_USERS);
        Assert.assertTrue(GetDataUtils.getResult(result, response));
    }

    @Then("I verify users by partial name short ")
    public void partialNameShort() throws IOException, URISyntaxException {
        search = GetDataUtils.getDataSearch(gson, 1, properties);
        result = GetDataUtils.getResultData(gson, search);
        response = GetDataUtils.getResponseData(gson, properties, PARTIAL_NAME_SHORT);
        Assert.assertTrue(GetDataUtils.getResult(result, response));
    }

    @Then("I verify users by partial name long")
    public void partialNameLong() throws IOException, URISyntaxException {
        search = GetDataUtils.getDataSearch(gson, 2, properties);
        result = GetDataUtils.getResultData(gson, search);
        response = GetDataUtils.getResponseData(gson, properties, PARTIAL_NAME_LONG);
        Assert.assertTrue(GetDataUtils.getResult(result, response));
    }

    @Then("I verify users by full name short")
    public void setFullNameShort() throws IOException, URISyntaxException {
        search = GetDataUtils.getDataSearch(gson, 3, properties);
        result = GetDataUtils.getResultData(gson, search);
        response = GetDataUtils.getResponseData(gson, properties, FULL_NAME_SHORT);
        Assert.assertTrue(GetDataUtils.getResult(result, response));
    }

    @Then("I verify users by full name long")
    public void setFullNameLong() throws IOException, URISyntaxException {
        search = GetDataUtils.getDataSearch(gson, 4, properties);
        result = GetDataUtils.getResultData(gson, search);
        response = GetDataUtils.getResponseData(gson, properties, FULL_NAME_LONG);
        Assert.assertTrue(GetDataUtils.getResult(result, response));
    }

    @After
    public void afterMethod() {
        Driver.destroy();
        Driver.driver.remove();
    }
}

