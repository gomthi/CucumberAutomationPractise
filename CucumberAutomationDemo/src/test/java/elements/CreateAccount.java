package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccount {
	
	@FindBy(id="email_create")
	public static WebElement txtEmail;
	
	@FindBy(id="SubmitCreate")
	public static WebElement btnCreateAccount;
	
	@FindBy(id="id_gender2")
	public static WebElement optionGender;
	
	@FindBy(id="customer_firstname")
	public static WebElement txtFirstName;
	
	@FindBy(id="customer_lastname")
	public static WebElement txtLastName;
	
	@FindBy(id="passwd")
	public static WebElement txtPassword;
	
	@FindBy(id="days")
	public static WebElement dropDownDay;
	
	@FindBy(id="months")
	public static WebElement dropDownMonth;
	
	@FindBy(id="years")
	public static WebElement dropDownYear;
	
	@FindBy(id="address1")
	public static WebElement txtAddress;
	
	@FindBy(id="city")
	public static WebElement txtCity;
	
	@FindBy(id="id_state")
	public static WebElement dropDownState;
	
	@FindBy(id="postcode")
	public static WebElement txtZipcode;
	
	@FindBy(id="id_country")
	public static WebElement dropDownCountry;
	
	@FindBy(id="phone_mobile")
	public static WebElement txtMobileNumber;
	
	@FindBy(id="submitAccount")
	public static WebElement btnSubmit;
	
	@FindBy(partialLinkText="Sign out")
	public static WebElement btnSignout;
	
}
