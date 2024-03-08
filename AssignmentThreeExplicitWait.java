import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class AssignmentThreeExplicitWait {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String url = "https://rahulshettyacademy.com/loginpagePractise/";
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(url);
        String userName = "rahulshettyacademy";
        String password = "learning";
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//span[contains(text(), 'User')]/following-sibling::span[@class='checkmark']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#okayBtn"))).click();
        WebElement dropDownElement = driver.findElement(By.cssSelector("select.form-control"));
        Select dropDown = new Select(dropDownElement);
        dropDown.selectByVisibleText("Consultant");
        driver.findElement(By.cssSelector("input#terms")).click();
        driver.findElement(By.id("signInBtn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Checkout')]")));
        String[] itemsToAddArray = {"iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry"};
        addToCart(driver, itemsToAddArray);
        driver.findElement(By.xpath("//a[contains(text(), 'Checkout')]")).click();
        Thread.sleep(5000);
        driver.quit();
    }

    public static void addToCart(WebDriver driver, String[] itemsToAddArray){
        List<WebElement> productNamesElements = driver.findElements(By.xpath("//h4[@class='card-title']"));
        List itemsToAddList = Arrays.asList(itemsToAddArray);
        int j=0;
        for(int i = 0 ; i < productNamesElements.size() ; i++){
            String productName = productNamesElements.get(i).getText();
            if(itemsToAddList.contains(productName)){
                j++;
                driver.findElements(By.xpath("//div[@class='card-footer']/button[contains(text(), 'Add')]")).get(i).click();
                if(j == itemsToAddList.size())
                    break;
            }
        }

 }
}
