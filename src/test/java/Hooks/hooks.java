package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class hooks {

    public static WebDriver driver;

     public hooks(){

     }
     public hooks(WebDriver driver){
        this.driver= driver;
     }

    @Before
    public void browsersetup() {
        System.out.println("User is in Homepage");
        System.setProperty("webdriver.chrome.driver", "target/Drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://xaltsocnportal.web.app");
    }



    @After
       public void tearDown() {
         driver.quit();

    }

//    @After
//    public void tearDown() {
//        if (driver != null) {
//            Duration timeout = Duration.ofSeconds(10);
//            WebDriverWait wait = new WebDriverWait(driver, timeout); // Adjust timeout as needed
//
//            // Wait for User Menu button to be clickable
//            WebElement userMenuButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@mattooltip='User menu']")));
//            userMenuButton.click();
//
//            // Wait for Logout button to be clickable
//            WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/span[text()='Logout']")));
//            logoutButton.click();
//
//            driver.quit();
//        }
//    }
}
