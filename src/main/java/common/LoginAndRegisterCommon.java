package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractBasePage;

public class LoginAndRegisterCommon extends AbstractBasePage {

    protected LoginAndRegisterCommon(WebDriver driver) {
        super(driver);
    }

    public WebElement getSignUpUserName() {
        return getVisibilityElementByXpath("//input[@name='sign-up__username']");
    }

    public WebElement getLoginUserName() {
        return getVisibilityElementByXpath("//input[@name='login__username']");
    }

    public WebElement getSignUpEmail() {
        return getVisibilityElementByXpath("//input[@name='sign-up__email']");
    }

    public WebElement getSignUpRepeatEmail(){
        return getClickableElementByXpath("//input[@name='sign-up__repeat-email']");
    }

    public WebElement getSignUpRepeatPassword() {
        return getClickableElementByXpath("//input[@name='sign-up__repeat-password']");
    }

    public WebElement getSignUpPassword() {
        return getClickableElementByXpath("//input[@name='sign-up__password']");
    }

    public WebElement getLoginPassword() {
        return getClickableElementByXpath("//input[@name='login__password']");
    }

    public WebElement getSignInBtn() {
        return getClickableElementByXpath("//div[@class='dx-button-content']");
    }

    public WebElement getLoginBtn(){
        return getClickableElementByXpath("//div[normalize-space()='Login']");
    }

    public WebElement getSignUpName(){
        return getClickableElementByXpath("//input[@name='sign-up__name']");
    }

    public WebElement getSignUpSurName(){
        return getClickableElementByXpath("//input[@name='sign-up__surname']");
    }

    public WebElement getSignUpSex(){
        return getClickableElementByXpath("//div[contains(text(),'Female')]");
    }

    public WebElement getSignUpId(){
        return getClickableElementByXpath("//input[@name='sign-up__id']");
    }

    public WebElement getSignUpBirthday(){
        return getClickableElementByXpath("//div[@class='ll-input__textbox ll-input__textbox--inside dx-show-invalid-badge dx-textbox dx-texteditor dx-editor-filled dx-widget dx-validator dx-visibility-change-handler']//input[@role='textbox']");
    }

    public WebElement selectDay(){
        return getClickableElementByXpath("//div[@aria-label='Choose Monday, May 2nd, 2005']");
    }

    public WebElement selectYear(){
        return getClickableElementByXpath("//select[@class='react-datepicker__year-select']");
    }

    public WebElement getSignUpCountry(){
        return getClickableElementByXpath("//input[@class='signup__country-picker-input dx-texteditor-input']");
    }

    public WebElement getSignUpCity(){
        return getClickableElementByXpath("//input[@name='sign-up__city']");
    }

    public WebElement getSignUpAddress(){
        return getClickableElementByXpath("//input[@name='sign-up__address']");
    }

    public WebElement getSignUpCurrency(){
        return getClickableElementByXpath("//input[@aria-autocomplete='list']");
    }

    public WebElement selectCurrency(){
        return getClickableElementByXpath("//div[@class='dx-overlay-content dx-popup-normal dx-resizable dx-dropdowneditor-overlay-flipped']//div[@class='dx-item dx-list-item']/div[.='£ GBP']");
    }

    public WebElement getSignUpPhone(){
        return getClickableElementByXpath("//input[@name='sign-up__phone']");
    }

    public WebElement getRegisterCheckBox(){
        return getClickableElementByXpath("//span[@class='dx-checkbox-icon']");
    }

    public WebElement getSubmitBtn(){
        return getClickableElementByXpath("//span[normalize-space()='Submit']");
    }

    public WebElement getSignUpBtn(){
        return getClickableElementByXpath("//div[normalize-space()='Sign up']");
    }

    public WebElement selectSignUpCountry(){
        return getClickableElementByXpath("//div[contains(text(),'England')]");
    }

    public String getErrorMessage() {
        return getVisibilityElementByXpath("//div[@class='login-form__error'][contains(text(), \"Wrong username or password\")]").getText();
    }

    public boolean isDisplayedUserName() {
        return getVisibilityElementByXpath("//div[@class='ll-header-btn__text'][contains(text(), \"kiev25\")]").isDisplayed();
    }

    public WebElement getConfirmPassword() {
        return getClickableElementByXpath("");
    }

    public WebElement getAcceptPolicyNotification() {
        return getVisibilityElementByXpath("");
    }

    public WebElement getPrivacyPolicy() {
        return getClickableElementByXpath("//a[normalize-space()='Privacy Policy']");
    }

    public WebElement getTermsOfService() {
        return getClickableElementByXpath("//a[normalize-space()='Terms of Service']");
    }

    public WebElement getAlreadyHaveAccount() {
        return getClickableElementByXpath("//span[@class='signup__login-btn']");
    }

    public WebElement getInfoMessageFargotPassword() {
        return getClickableElementByXpath("//div[@class='ll-modal__header-title']");
    }

    public WebElement getInfoMassageRegistrationForm() {
        return getClickableElementByXpath("//p[normalize-space()='Registration form']");
    }

    public WebElement getErrorMessageWithRegistrationEmail() {
        return getVisibilityElementByXpath("//div[@class='dx-item-content dx-validationsummary-item-content'][normalize-space()='E-mail exists']");
    }

    public WebElement getTermsOfConditions(){
        return getClickableElementByXpath("//span[@class='signup__footer-link']");
    }

    public WebElement getMessageRules() {
        return getVisibilityElementByXpath("//div[@class='ll-modal__header-title']");
    }

    public String getValidationMessagePassword() {
        return getVisibilityElementByXpath("//div[@class='dx-item-content dx-validationsummary-item-content'][contains(text(),'At least 1 uppercase, 1 lowercase, 1 number and mi')]").getText();
    }

    public String getValidationMessageEmail(){
        return getVisibilityElementByXpath("//div[@class='dx-item-content dx-validationsummary-item-content'][normalize-space()='Please enter a valid e-mail address']").getText();
    }

    public WebElement getClearPassword(){
        return getClickableElementByXpath("//div[@id='sign-up__password']//span[@class='dx-icon dx-icon-clear']");
    }

    public WebElement getClearPasswordRepeat(){
        return getClickableElementByXpath("//div[@id='sign-up__repeat-password']//span[@class='dx-icon dx-icon-clear']");
    }

    public String getMessagePasswordsDoesNotMatch(){
        return getVisibilityElementByXpath("//div[@class='dx-item-content dx-validationsummary-item-content'][normalize-space()='Passwords does not match']").getText();
    }

    public String getAcceptTermsConditionsNotification(){
        return getVisibilityElementByXpath("//div[@class='dx-item-content dx-validationsummary-item-content'][contains(text(),'You need to be over 18 years old to register to ou')]").getText();
    }

    public WebElement getModalFormMemberLogin(){
        return getVisibilityElementByXpath("//div[@class='ll-modal__header-title']");
    }

    public WebElement getForgotThePasswordLink(){
        return getClickableElementByXpath("//div[@class='login-form__forgot-pwd-btn']");
    }
}
