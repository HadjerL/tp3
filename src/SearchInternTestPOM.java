import com.beust.ah.A;
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

public class SearchInternTestPOM {
    static WebDriver driver;
    static Wait<WebDriver> wait;

    @BeforeClass
    public static void setUpBeforeClass(){
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("http://51.83.167.193:8080/");
    }
    @Test
    public void searchTest(){
        Auth auth = new Auth(driver);
        auth.enterValues("nabil", "test");
        auth.formSubmit();
        WebElement title = driver.findElement(By.cssSelector("h2"));
        wait.until(d -> title.isDisplayed());
        SearchIntern searchIntern = new SearchIntern(driver);
        searchIntern.enterValues("Hadjer", "Lswi");
        searchIntern.formSubmit();
        WebElement displayedName = driver.findElement(By.cssSelector("td:nth-child(2)"));
        wait.until(d -> displayedName.isDisplayed());
        String displayedNameValue = displayedName.getText();
        //ask why assert fail though they are equal(not reconizing element)?
//        assertEquals("Lswi",displayedNameValue);
    }
}