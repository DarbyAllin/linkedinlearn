import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Assignement7WebTables {
    public static void main(String[] args){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://www.rahulshettyacademy.com/AutomationPractice/";
        driver.get(url);
        WebElement table = driver.findElement(By.cssSelector("div.left-align table#product"));
        System.out.println("total number of rows are: "+ table.findElements(By.tagName("tr")).size());
        System.out.println("total number of columns are: "+ table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
        // printing second row
        List<WebElement> secondRowData = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
        for(WebElement data: secondRowData){
             System.out.println(data.getText());
        }
        driver.quit();
    }

}
