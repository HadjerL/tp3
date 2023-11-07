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

public class AuthTestPOM {
    static WebDriver driver;
    static Wait<WebDriver> wait;

    @BeforeClass
    public static void setUpBeforeClass(){
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("http://51.83.167.193:8080/");
    }
//    @Test
//    public void loginTest(){
//        Auth auth = new Auth(driver);
//        auth.enterValues("nabil","test");
//        auth.formSubmit();
//        WebElement title =driver.findElement(By.cssSelector("h2"));
//        wait.until(d->title.isDisplayed());
//        String titleValue = title.getText();
//        System.out.println(titleValue);
//        assertEquals("Recherche",titleValue);
//    }
    @Test
    public void failedLoginTest(){
        Auth auth = new Auth(driver);
        auth.enterValues("Joe","test");
        auth.formSubmit();
        WebElement errMsg = driver.findElement(By.cssSelector("h4"));
        wait.until(d->errMsg.isDisplayed());
        String errMessage = errMsg.getText();
        assertEquals("Bad credentials",errMessage);
    }
}