package Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.logging.Logger;
;

public class BasePage {

    private static final Logger logger = Logger.getLogger(BasePage.class);
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(By locator) {
        try {
            return driver.findElement(locator);
        } catch (Exception e) {
            System.err.println("Error finding element with locator: " + locator + ". Error Message: " + e.getMessage());
            return null;
        }}


        public void Click(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            element.click();
        } catch (Exception e) {
            System.err.println("Error clicking element with locator: " + locator);
        }
    }

    public boolean isVisible(WebElement element) {
        try {
            Duration timeout = Duration.ofSeconds(10);
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (Exception error) {
            return false;
        }
    }

    public void sendKeys(By locator, String text) {
        try {
            WebElement element = driver.findElement(locator);
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            System.err.println("Error sending keys to element with locator: " + locator + ". Error Message: " + e.getMessage());
        }
    }

    public void clickIfExist(WebElement element) {
        if (isVisible(element)) {
            element.click();
        }
    }

    public void waitForVisibility(By locator) {
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void WaitForVisibility(WebElement element) {
            Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForMilliseconds(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.err.println("Wait interrupted: " + e.getMessage());
        }
    }

    public String getText(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.getText();
        } catch (Exception e) {
            System.err.println("Error getting text from element with locator: " + locator + ". Error Message: " + e.getMessage());
            return "";
        }
    }



//    public void captureScreenshot(String fileName) {
//        String filePath = "C:\\Users\\neo\\Desktop\\New folder\\AMN\\target\\Screenshot\\" + fileName + ".png";
//
//        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        File destFile = new File(filePath);
//
//        try {
//            FileUtils.copyFile(srcFile, destFile);
//            System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    public void captureScreenshot(String fileName) {
        String projectPath = System.getProperty("user.dir");
        String screenshotPath = projectPath + "/target/Screenshot/";
        File screenshotDir = new File(screenshotPath);
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = screenshotPath + fileName + "_" + timestamp + ".png";

        if (driver instanceof TakesScreenshot) {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File(filePath);

            try {
                FileUtils.copyFile(srcFile, destFile);
                logger.info("Screenshot saved at: " + destFile.getAbsolutePath());
            } catch (IOException e) {
                logger.severe("Error saving screenshot: " + e.getMessage());
                logger.severe("Exception details:"+ e); // Log the exception itself
            }
        } else {
            logger.severe("Driver does not support screenshots.");
        }
    }

    public String getAlertTextAndAccept(int timeoutSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText();
            alert.accept();
            return alertText;
        } catch (Exception e) {
            System.err.println("Error handling alert: " + e.getMessage());
            return null;
        }
    }
}
