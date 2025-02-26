package StepDefinations;
import Pages.BasePage;
import Hooks.hooks;
import io.cucumber.java.en.And;
import org.testng.Assert;
import pages.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;


public class LoginSD {


    public BasePage basePage;
    public Login login;
    WebDriver driver;

    public LoginSD(){
        this.driver = hooks.driver;
        this.login = new Login(driver);
        this.basePage = new BasePage(driver);
    }
    @Given("User click on Get Started")
    public void userClickOn() {
        login.clickGetStarted();
    }

    @When("User waits for {long} milliseconds")
    public void userWaitsForMiliseconds(long time) {
      basePage.waitForMilliseconds(time);
    }

    @When("User Enters Username {string}")
    public void userEntersUsername(String mail) {
        login.enterEmail(mail);
    }

    @And("User enter a password {string}")
    public void userSetAPassword(String pwd) {
        login.enterpassword(pwd);

    }


    @And("User confirms the password {string}")
    public void userConfirmsThePassword(String pwd) {
        login.confirmPassword(pwd);
    }

    @Then("User clicks on Sign up")
    public void userClicksOnSignUp() {
        login.clickSignUp();
    }

    @When("User clicks on Already have an account link below")
    public void userClicksOnAlreadyHaveAnAccountLinkBelow() {
        login.clickSignInLink();
    }

    @Then("User clicks on SignIN Button")
    public void userClicksOnSignINButton() {
        login.clickSignIn();
    }



    @Then("{string} should be displayed on Successful login")
    public void shouldBeDisplayedOnSuccessfulLogin(String expectedText) {
        String actualText= login.getTextofSighnout();
        Assert.assertEquals(expectedText, actualText);
        System.out.println("ActualText"+actualText+ "  "+expectedText);
    }

    @Then("User Clicks on SignOut")
    public void userClicksOnSignOut() {
        login.clickSignOut();
    }

    @Then("{string} should be displayed on Sign Out")
    public void shouldBeDisplayedOnSignOut(String expectedText) {
        String actualText= login.getTextSignIn();
        Assert.assertEquals(expectedText, actualText);
        System.out.println("ActualText"+actualText+ "  "+expectedText);

    }

    @Then("An alert with message {string} should be displayed and accepted")
    public void anAlertWithMessageShouldBeDisplayedAndAccepted(String expectedMessage) {
        String actualMessage = basePage.getAlertTextAndAccept(10); // Use BasePage method
        Assert.assertEquals(expectedMessage, actualMessage);
        System.out.println("ActualText  "+actualMessage+ "  "+expectedMessage);
    }
}
