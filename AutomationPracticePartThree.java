import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationPracticePartThree {
    public static void main(String[] args){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.rahulshettyacademy.com/AutomationPractice/";
        driver.get(url);
        System.out.println(driver.findElement(By.xpath("//header/div/a/button")).getText());
        System.out.println(driver.findElement(By.xpath("//header/div/a/button/parent::a/following-sibling::button[3]")).getText());
        System.out.println(driver.findElement(By.xpath("//header/div/a/button/parent::a/parent::div/parent::header//button[text()='Signup']")).getText());
    }
}
