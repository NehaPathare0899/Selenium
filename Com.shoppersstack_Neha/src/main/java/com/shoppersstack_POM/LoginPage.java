package com.shoppersstack_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage (WebDriver driver){
		
	
	PageFactory.initElements( driver,this);
		}
	@FindBy(id="Email")
       private WebElement emailTextField;
       
       @FindBy(id ="Password")
	private WebElement passwordTextField;
	
	  @FindBy(xpath ="//span[@class='MuiButton-label']")
		private WebElement loginBtn;

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
		
		 
	
}
