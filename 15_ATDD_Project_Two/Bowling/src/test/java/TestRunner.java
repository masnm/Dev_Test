import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {
				"src/test/java/features/OneSimpleFrame.feature",
			  	"src/test/java/features/SimpleSecondFrame.feature",
				"src/test/java/features/FirstFrameSpare.feature",
			  	"src/test/java/features/FirstFrameStrike.feature",
			  	"src/test/java/features/NormalSpareNormal.feature",
			  	"src/test/java/features/NormalSpareSpareNormal.feature",
			  	"src/test/java/features/NormalStrikeNormal.feature",
			  	"src/test/java/features/NormalStrikeStrikeNormal.feature",
				},
		glue = { "steps" }
		)
public class TestRunner {
}
