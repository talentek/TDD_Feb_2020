package pack.UpsTest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pack.UpsActions.UpsLoginPageActions;
import pack.UpsDriver.UPSDriver;

public class UpsLoginTest extends UPSDriver {

	WebDriver driver = getChromeDriver();
	UpsLoginPageActions loginActions = new UpsLoginPageActions(this.driver);;
	final String URL = "https://www.ups.com/lasso/login?";

	@BeforeMethod
	public void beforeMethod() {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void loginErrorMsg() {

		loginActions.inputUserID("user");
		loginActions.inputPassword("pass");
		loginActions.submit();

		String errorText = loginActions.errorMsg();

		boolean bool;

		if (errorText.isEmpty()) {
			bool = false;
		} else {
			bool = true;
		}

		Assert.assertEquals(bool, true);

	}

	@AfterMethod
	public void afterTest() {

		driver.close();

	}
}
