import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Assignment6 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String url = "https://www.rahulshettyacademy.com/AutomationPractice/";
        driver.get(url);
        driver.findElement(By.id("checkBoxOption3")).click();
        String labelVariable = driver.findElement(By.xpath("//input[@id = 'checkBoxOption3']/..")).getText();
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@id = 'dropdown-class-example']"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(labelVariable);
        WebElement inputField = driver.findElement(By.cssSelector("input#name"));
        driver.findElement(By.cssSelector("input#name")).sendKeys(labelVariable);
        wait.until(inputValueIs(inputField, labelVariable));
        driver.findElement(By.xpath("//input[@id = 'alertbtn']")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert= driver.switchTo().alert();
        if(alert.getText().contains(labelVariable))
            System.out.println("the text " + labelVariable + " is present in the alert window text");
        else
            System.out.println("the text " + labelVariable + " is not present in the alert window text");
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(3000);
        driver.quit();

    }
    private static ExpectedCondition<Boolean> inputValueIs(WebElement element, String expectedValue) {
        return driver -> element.getAttribute("value").equals(expectedValue);
    }
}
