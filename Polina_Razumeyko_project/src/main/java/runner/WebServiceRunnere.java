package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"steps.cucumber.cucumber_ws_steps"},
        features = {"src/main/resources/features/web_service/WebServices"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE,
        strict = false)
public class WebServiceRunnere {
}
