package demo.pages.loginHalim;

import demo.locator.LoginPageLocator;
import pageobjects.AndroidPageObject;

public class LoginPage extends AndroidPageObject {
    public void isOnPage (){
        waitUntilDisplayed(LoginPageLocator.DUMMY_DANA_LOGO);
    }

    public void inputNomor(String phonenumber){
        typeON(LoginPageLocator.DUMMY_INPUT_NOMOR,phonenumber);
    }

    public void clickSignIn(){
        clickOn(LoginPageLocator.DUMMY_CLICK_SIGNIN);
    }

    public boolean isOnPageBool(){
        return checkIfDisplayed(LoginPageLocator.DUMMY_DANA_LOGO);
    }

}
