import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchIntern extends PageObject{
    @FindBy(name = "firstName") private WebElement firstName;
    @FindBy(name= "lastName") private WebElement lastName;
    public SearchIntern(WebDriver driver){
        super(driver);
    }
    public void enterValues(String firstName, String lastName){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
    }
    public void formSubmit(){
        this.firstName.submit();
    }
}
