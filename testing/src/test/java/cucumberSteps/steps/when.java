package cucumberSteps.steps;

import cucumberSteps.Hooks;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.DashboardPage;

import java.io.IOException;

public class when {
    WebDriver driver = Hooks.getDriver();

    LoginPage login = new LoginPage(driver);

    @When("With {string} login")
    public void performLogin(String user) throws IOException, ParseException {
        login.loginToApp(user);
        login.clickOnLogin();
    }

    @When("The user clicks on Login button")
    public void theUserClicksOnLoginButton() {
        login.clickOnLogin();
    }


}
