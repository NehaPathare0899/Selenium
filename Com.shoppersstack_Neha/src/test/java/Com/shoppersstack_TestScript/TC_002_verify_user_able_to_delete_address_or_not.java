package Com.shoppersstack_TestScript;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ShoppersStack_GenericUtility.Base_Test;
import com.shoppersstack_POM.MyAddressesPage;
import com.shoppersstack_POM.MyProfilePage;

public class TC_002_verify_user_able_to_delete_address_or_not extends Base_Test {

	@Test
	public void deleteAddress() throws InterruptedException, IOException {
		homepage.getAccountSettingsBtn().click();
		homepage.getMyProfileBtn().click();

		MyProfilePage myProfilePage = new MyProfilePage(driver);
		myProfilePage.getMyAddressesBtn().click();
		Thread.sleep(2000);
		MyAddressesPage myAddressesPage = new MyAddressesPage(driver);
		myAddressesPage.getDeleteBtn().click();
		myAddressesPage.getYesBtn().click();

		Thread.sleep(2000);
		driver.switchTo().alert().accept();

		Thread.sleep(2000);
		webdriverUtiity.getWebPageScreenShot(driver);

	}
}
