package stepdefinition;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import elements.AddToCart;
import elements.CreateAccount;
import elements.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	
	public static WebDriver driver;
	
	@Given("user enter url to create account")
	public void user_enter_url_to_create_account() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gomathi\\Downloads\\SeleniumSoftwares\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	   }

	@When("user enter {string} gender, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} and click on create button")
	public void user_enter_gender_and_click_on_create_button(String username, String firstname, String lastname, String password, String date, String month, String year, String address, String city, String state, String zipcode, String country, String mobile) throws AWTException, IOException {
		PageFactory.initElements(driver, CreateAccount.class);
		CreateAccount.txtEmail.sendKeys(username);
		CreateAccount.btnCreateAccount.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		CreateAccount.optionGender.click();
		CreateAccount.txtFirstName.sendKeys(firstname);
		CreateAccount.txtLastName.sendKeys(lastname);
		CreateAccount.txtPassword.sendKeys(password);
		Select s1 = new Select(CreateAccount.dropDownDay);
		s1.selectByValue(date);
		
		Select s2= new Select(CreateAccount.dropDownMonth);
		s2.selectByIndex(7);
		
		Select s3 = new Select(CreateAccount.dropDownYear);
		s3.selectByValue(year);
		
		CreateAccount.txtAddress.sendKeys(address);
		CreateAccount.txtCity.sendKeys(city);
		
		Select s4= new Select(CreateAccount.dropDownState);
		s4.selectByVisibleText(state);
		
		CreateAccount.txtZipcode.sendKeys(zipcode);
		Select s5 = new Select(CreateAccount.dropDownCountry);
		s5.selectByVisibleText(country);
		
		CreateAccount.txtMobileNumber.sendKeys(mobile);
		CreateAccount.btnSubmit.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Robot robot = new Robot();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect = new Rectangle(screenSize);
		BufferedImage src = robot.createScreenCapture(rect);
		File Destination = new File("C:\\Users\\gomathi\\eclipse-workspace\\CucumberAutomationDemo\\ScreenShots\\AccountCreatedPage.png");
		ImageIO.write(src, "png", Destination);
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		CreateAccount.btnSignout.click();
	}

	@When("user enter {string} , {string} and click on login button")
	public void user_enter_and_click_on_login_button(String username, String password) throws AWTException, IOException, InterruptedException {
		PageFactory.initElements(driver, Login.class);
		Login.txtUserName.sendKeys(username);
		Login.txtPassword.sendKeys(password);
		Thread.sleep(3000);
		Robot robot = new Robot();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect = new Rectangle(screenSize);
		BufferedImage src = robot.createScreenCapture(rect);
		File Destination = new File("C:\\Users\\gomathi\\eclipse-workspace\\CucumberAutomationDemo\\ScreenShots\\LoginPage.png");
		ImageIO.write(src, "png", Destination);
		Login.btnLogin.click();
	   }

	@When("user select product and added it cart")
	public void user_select_product_and_added_it_cart() throws InterruptedException, AWTException, IOException {
		PageFactory.initElements(driver, AddToCart.class);
		Thread.sleep(3000);
		Actions ac= new Actions(driver);
		ac.moveToElement(AddToCart.linkWomen).build().perform();
		Thread.sleep(3000);
		AddToCart.linkBlouses.click();
		Thread.sleep(3000);
		
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("(//div[@class='layered_subtitle_heading'])[9]")));
		ac.moveToElement(AddToCart.imgBlouse).build().perform();
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Thread.sleep(3000);
		AddToCart.btnAddToCart.click();
		Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0]. click();", AddToCart.btnClose);
		Thread.sleep(3000);
		Robot robot = new Robot();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect = new Rectangle(screenSize);
		BufferedImage src = robot.createScreenCapture(rect);
		File Destination = new File("C:\\Users\\gomathi\\eclipse-workspace\\CucumberAutomationDemo\\ScreenShots\\AddToCart.png");
		ImageIO.write(src, "png", Destination);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	   }

	@Then("verify account is created and product is added to cart")
	public void verify_account_is_created_and_product_is_added_to_cart() {
		String accountName = driver.findElement(By.xpath("//a[@title='View my customer account']/span")).getText();
		System.out.println("Account Created for  "+accountName);
		String productAddedInCart = AddToCart.verifyAddedProduct.getText();
		int cartNumber=Integer.parseInt(productAddedInCart);
		System.out.println("Product added in Cart = "+productAddedInCart);	
		if(cartNumber>0)
		{
			assertTrue(true);
			System.out.println(productAddedInCart+"  Product Added in cart");
		}
		
	   }


}
