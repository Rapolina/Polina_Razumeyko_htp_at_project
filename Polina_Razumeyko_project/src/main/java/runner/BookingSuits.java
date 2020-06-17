package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
      //  tags = {"@run"},
        glue = {"tests.cucumber.booking"},
        features = {"src/main/resources/features/booking/bookingHotels.feature"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE,
        strict = false)
public class BookingSuits {
}
