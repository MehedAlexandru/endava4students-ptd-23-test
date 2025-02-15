package cucumberSteps.steps;

import cucumberSteps.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.DashboardPage;
import pages.TravelDetailsPage;

import java.io.IOException;

public class given {
    WebDriver driver = Hooks.getDriver();

    LoginPage login = new LoginPage(driver);

    @Given("The application has started on the login page")
    public void loginPageHasLoaded() {
        login = new LoginPage(driver);
        login.loadBaseUrl();
        Assert.assertTrue(login.isLoginPage());
    }


    @Given("The user doesn't have an account")
    public void theUserDoesntHaveAnAccount() {
        login = new LoginPage(driver);
        login.failedLogin();
        login.clickOnLogin();
        Assert.assertTrue(login.errorMessage());
    }
}