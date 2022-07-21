package cucumber.glue.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

//Step definitions
public class TheInternetLoginPageStepDefs {

    @Given("user open the internet login page")
    public void userOpensLoginPage() {
        System.out.println("Hello world!");
    }

    @When("^user enters '(.*)' in login field and '{string}' in password$")//{string} это cucumber regular
    public void userEntersCredentials(String login, String password) {
        System.out.println(login + " " + password);
    }

    @And("clicks 'Login' button")
    public void clicksLoginButton() {
        System.out.println("Click login button");
    }

    @Then("user is logged in")
    public void userIsLoggedIn() {
        System.out.println("User is logged in");
    }

    @Then("user sees error message 'qweqweqwe'")
    public void userSeesErrorMessage() {
        System.out.println("Error message");
    }
}
