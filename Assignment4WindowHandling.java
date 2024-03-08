import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Assignment4WindowHandling {
    public static void main(String[] args){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://the-internet.herokuapp.com/";
        driver.get(url);
        driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> windowIdentifier = driver.getWindowHandles();
        Iterator<String> itr =windowIdentifier.iterator();
        String parentId = itr.next();
        String childId = itr.next();
        driver.switchTo().window(childId);
        String childWindowText = driver.findElement(By.cssSelector("div.example h3")).getText();
        System.out.println(childWindowText);
        driver.switchTo().window(parentId);
        String parentWindowText = driver.findElement(By.cssSelector("div.example h3")).getText();
        System.out.println(parentWindowText);
    }
}
