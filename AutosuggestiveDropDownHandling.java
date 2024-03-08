import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AutosuggestiveDropDownHandling {
    public static void main(String[] args){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://rahulshettyacademy.com/dropdownsPractise/";
        driver.get(url);
        driver.findElement(By.id("autosuggest")).sendKeys("ar");
        WebElement dropDown = driver.findElement(By.cssSelector("ul#ui-id-1"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(dropDown));
        List<WebElement> countryElements = driver.findElements(By.cssSelector("li.ui-menu-item a"));
        for(int i = 0; i < countryElements.size(); i++){
            if(countryElements.get(i).getText().equalsIgnoreCase("Argentina")){
                countryElements.get(i).click();
                break;
            }
        }
    }
}
