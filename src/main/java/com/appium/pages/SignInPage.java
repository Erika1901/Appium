package com.appium.pages;

import com.appium.base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SignInPage extends BasePage {

    @AndroidFindBy(id = "com.carrefour.fid.android:id/new_customer_text")
    private MobileElement signInBtn;
    private String signInTxt = "Créer mon compte";

    @AndroidFindBy(id = "com.carrefour.fid.android:id/editTextCreateEmail")
    private MobileElement emailBox;
    private String emailBoxTxt = "Mon courriel*";

    @AndroidFindBy(id = "com.carrefour.fid.android:id/editTextCreatePwd")
    private MobileElement pwdBox;
    private String pwdBoxTxt = "Mon mot de passe*";

    //@AndroidFindBy(id = "com.carrefour.fid.android:id/nextStepBtn")
    @AndroidFindBy(accessibility = "Cliquer sur le bouton valider pour continuer")
    private MobileElement validateBtn;
    private String validateBtnTxt = "VALIDER";

    @AndroidFindBy(id = "com.carrefour.fid.android:id/rg_modify_account_civility_women")
    private MobileElement civilityBtn;
    private String civilityBtnTxt = "Femme";

    @AndroidFindBy(id = "com.carrefour.fid.android:id/edt_modify_account_lastname")
    private MobileElement lastnameBox;
    private String lastname = "Nom*";

    @AndroidFindBy (id = "com.carrefour.fid.android:id/edt_modify_account_firstname")
    private MobileElement firstnameBox;
    private String firstname = "Prénom*";

    @AndroidFindBy (id = "com.carrefour.fid.android:id/validateCreateAccountBtn")
    private  MobileElement validateCreateBtn;
    private String validateCreateBtnTxt = "CREER MON COMPTE";

    @AndroidFindBy (id = "android:id/button1")
    private MobileElement confirmCGU;
    private String confirmCGUTxt = "ACCEPTER LES CONDITIONS";

    @AndroidFindBy (id = "com.carrefour.fid.android:id/btnSuccessMeConnecter")
    private MobileElement btnSuccessMeConnecter;
    private String btnSuccessMeConnecterTxt = "J'ai compris";
   public SignInPage signIn(){
       click(signInBtn, signInTxt);
       return this;
    }

   public SignInPage enterEmail(String email){
       sendKeys(emailBox,email,emailBoxTxt);
       return this;
   }

   public SignInPage enterPassword(String password){
       sendKeys(pwdBox, password,pwdBoxTxt);
       return this;
   }

   public SignInPage validate(){
       click(validateBtn,validateBtnTxt);
       return this;
   }
   public SignInPage chooseCivility(){
       click(civilityBtn, civilityBtnTxt);
       return this;
   }

   public SignInPage enterFirstname(String firstName){
       sendKeys(firstnameBox,firstName,firstname);
       return this;
   }

   public SignInPage enterLastname(String lastName){
       sendKeys(lastnameBox,lastName,lastname);
       return this;
   }

   public SignInPage validateCreation(){
       swipeDown(1);
       click(validateCreateBtn,validateCreateBtnTxt);
       return this;
   }

   public SignInPage validateCGU(){
       click(confirmCGU,confirmCGUTxt);
       return this;
   }

   public SignInPage confirmSuccess(){
       click (btnSuccessMeConnecter, btnSuccessMeConnecterTxt);
       return this;
   }
}
