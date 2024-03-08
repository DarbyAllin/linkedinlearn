import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AutomationPracticePartTwo {
    public static void main(String[] args){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String name = "sam";
        String password = getPassword(driver);
        //String password = "rahulshettyacademy";
        driver.findElement(By.cssSelector("input#inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.cssSelector("button.submit.signInBtn")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='You are successfully logged in.']")));
        String actualSucessMessage = driver.findElement(By.xpath("//p[text()='You are successfully logged in.']")).getText();
        String expectedSucessMessage = "You are successfully logged in.";
        System.out.println("Application response is: " +  actualSucessMessage);
        System.out.println("Expected response is: " +  expectedSucessMessage);
        Assert.assertTrue(actualSucessMessage.equals(expectedSucessMessage));
        // logging out
        driver.findElement(By.cssSelector(".logout-btn")).click();
        // logging back in
        driver.findElement(By.cssSelector("input#inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.cssSelector("button.submit.signInBtn")).click();
        // assertion of gretting text
        String actualGrettingText = driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText();
        String expectedGrettingText = "Hello sam,";
        Assert.assertEquals(actualGrettingText, expectedGrettingText,"invalid greeting text spotted " );
        // logging out
        driver.findElement(By.cssSelector(".logout-btn")).click();
        driver.quit();
    }

    public static String getPassword(WebDriver driver){
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.cssSelector("div[class*='pwd-container']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".reset-pwd-btn")));
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordText = driver.findElement(By.cssSelector(".infoMsg")).getText();
        //Please use temporary password 'rahulshettyacademy' to Login. this is the the text we get affter clicking reset login button
        //rahulshettyacademy this is password.

        String[] passwordArrayText = passwordText.split("'");
        String[] passwordArray = passwordArrayText[1].split("'");
        String password = passwordArray[0];
        driver.findElement(By.xpath("//button[text()='Go to Login']")).click();
        return password;
    }
}