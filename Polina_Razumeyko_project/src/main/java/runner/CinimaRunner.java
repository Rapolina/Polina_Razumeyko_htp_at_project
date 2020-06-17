package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"steps.cinema"},
        features = {"src/main/resources/features/cinema/cinema.feature"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE,
        strict = false)
public class CinimaRunner {

}
