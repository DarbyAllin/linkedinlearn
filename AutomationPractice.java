import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AutomationPractice {
    public static void main(String[] args){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("sam");
        driver.findElement(By.name("inputPassword")).sendKeys("abc123");
        driver.findElement(By.cssSelector("button.submit.signInBtn")).click();
        String actualErrorMessage = driver.findElement(By.cssSelector("p.error")).getText();
        System.out.println(actualErrorMessage);
        driver.findElement(By.cssSelector("div[class*='pwd-container']")).click();
        driver.findElement(By.xpath("//form/input[@type='text']")).sendKeys("sam");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("fgh@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9897654321");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String actualLoginMessage = driver.findElement(By.cssSelector(".infoMsg")).getText();
        System.out.println(actualLoginMessage);
        driver.findElement(By.xpath("//button[text()='Go to Login']")).click();
        // sign in with valid password
        driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("sam");
        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
        // checking the check box Remember my username
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.cssSelector("button[class*='submit'")).click();
        driver.quit();


    }

}