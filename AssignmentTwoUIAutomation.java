import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class AssignmentTwoUIAutomation {
    public static void main(String[] args){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://rahulshettyacademy.com/angularpractice/";
        driver.get(url);
        WebElement nameInputField = driver.findElement(By.cssSelector("div.form-group input[name='name']"));
        nameInputField.sendKeys("Gina Carno");
        WebElement emailInputField = driver.findElement(By.cssSelector("div.form-group input[name='email']"));
        emailInputField.sendKeys("ginacarno126@cmail.com");
        WebElement passwordInputField = driver.findElement(By.cssSelector("div.form-group input[type='password']"));
        passwordInputField.sendKeys("wellbeing123");
        WebElement checkBox = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']/preceding-sibling::input"));
        checkBox.click();
        WebElement genderDropDown = driver.findElement(By.cssSelector("#exampleFormControlSelect1"));
        Select select = new Select(genderDropDown);
        select.selectByVisibleText("Female");
        WebElement studentRadioButton = driver.findElement(By.xpath("//label[text()='Employment Status: ']/following-sibling::div[@class='form-check form-check-inline']/input[@id='inlineRadio1']"));
        studentRadioButton.click();
        // Birth date by using send keys
        driver.findElement(By.cssSelector("input[name='bday']")).sendKeys("08101995");
        WebElement submitButton = driver.findElement(By.cssSelector("input.btn.btn-success"));
        submitButton.click();
        WebElement sucessMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible' and contains(., 'The Form has been submitted successfully!')]"));
        System.out.println(sucessMessage.getText());
        driver.quit();

    }
}
