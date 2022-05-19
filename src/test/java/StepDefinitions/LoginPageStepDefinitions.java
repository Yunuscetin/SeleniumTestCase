package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Implementation.LoginPageImpl;

public class LoginPageStepDefinitions {
    LoginPageImpl loginPage = new LoginPageImpl();

    @Given("User navigate to n11.com")
    public void userNavigateToN11Com() {
        loginPage.getUrl("https://www.n11.com/giris-yap");
    }

    @When("Is the {string} element clickable?")
    public void isTheElementClickable(String element) {
        loginPage.isTheElementClickable(element);
    }
    @When("Is the {string} oriented correctly?")
    public void isTheInputOrientedCorrectly(String element) {
        loginPage.isTheInputOrientedCorrectly(element);
    }

    @When("User enters {string} and {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        loginPage.enterUsernameAndPassword(username, password);
    }

    @Then("User should not be logged in")
    public void userShouldNotBeLoggedIn() {
        loginPage.userNotBeLogin();
    }

    @Then("Error message is displayed for email")
    public void errorMessageIsDisplayedForEmail() {
        loginPage.errorMessageIsDisplayedForEmail();
    }

    @Then("Error message is displayed for {string}")
    public void errorMessageIsDisplayedForPassword(String password) {
        loginPage.errorMessageIsDisplayedForPassword(password);
    }

}
