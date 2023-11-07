import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.*;

public class AddInternTestPOM {

    static Wait<WebDriver> wait;
    static  WebDriver driver;
    static String url = "http://51.83.167.193:8080/";
    Stagiaire s = new Stagiaire( "mm",
            "Lswi",
            "Hadjer",
            "home",
            "1945-01-23",
            "alg",
            "Medea",
            "c",
            "email@gamil.com",
            "099999",
            "no arabic keyboard",
            "same here",
            "same here too");

    @BeforeClass
    public static void setUpBeforeClass(){
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(url);
    }

    @Test
    public void addInternTest(){
        Auth auth = new Auth(driver);
        auth.enterValues("nabil","test");
        auth.formSubmit();
        //to wait for login first
        WebElement addButton = driver.findElement(By.cssSelector(".btn-sm"));
        wait.until(d -> addButton.isDisplayed());
        addButton.click();
        WebElement title =driver.findElement(By.cssSelector("h1"));
        wait.until(d -> title.isDisplayed());
        String titleValue = title.getText();
        System.out.println(titleValue);
        //verify we are in Nouveau stagiaire page
        assertEquals("Nouveau Stagiaire","Nouveau Stagiaire");
        //add intern
        AddIntern addIntern = new AddIntern(driver);


        addIntern.enterValues(s, true );
        addIntern.formSubmit();
        WebElement displayedName = driver.findElement(By.cssSelector("td:nth-child(2)"));
        wait.until(d->displayedName.isDisplayed());
        String displayedNameValue = displayedName.getText();
        System.out.println(displayedNameValue);
        assertEquals(s.getLastName(), displayedNameValue);
    }
    @Test
    public void informationLackedAddInternTest(){
        WebElement addButton = driver.findElement(By.cssSelector(".btn-sm"));
        wait.until(d -> addButton.isDisplayed());
        addButton.click();
        WebElement title =driver.findElement(By.cssSelector("h1"));
        wait.until(d -> title.isDisplayed());
        String titleValue = title.getText();
        //verify we are in Nouveau stagiaire page
        assertEquals("Nouveau Stagiaire",titleValue);
        //add intern
        AddIntern addIntern = new AddIntern(driver);
        addIntern.enterValues(s, false);
        addIntern.formSubmit();
        List<WebElement> errMsg = driver.findElements(By.cssSelector(".form-group span"));
        wait.until(d->errMsg.get(0).isDisplayed());
        String errMessage = errMsg.get(0).getText();
        assertEquals("must not be blank\n" +
                "size must be between 2 and 50",errMessage);
    }
}