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
import com.appium.components.MenuPage;

import static com.appium.constants.FrameworkConstants.TEXT;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

//public class ProductsPage extends MenuPage {
public class ProductsPage extends BasePage {

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"PRODUCTS\"]")
	private MobileElement productTitle;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"test-Item title\"])[1]")
	private MobileElement SLBTitle;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Price\"])[1]")
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"test-Price\"])[1]")
	private MobileElement SLBPrice;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayo" +
			"ut/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Fram" +
			"eLayout[1]/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android." +
			"view.View/android.view.View[1]/android.widget.TextView")
	private MobileElement accountPageTitle;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android." +
			"widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget." +
			"FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx." +
			"compose.ui.platform.ComposeView/android.view.View/android.widget.TextView")
	private MobileElement welcomeTitle;

	private MenuPage menuPage;

	public ProductsPage() {
		super();
		// Composition
		menuPage = new MenuPage();
	}

	public MenuPage getMenuPage() {
		return menuPage;
	}

	public String getTitle() {
		// return getAttribute(productTitle, "text");
		// return getAttribute(productTitle, TEXT);
		return getElementText(accountPageTitle);
	}

	public String getElt(){
		return getElementText(welcomeTitle);
	}

	public String getSLBTitle() {
//		return getAttribute(SLBTitle, TEXT);
		return getElementText(SLBTitle);
	}

	public String getSLBPrice() {
//		return getAttribute(SLBPrice, TEXT);
		return getElementText(SLBPrice);

	}

	public ProductDetailsPage pressSLBTitle() {
		click(SLBTitle);
		return new ProductDetailsPage();
	}
}
