import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AuthTest {
    static WebDriver driver;


    @BeforeClass
    public static void openDriver(){
        driver = new EdgeDriver();
        driver.get("http://51.83.167.193:8080/");
    }
    @Test
    public void a(){
        WebElement userNameTextBox = driver.findElement(By.id("username"));
        WebElement passwordTextBox = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.cssSelector(".btn"));
        userNameTextBox.sendKeys("nabil");
        passwordTextBox.sendKeys("test");
        submitButton.submit();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement title = driver.findElement(By.cssSelector("h2"));
        wait.until(d -> title.isDisplayed());
        String titleValue = title.getText();
        assertEquals("Recherche",titleValue);
    }
//    @Test
//    public void testWrongAth(){
//        WebDriver driver = new EdgeDriver();
//        driver.get("http://51.83.167.193:8080/");
//        WebElement userNameTextBox = driver.findElement(By.id("username"));
//        WebElement passwordTextBox = driver.findElement(By.id("password"));
//        WebElement submitButton = driver.findElement(By.cssSelector(".btn"));
//        userNameTextBox.sendKeys("invalid username");
//        passwordTextBox.sendKeys("invalid psw");
//        submitButton.submit();
//        Wait<WebDriver> wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//        WebElement errMsg = driver.findElement(By.cssSelector("h4"));
//        wait.until(d -> errMsg.isDisplayed());
//        String errorMessage = errMsg.getText();
//        assertEquals("Bad credentials",errorMessage);
//    }
    @Test
    public void b(){

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement addButton = driver.findElement(By.cssSelector(".btn-sm"));
        wait.until(d -> addButton.isDisplayed());
        addButton.click();
        WebElement title =driver.findElement(By.cssSelector("h1"));
        wait.until(d -> title.isDisplayed());
        String titleValue = title.getText();
        assertEquals("Nouveau Stagiaire",titleValue);
        WebElement civility = driver.findElement(By.name("civility"));
        WebElement lastName = driver.findElement(By.name("lastName"));
        WebElement name = driver.findElement(By.name("firstName"));
        WebElement address = driver.findElement(By.name("address"));
        WebElement birthDate = driver.findElement(By.name("birthDate"));
        WebElement country = driver.findElement(By.name("birthCountry.countryCode"));
        WebElement birthCity = driver.findElement(By.name("birthCity"));
        WebElement candy = driver.findElement(By.name("idCompany"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement phoneNum = driver.findElement(By.name("phone"));
        WebElement lastNameAr = driver.findElement(By.name("lastNameAr"));
        WebElement nameAr = driver.findElement(By.name("firstNameAr"));
        WebElement birthCityAr = driver.findElement(By.name("birthCityAr"));
        WebElement validateButton = driver.findElement(By.cssSelector(".btn-info"));
        civility.sendKeys("mm");
        lastName.sendKeys("Lswi");
        name.sendKeys("Hadjer");
        address.sendKeys("home");
        birthDate.sendKeys("1945-01-23");
        country.sendKeys("alg");
        birthCity.sendKeys("Medea");
        candy.sendKeys("c");
        email.sendKeys("email@gamil.com");
        phoneNum.sendKeys("099999");
        lastNameAr.sendKeys("no arabic keyboard");
        nameAr.sendKeys("same here");
        birthCityAr.sendKeys("same here too");
        validateButton.submit();
        WebElement displayedName = driver.findElement(By.cssSelector("td:nth-child(2)"));
        wait.until(d -> displayedName.isDisplayed());
        String displayedNameValue = displayedName.getText();
        assertEquals("Lswi",displayedNameValue);
    }
    @Test
    public void c(){

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement addButton = driver.findElement(By.cssSelector(".btn-sm"));
        wait.until(d -> addButton.isDisplayed());
        addButton.click();
        WebElement title =driver.findElement(By.cssSelector("h1"));
        wait.until(d -> title.isDisplayed());
        String titleValue = title.getText();
        assertEquals("Nouveau Stagiaire",titleValue);
        WebElement civility = driver.findElement(By.name("civility"));
        WebElement address = driver.findElement(By.name("address"));
        WebElement birthDate = driver.findElement(By.name("birthDate"));
        WebElement country = driver.findElement(By.name("birthCountry.countryCode"));
        WebElement birthCity = driver.findElement(By.name("birthCity"));
        WebElement candy = driver.findElement(By.name("idCompany"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement phoneNum = driver.findElement(By.name("phone"));
        WebElement lastNameAr = driver.findElement(By.name("lastNameAr"));
        WebElement nameAr = driver.findElement(By.name("firstNameAr"));
        WebElement birthCityAr = driver.findElement(By.name("birthCityAr"));
        WebElement validateButton = driver.findElement(By.cssSelector(".btn-info"));
        civility.sendKeys("mm");
        address.sendKeys("home");
        birthDate.sendKeys("1945-01-23");
        country.sendKeys("alg");
        birthCity.sendKeys("Medea");
        candy.sendKeys("c");
        email.sendKeys("email@gamil.com");
        phoneNum.sendKeys("099999");
        lastNameAr.sendKeys("no arabic keyboard");
        nameAr.sendKeys("same here");
        birthCityAr.sendKeys("same here too");
        validateButton.submit();
        List<WebElement> errMsg = driver.findElements(By.cssSelector(".form-group span"));
        wait.until(d->errMsg.get(0).isDisplayed());
        String errMessage = errMsg.get(0).getText();
        assertEquals("must not be blank\n" +
                "size must be between 2 and 50",errMessage);
    }

//    @After
//    public void endSession(){
//        driver.quit();
//    }
}