package Com.shoppersstack_TestScript;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ShoppersStack_GenericUtility.Base_Test;
import com.shoppersstack_POM.AddressFormPage;
import com.shoppersstack_POM.MyAddressesPage;
import com.shoppersstack_POM.MyProfilePage;

public class TC_001_verify_user_able_to_add_address_or_not extends Base_Test {
	@Test
	public void addAddresses() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		homepage.getAccountSettingsBtn().click();
		homepage.getMyProfileBtn().click();

		MyProfilePage myProfilePage = new MyProfilePage(driver);
		myProfilePage.getMyAddressesBtn().click();

		MyAddressesPage getMyAddressesPage = new MyAddressesPage(driver);
		getMyAddressesPage.getAddAddressBtn().click();

		AddressFormPage addressFromPage = new AddressFormPage(driver);
		addressFromPage.getOfficeRBtn().click();

		addressFromPage.getNameTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 0));
		addressFromPage.getHouseTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 1));
		addressFromPage.getStreetTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 2));
		addressFromPage.getLandmakrTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 3));

		webdriverUtiity.selectByValue(addressFromPage.getCountryDD(), fileUtility.readDataFromPropertyFile("country"));
		webdriverUtiity.selectByValue(addressFromPage.getStateDD(), fileUtility.readDataFromPropertyFile("state"));
		webdriverUtiity.selectByValue(addressFromPage.getCityDD(), fileUtility.readDataFromPropertyFile("city"));

		addressFromPage.getPincodeTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 4));
		addressFromPage.getPhoneNumberTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 5));
		addressFromPage.getAddAddressBtn().click();

		Thread.sleep(2000);
		getMyAddressesPage.getCloseBtn().click();

		webdriverUtiity.getWebPageScreenShot(driver);
	}

}
