package com.appium.tests;

import com.appium.annotations.FrameworkAnnotation;
import com.appium.base.BaseTest;
import com.appium.enums.AuthorType;
import com.appium.enums.CategoryType;
import com.appium.pages.LoginPage;
import com.appium.pages.LogoutPage;
import com.appium.pages.ProductsPage;
import com.appium.utils.JSONUtils;
import com.appium.utils.TestUtils;
import com.appium.utils.VerificationUtils;
import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static com.appium.constants.FrameworkConstants.*;
import static com.appium.constants.FrameworkConstants.TEST_DATA_JSON_PASSWORD;

public class LogoutTests extends BaseTest {

    LogoutPage logoutPage;
    ProductsPage productsPage;
    LoginPage loginPage;
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
        logoutPage = new LogoutPage();


    }

    @AfterMethod
    public void afterMethod(Method method) {
        TestUtils.log().debug("*****************  ** Test ended: " + method.getName() + "*******************");
        TestUtils.log().debug("---------------------------------------------------");
//         closeApp();
         launchApp();

    }

    @FrameworkAnnotation(author = { AuthorType.ERIKA }, category = { CategoryType.SMOKE,
            CategoryType.SANITY, CategoryType.REGRESSION })
    @Test(groups = { "SANITY", "SMOKE", "REGRESSION" ,"validUserName"},priority=1)
    public void deniedLogout() {

        JSONObject jsonObject_ValidUser =
                new JSONUtils()
                        .getJSONObject(TEST_DATA_JSON_FILE)
                        .getJSONObject(TEST_DATA_JSON_VALID_USER);

        String username = jsonObject_ValidUser.getString(TEST_DATA_JSON_USERNAME).toString();
        String password = jsonObject_ValidUser.getString(TEST_DATA_JSON_PASSWORD).toString();

        loginPage.loginClick().connectClick().
                enterUsername(username).
                enterPassword(password).
                pressLoginBtn();

        logoutPage.logoutClick().deniedClick();

//        String actualProductTitle = productsPage.getTitle();
//        String expectedProductTitle = "Compte";
//
//        VerificationUtils.validate(actualProductTitle, expectedProductTitle, "Account Page Title");
    }


    @FrameworkAnnotation(author = { AuthorType.ERIKA }, category = { CategoryType.SMOKE,
            CategoryType.SANITY, CategoryType.REGRESSION })
    @Test(groups = { "SANITY", "SMOKE", "REGRESSION" ,"validUserName"},priority=1)
    public void successfulLogout() {

        JSONObject jsonObject_ValidUser =
                new JSONUtils()
                        .getJSONObject(TEST_DATA_JSON_FILE)
                        .getJSONObject(TEST_DATA_JSON_VALID_USER);

        String username = jsonObject_ValidUser.getString(TEST_DATA_JSON_USERNAME).toString();
        String password = jsonObject_ValidUser.getString(TEST_DATA_JSON_PASSWORD).toString();

        loginPage.loginClick().connectClick().
                enterUsername(username).
                enterPassword(password).
                pressLoginBtn();

        logoutPage.logoutClick().logoutLinkClick();

//        String actualProductTitle = productsPage.getElt();
//        String expectedProductTitle = "Bienvenue";
//
//        VerificationUtils.validate(actualProductTitle, expectedProductTitle, "Home Page Title");
    }
}
