import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;

public class AuthTest2 {
    static WebDriver driver;


    @BeforeClass
    public static void openDriver(){
        driver = new EdgeDriver();
        driver.get("http://51.83.167.193:8080/");
    }
    @Test
    public void d(){
        WebElement userNameTextBox = driver.findElement(By.id("username"));
        WebElement passwordTextBox = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.cssSelector(".btn"));
        userNameTextBox.sendKeys("nabil");
        passwordTextBox.sendKeys("test");
        submitButton.submit();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement title = driver.findElement(By.cssSelector("h2"));
        wait.until(d -> title.isDisplayed());
        WebElement lastName = driver.findElement(By.name("lastName"));
        WebElement firstName = driver.findElement(By.name("firstName"));
        WebElement searchButton = driver.findElement(By.cssSelector(".btn-info"));
        lastName.sendKeys("Lswi");
        firstName.sendKeys("Hadjer");
        searchButton.submit();
        WebElement displayedName = driver.findElement(By.cssSelector("td:nth-child(2)"));
        wait.until(d -> displayedName.isDisplayed());
        String displayedNameValue = displayedName.getText();
        assertEquals("Lswi",displayedNameValue);
    }
}