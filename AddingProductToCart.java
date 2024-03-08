import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class AddingProductToCart {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://rahulshettyacademy.com/seleniumPractise/";
        driver.get(url);
        // String array of items that need to be added to cart
        String[] itemsToAddToCartArray = {"Brocolli", "Beetroot", "Beans", "Brinjal"};
        addItemsToCart(driver, itemsToAddToCartArray);
        WebElement cartIcon = driver.findElement(By.cssSelector("a.cart-icon img"));
        cartIcon.click();
        driver.findElement(By.xpath("//div[@class='action-block']/button[text()='PROCEED TO CHECKOUT']")).click();
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector(".promoBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
    }

    public static void addItemsToCart(WebDriver driver, String[] itemsToAddToCartArray){
        // get all product name elements in a list of webelements
        List<WebElement> productNames = driver.findElements(By.cssSelector("h4.product-name"));
        /* Now we will convert this String array into List
         * Arrays is a class which is present in java.util package which has methods to manipulate arrays
         * asList() method of Arrays class takes an array as a parameter and converts it into the list
         * this method is static. so we need to import Arrays class in our class to call it.
         */
        List itemsToAddToCartList = Arrays.asList(itemsToAddToCartArray);
        int j=0;
        for(int i = 0 ; i < productNames.size() ; i++){
            String productName = productNames.get(i).getText();
            String[] productNameSplittedArray= productName.split("-");
            String extractedProductName = productNameSplittedArray[0].trim();
            if(itemsToAddToCartList.contains(extractedProductName)){
                j++;
                driver.findElements(By.xpath("//h4[contains(text(), '" + extractedProductName + "')]/following-sibling::div/button[text()='ADD TO CART']")).get(0).click();
                if(j == itemsToAddToCartList.size())
                    break;
            }
        }
    }
}
