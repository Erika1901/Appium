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

package com.appium.pages;

import com.appium.base.BasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage extends BasePage {

	// @iOSXCUITFindBy(id = "test-Username") -> This id is actually accessibility ID
	// only (We can get it from Appium Inspector)
	@AndroidFindBy(accessibility = "Mon Compte")
	private MobileElement loginIcon;
	private String loginIconBtn = "Mon compte";

	@AndroidFindBy(id = "com.carrefour.fid.android:id/button_account_home_anonymous_login")
	private MobileElement connectBtn;
	private String connectBtnTxt = "Me connecter";

	@AndroidFindBy(id = "com.carrefour.fid.android:id/email_text")
	private MobileElement emailField;
	private String emailFiedTxt = "Mon courriel*";

	@AndroidFindBy(id = "com.carrefour.fid.android:id/pwd_text")
	private MobileElement pwdField;
	private String pwdFiedTxt = "Mon mot de passe*";

	@AndroidFindBy(id = "com.carrefour.fid.android:id/connect_button")
	private MobileElement connectButton;
	private String connectButtonTxt = "Me connecter";

	@AndroidFindBy(id = "com.carrefour.fid.android:id/btn_accept_cookies")
	private MobileElement acceptCookies;
	private String acceptCookiesTxt = "Accepter les cookies";

	@AndroidFindBy(id = "android:id/button2")
	private MobileElement modifierButton;
	private String modifierButtonTxt = "MODIFIER";

	@AndroidFindBy(id = "android:id/message")
	// @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Error
	// message\"]/child::XCUIElementTypeStaticText")
	@iOSXCUITFindBy(id = "Username and password do not match any user in this service.")
	private MobileElement msgErrorTxt;

	public LoginPage acceptCookies() {

		click(acceptCookies, acceptCookiesTxt);
		return this;
	}
	public LoginPage loginClick() {
		click(loginIcon, loginIconBtn);
		return this;
	}

	public LoginPage connectClick(){
		click (connectBtn,connectBtnTxt);
		return this;
	}
	public LoginPage enterUsername(String userName) {
		// txtFldUsername.sendKeys(userName);
		// sendKeys(txtFldUsername, userName);
		sendKeys(emailField, userName, emailFiedTxt);
		return this;
	}

	public LoginPage enterPassword(String password) {
		// sendKeys(txtFldPassword, password);
		sendKeys(pwdField, password, pwdFiedTxt);
		return this;
	}

	public ProductsPage pressLoginBtn() {
		// click(btnLogin);
		click(connectButton, connectButtonTxt);
		return new ProductsPage();
	}

	public LoginPage pressModifierBtn() {
		// click(btnLogin);
		click(modifierButton, modifierButtonTxt);
		return this;
	}

	public ProductsPage login(String username, String password) {
		enterUsername(username).enterPassword(password).pressLoginBtn();
		return new ProductsPage();
	}

	public String getErrorTxt() {
		// return getAttribute(msgErrorTxt, TEXT);
		return getElementText(msgErrorTxt);
	}

}
