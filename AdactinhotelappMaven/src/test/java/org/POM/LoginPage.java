package org.POM;


import java.io.IOException;

import org.Hotel.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage extends BaseClass {
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	

	@FindBy(id = "username")
	private WebElement txtUsername ;

	@FindBy(id = "password")
	private WebElement txtPassword;

	@FindBy(id="login")
	private WebElement btnLogin;


				public WebElement getTxtUsername() {
					return txtUsername;
				}
			
				public WebElement getTxtPassword() {
					return txtPassword;
				}
			
				public WebElement getBtnLogin() {
					return btnLogin;
				}
					
	
				
			public void login(String sheetName) throws IOException {
				
				
				elementSendKey(getTxtUsername(), getDataFromCell(sheetName, 1, 0));
				
			
				elementSendKey(getTxtPassword(), getDataFromCell(sheetName, 1, 1));
				
				elementClick(getBtnLogin());
				
			}
				
		
//
//public static void main(String[] args) {
//	WebDriverManager.chromedriver().setup();
//	WebDriver driver = new ChromeDriver();
//	driver.get("http://adactinhotelapp.com/");
//	
//	LoginPage lo = new LoginPage();
//	WebElement btnLogin2 = lo.getBtnLogin();
//	
//	btnLogin2.sendKeys("aaaaaaaa");
//	
//	driver.quit();
//	
//}




















}
