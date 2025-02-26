package pages;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Login extends BasePage {


    public By GetStarted = By.xpath("//button[text()='Get Started']");
    public By EmailInputBox = By.xpath("//label[text()='E-Mail']/following-sibling::div/input");
    public By EnterPassword = By.xpath("//label[text()='Password']/following-sibling::div/input");
    public By ConfirmPassword = By.xpath("//label[text()='Confirm Password']/following-sibling::div/input");
    public By SignUp = By.xpath("//button[text()='Sign Up']");
    public By SignInLink = By.xpath("//button[text()='Already have an account? Click here to sign in.']");
    public By SignIn = By.xpath("//button[text()='Sign In']");
    public By SignOut = By.xpath("//button[text()='Sign Out']");

    public Login(WebDriver driver) {
        super(driver);
    }



    public void clickGetStarted(){
        Click(GetStarted);
    }

    public void enterEmail(String Email){
        sendKeys(EmailInputBox, Email);
    }

    public void enterpassword(String password){
        sendKeys(EnterPassword,  password);
    }

    public void confirmPassword(String password){
        sendKeys(ConfirmPassword, password);
    }

    public void clickSignUp(){
        Click(SignUp);
    }

    public void clickSignInLink(){
        waitForVisibility(SignInLink);
        Click(SignInLink);
    }

    public void clickSignIn(){
        waitForVisibility(SignIn);
        Click(SignIn);
    }

    public String getTextofSighnout(){
        return  getText(SignOut);
    }

    public String getTextSignIn(){
        waitForVisibility(SignIn);
        return getText(SignIn);
    }

    public void clickSignOut(){
        Click(SignOut);
    }


}