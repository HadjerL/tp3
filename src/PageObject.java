import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObject {
    protected WebDriver driver;

    public PageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
