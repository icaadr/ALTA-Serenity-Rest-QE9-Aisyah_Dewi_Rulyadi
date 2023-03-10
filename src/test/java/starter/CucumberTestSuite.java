package starter;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = "@Tugas or @Negative or @Positive",
        plugin = {"pretty"},
        features = "classpath:features/Reqres"
)
public class CucumberTestSuite {}
