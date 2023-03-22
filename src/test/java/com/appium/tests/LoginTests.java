/**
 * @author Rajat Verma
 * https://www.linkedin.com/in/rajat-v-3b0685128/
 * https://github.com/rajatt95
 * https://rajatt95.github.io/
 *
 * Course: Appium Mobile Automation - Android & iOS + Frameworks + CICD (https://www.udemy.com/course/the-complete-appium-course-for-ios-and-android/)
 * Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)
 */

/***************************************************/

package com.appium.tests;

import static com.appium.constants.FrameworkConstants.TEST_DATA_JSON_FILE;
import static com.appium.constants.FrameworkConstants.TEST_DATA_JSON_INVALID_PASSWORD;
import static com.appium.constants.FrameworkConstants.TEST_DATA_JSON_VALID_USER;
import static com.appium.constants.FrameworkConstants.EXPECTED_DATA_KEY_PRODUCT_TITLE;
import static com.appium.constants.FrameworkConstants.TEST_DATA_JSON_INVALID_USER;
import static com.appium.constants.FrameworkConstants.TEST_DATA_JSON_PASSWORD;
import static com.appium.constants.FrameworkConstants.TEST_DATA_JSON_USERNAME;
import static com.appium.constants.FrameworkConstants.EXPECTED_DATA_KEY_ERR_INAVLID_CREDENTIALS;

import java.lang.reflect.Method;

import org.json.JSONObject;
import org.testng.annotations.*;

import com.appium.annotations.FrameworkAnnotation;
import com.appium.base.BaseTest;
import com.appium.enums.AuthorType;
import com.appium.enums.CategoryType;
import com.appium.manager.StringsManager;
import com.appium.pages.LoginPage;
import com.appium.pages.ProductsPage;
import com.appium.utils.JSONUtils;
import com.appium.utils.TestUtils;
import com.appium.utils.VerificationUtils;

public class LoginTests extends BaseTest {

	LoginPage loginPage;
	ProductsPage productsPage;
	JSONObject loginUsers;

	@AfterClass
	public void afterClass() {
		closeApp();
	}

	@BeforeMethod
	public void beforeMethod(Method method) {

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: " + method.getName() + "*******************");

		loginPage = new LoginPage();
		// productsPage = new ProductsPage();
	}

	@AfterMethod
	public void afterMethod(Method method) {
		TestUtils.log().debug("*****************  ** Test ended: " + method.getName() + "*******************");
		TestUtils.log().debug("---------------------------------------------------");
		// closeApp();
		// launchApp();u''&&

	}

//	@DataProvider
//	public Object[][] getProductDataForAdd() {
//		String s = "AppConstants.ADDARTICLES_SHEET_NAME";
//		Object usersData[][] = TestUtil.getTestData(s);
//		return usersData;
//	}

	@FrameworkAnnotation(author = { AuthorType.ERIKA }, category = { CategoryType.SMOKE,
			CategoryType.SANITY, CategoryType.REGRESSION })
	@Test(groups = { "SANITY", "SMOKE", "REGRESSION" ,"invalidUserName"},priority=1)
	public void invalidUserName() {

		JSONObject jsonObject_InvalidUser = 
				new JSONUtils()
					.getJSONObject(TEST_DATA_JSON_FILE)
					.getJSONObject(TEST_DATA_JSON_INVALID_USER);
		
		String username = jsonObject_InvalidUser.getString(TEST_DATA_JSON_USERNAME).toString();
		String password = jsonObject_InvalidUser.getString(TEST_DATA_JSON_PASSWORD).toString();
		
		loginPage.loginClick().connectClick().
			enterUsername(username).
			enterPassword(password).
			pressLoginBtn();

		String actualErrTxt = loginPage.getErrorTxt();
		String expectedErrTxt = StringsManager.getStrings()
				.get(EXPECTED_DATA_KEY_ERR_INAVLID_CREDENTIALS);
		VerificationUtils.validate(actualErrTxt, expectedErrTxt, "Message d'erreur pour un mail incorrect");
	}

	@FrameworkAnnotation(author = { AuthorType.ERIKA }, category = { CategoryType.REGRESSION })
	@Test(groups = { "SANITY", "BVT", "REGRESSION","invalidPassword" },priority=2)
	public void invalidPassword() {

		JSONObject jsonObject_InvalidUser =
				new JSONUtils()
					.getJSONObject(TEST_DATA_JSON_FILE)
					.getJSONObject(TEST_DATA_JSON_INVALID_PASSWORD);

		String username = jsonObject_InvalidUser.getString(TEST_DATA_JSON_USERNAME).toString();
		String password = jsonObject_InvalidUser.getString(TEST_DATA_JSON_PASSWORD).toString();

		loginPage.pressModifierBtn().
			enterUsername(username).
			enterPassword(password).
			pressLoginBtn();

		String actualErrTxt = loginPage.getErrorTxt();
		String expectedErrTxt = StringsManager.getStrings()
				.get(EXPECTED_DATA_KEY_ERR_INAVLID_CREDENTIALS);

		VerificationUtils.validate(actualErrTxt, expectedErrTxt, "Message d'erreur pour un mail incorrect");
	}

	@FrameworkAnnotation(author = { AuthorType.ERIKA }, category = { CategoryType.SANITY,
			CategoryType.BVT, CategoryType.REGRESSION })
	@Test(groups = { "SANITY","successfulLogin" },priority=3)
	public void successfulLogin() {

		JSONObject jsonObject_ValidUser =
				new JSONUtils()
					.getJSONObject(TEST_DATA_JSON_FILE)
					.getJSONObject(TEST_DATA_JSON_VALID_USER);

		String username = jsonObject_ValidUser.getString(TEST_DATA_JSON_USERNAME).toString();
		String password = jsonObject_ValidUser.getString(TEST_DATA_JSON_PASSWORD).toString();

		productsPage = loginPage.pressModifierBtn().
				enterUsername(username).
				enterPassword(password).
				pressLoginBtn();

		String actualProductTitle = productsPage.getTitle();
		String expectedProductTitle = "Compte";

		VerificationUtils.validate(actualProductTitle, expectedProductTitle, "Account Page Title");
	}

}
