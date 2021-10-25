package example.example.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/java/example/example/Features/AddAndRemoveUser.feature",
		glue = "example.example.stepDefinition"
		)
public class TestRunner  {

}
