package stepDefinitions;

import genericUtilities.TextContextSetUp;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksSteps {
	
	TextContextSetUp testContextSetUp;
	public HooksSteps(TextContextSetUp testContextSetUp) {
		this.testContextSetUp=testContextSetUp;
	}
	
	@Before
	public void beforeScenario() {
		
		testContextSetUp.web.maximizeBrowser();

		long time = (Long)testContextSetUp. jutil.ConvertStringToAnyDataType(testContextSetUp.property.readdata("timeouts"), "long");
		testContextSetUp.web.waitTillElementFound(time);
		
	}
	
	@After
	public void afterScenario() {
		testContextSetUp.web.quitAllWindows();
	}

}
