import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddIntern extends  PageObject{
    @FindBy(name = "civility") private WebElement civility;
    @FindBy(name = "lastName") private WebElement lastName;
    @FindBy(name = "firstName") private WebElement firstName;
    @FindBy(name = "address") private WebElement address;
    @FindBy(name = "birthDate") private WebElement birthDate;
    @FindBy(name = "birthCountry.countryCode") private WebElement birthCountry;
    @FindBy(name = "birthCity") private WebElement birthCity;
    @FindBy(name = "idCompany") private WebElement idCompany;
    @FindBy(name = "email") private WebElement email;
    @FindBy(name = "phone") private WebElement phone;
    @FindBy(name = "lastNameAr") private WebElement lastNameAr;
    @FindBy(name = "firstNameAr") private WebElement firstNameAr;
    @FindBy(name = "birthCityAr") private WebElement birthCityAr;

    public AddIntern(WebDriver driver) {
        super(driver);
    }


    public void enterValues(Stagiaire stagiare, boolean sendAll){
        this.civility.sendKeys(stagiare.getCivility());
        if (sendAll) {
                    this.lastName.sendKeys(stagiare.getLastName());
        this.firstName.sendKeys(stagiare.getFirstName());
        }

        this.address.sendKeys(stagiare.getAddress());
        this.birthDate.sendKeys(stagiare.getBirthDate());
        this.birthCountry.sendKeys(stagiare.getBirthCountry());
        this.birthCity.sendKeys(stagiare.getBirthCity());
        this.idCompany.sendKeys(stagiare.getIdCompany());
        this.email.sendKeys(stagiare.getEmail());
        this.phone.sendKeys(stagiare.getPhone());
        this.lastNameAr.sendKeys(stagiare.getLastNameAr());
        this.firstNameAr.sendKeys(stagiare.getFirstNameAr());
        this.birthCityAr.sendKeys(stagiare.getBirthCityAr());
    }

    public void formSubmit(){
        this.birthCityAr.submit();
    }
}
