package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	
	@FindBy(id="email")
	public static WebElement txtUserName;
	
	@FindBy(id="passwd")
	public static WebElement txtPassword;
	
	@FindBy(id="SubmitLogin")
	public static WebElement btnLogin;
	
}
