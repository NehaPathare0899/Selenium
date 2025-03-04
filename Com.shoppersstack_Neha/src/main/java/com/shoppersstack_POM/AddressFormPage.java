package com.shoppersstack_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressFormPage {

	public AddressFormPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Office")
	private WebElement officeRBtn;

	public WebElement getOfficeRBtn() {
		return officeRBtn;
	}

	@FindBy(id = "Name")
	private WebElement nameTextField;

	@FindBy(id = "House/Office Info")
	private WebElement houseTextField;

	@FindBy(id = "Street Info")
	private WebElement streetTextField;

	@FindBy(id = "Landmark")
	private WebElement landmakrTextField;

	@FindBy(id = "Country")
	private WebElement countryDD;

	@FindBy(id = "State")
	private WebElement stateDD;

	@FindBy(id = "City")
	private WebElement cityDD;

	@FindBy(id = "Pincode")
	private WebElement pincodeTextField;

	@FindBy(id = "Phone Number")
	private WebElement phoneNumberTextField;

	@FindBy(id = "addAddress")
	private WebElement addAddressBtn;

	public WebElement getNameTextField() {
		return nameTextField;
	}

	public WebElement getHouseTextField() {
		return houseTextField;
	}

	public WebElement getStreetTextField() {
		return streetTextField;
	}

	public WebElement getLandmakrTextField() {
		return landmakrTextField;
	}

	public WebElement getCountryDD() {
		return countryDD;
	}

	public WebElement getStateDD() {
		return stateDD;
	}

	public WebElement getCityDD() {
		return cityDD;
	}

	public WebElement getPincodeTextField() {
		return pincodeTextField;
	}

	public WebElement getPhoneNumberTextField() {
		return phoneNumberTextField;
	}

	public WebElement getAddAddressBtn() {
		return addAddressBtn;
	}

}
