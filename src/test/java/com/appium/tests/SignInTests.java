package com.appium.tests;

import com.appium.annotations.FrameworkAnnotation;
import com.appium.base.BaseTest;
import com.appium.enums.AuthorType;
import com.appium.enums.CategoryType;
import com.appium.pages.LoginPage;
import com.appium.pages.ProductsPage;
import com.appium.pages.SignInPage;
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

public class SignInTests extends BaseTest {

    SignInPage signInPage;

    ProductsPage productsPage;
    LoginPage loginPage;
//    JSONObject loginUsers;
    JSONObject signInUser;

    @AfterClass
    public void afterClass() {
        closeApp();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {

        TestUtils.log().debug("---------------------------------------------------");
        TestUtils.log().debug("******************* Test started: " + method.getName() + "*******************");

        loginPage = new LoginPage();
        signInPage = new SignInPage();


    }

    @AfterMethod
    public void afterMethod(Method method)  {
        TestUtils.log().debug("*****************  ** Test ended: " + method.getName() + "*******************");
        TestUtils.log().debug("---------------------------------------------------");
//         closeApp();
        launchApp();

    }

    @FrameworkAnnotation(author = { AuthorType.ERIKA }, category = { CategoryType.SMOKE,
            CategoryType.SANITY, CategoryType.REGRESSION })
    @Test(groups = { "SANITY", "SMOKE", "REGRESSION" ,"validUserName"},priority=1)
    public void successfulSignIn()  {

        JSONObject jsonObject_User =
                new JSONUtils()
                        .getJSONObject(TEST_DATA_JSON_FILE2)
                        .getJSONObject(TEST_DATA_JSON_USER);


        String email = jsonObject_User.getString(TEST_DATA_JSON_EMAIL).toString();
        String pwd = jsonObject_User.getString(TEST_DATA_JSON_PWD).toString();
        String firstname = jsonObject_User.getString(TEST_DATA_JSON_FIRSTNAME).toString();
        String lastname = jsonObject_User.getString(TEST_DATA_JSON_LASTNAME).toString();

        loginPage.loginClick().connectClick();

        signInPage.signIn().enterEmail(email).
                enterPassword(pwd).validate().
                chooseCivility(). enterLastname(lastname).
                enterFirstname(firstname).validateCreation().
                validateCGU().confirmSuccess();



    }
}
