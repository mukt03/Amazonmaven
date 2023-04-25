package Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import module.Account_Hidden_dropDownMenu;
import module.AddToCart_HiddenPage;
import page.Home_Page;
import page.ProductPage;
import page.SearchPage;
import page.SignIn;

public class Test3 {
public static void main(String[] args) {
	//Add To Cart Functionality
	ChromeOptions options= new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	System.setProperty("webdriver.chrome.driver","C:\\Users\\MUKTA\\Documents\\velocity testing12 nov\\Selenium\\selenium installation\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver= new ChromeDriver(options);
	driver.navigate().to("https://www.amazon.in");
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	Home_Page homePage= new Home_Page(driver);
    homePage.moveToAccountandList();
    Account_Hidden_dropDownMenu accountDropDown= new Account_Hidden_dropDownMenu(driver);
    accountDropDown.clickSignIn();
    SignIn signIn=new SignIn(driver);
    signIn.sendEmailOrPhoneNo();
    signIn.clickContinue();
    
    signIn.enterPassword();
  signIn.clickSignInButton();
  
  homePage.writeInsearchbox();
  homePage.clickOnSearchButton();
  SearchPage searchPage=new SearchPage(driver);
  searchPage.scrollAndClickAmazonsChoice();
  ProductPage productPage=new ProductPage(driver);
  productPage.clickOnAddToCart();
 // AddToCart_HiddenPage proceedCheckout=new AddToCart_HiddenPage(driver);
 // proceedCheckout.clickProceedToCheckout();
}
} 
