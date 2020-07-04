package demo.pages;

import demo.locator.GeneralLocator;
import demo.locator.SignUpPageLocator;
import pageobjects.AndroidPageObject;

public class GeneralPage extends AndroidPageObject {
    public String getErrorMessageText() {
        return getText(GeneralLocator.ErrorMessage_Text);
    }

    public String getWarningMessagePopUpText() {
        return getText(GeneralLocator.ErrorDialog_Text);
    }

    public String getToastMessage() {
        return checkToast(GeneralLocator.TOAST_POPUP);
    }
    public void clickWarningMessagePopUpOkButton() {
        clickOn(GeneralLocator.ErrorDialog_OK_Button);
    }
    public void clickBackButton() {
        clickOn(GeneralLocator.Back_Button);
    }
    public void clickHomeButton() {
        clickOn(GeneralLocator.HomeMenu_Button);
    }
    public void clickHistoryButton() {
        clickOn(GeneralLocator.HistoryMenu_Button);
    }
    public void clickVoucherButton() {
        clickOn(GeneralLocator.VoucherMenu_Button);
    }
    public void clickProfileButton() {
        clickOn(GeneralLocator.ProfileMenu_Button);
    }
    public void clickOkButton(){
        clickOn(GeneralLocator.ErrorDialog_OK_Button);
    }
    public boolean waitUntillErrorDialogBoxDisplayed(){
        return checkIfDisplayed(GeneralLocator.ErrorDialog_Text);
    }
    public void clickSignUpNextButton(){
        clickOn(SignUpPageLocator.BUTTON_NEXT);
    }
    public void clickSignUpFinishButton(){
        clickOn(SignUpPageLocator.BUTTON_FINISH);
    }
}
