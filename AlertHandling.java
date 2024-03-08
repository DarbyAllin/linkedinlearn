import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class AlertHandling {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        String url = "https://www.rahulshettyacademy.com/AutomationPractice/";
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        driver.findElement(By.id("name")).sendKeys("John");
        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(2000);
        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.contains("John"));
        driver.switchTo().alert().accept();
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        driver.quit();

    }
}
