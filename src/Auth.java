import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Auth extends  PageObject{
    @FindBy(id="username") private WebElement userName;
    @FindBy(id="password") private WebElement password;
    public Auth(WebDriver driver) {
        super(driver);
    }
    public void enterValues(String userName, String password){
        this.userName.sendKeys(userName);
        this.password.sendKeys(password); }
    public void formSubmit(){
        password.submit();
    }
}
