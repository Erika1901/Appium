package com.appium.pages;

import com.appium.base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LogoutPage extends BasePage {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[9]")
    private MobileElement logoutBtn;
    private String logoutBtnTxt = "Me déconnecter";

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button")
    private MobileElement logoutButton;
    private String logoutButtonTxt = "Me déconnecter";

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button")
    private MobileElement deniedBtn;
    private String deniedBtnTxt = "Annuler";

    public LogoutPage logoutClick() {
        click(logoutBtn, logoutBtnTxt);
        return this;
    }

    public LogoutPage logoutLinkClick(){
        click(logoutButton, logoutButtonTxt);
        return this;
    }

    public LogoutPage deniedClick(){
        click(deniedBtn, deniedBtnTxt);
        return this;
    }
}
