package pages.signUpPage;

import com.fasterxml.jackson.core.JsonParser;
import common.Base;
import helper.UserCreations;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractBasePage;
import pages.utils.CheckUtil;
import pages.utils.WaitUtils;

import static helper.UserCreations.getGeneratePhoneNumber;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SignUpPage extends AbstractBasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        logger.info("open url");
        driver.get(Base.env);
        WaitUtils.forPageLoaded(driver);
    }

    @Step("Registration new user")
    public SignUpPage registrationUser(String userEmail) {
        logger.info("registration new user");
        open();
        clickSignUp();
        setAccountInfo(userEmail);
        setPersonalInfo();
        return new SignUpPage(driver);
    }

    @Step("Set user name in registration")
    public SignUpPage setUserName() {
        logger.info("set user name in registration");
        sleep(1000);
        getSignUpUserName().sendKeys(RandomStringUtils.randomAlphabetic(4));
        return this;
    }

    @Step("Set email in registration")
    public SignUpPage setEmail(String userEmail) {
        logger.info("set email in registration");
        sleep(1000);
        getSignUpEmail().sendKeys(userEmail);
        return this;
    }

    @Step("Set password")
    public SignUpPage setPassword(String password) {
        logger.info("set password");
        getSignUpPassword().sendKeys(password);
        return this;
    }

    @Step("Set password repeat")
    public SignUpPage setPasswordRepeat(String password) {
        logger.info("set password repeat");
        getSignUpRepeatPassword().sendKeys(password);
        return this;
    }

    @Step("Set email repeat in registration")
    public SignUpPage setEmailRepeat(String userEmail) {
        logger.info("set email repeat in registration");
        sleep(1000);
        getSignUpRepeatEmail().sendKeys(userEmail);
        return this;
    }

    @Step("Set name in registration")
    public SignUpPage setName() {
        logger.info("set name in registration");
        sleep(1000);
        getSignUpName().sendKeys(RandomStringUtils.randomAlphabetic(5));
        return this;
    }

    @Step("Set surname in registration")
    public SignUpPage setSurName() {
        logger.info("set surname in registration");
        sleep(1000);
        getSignUpSurName().sendKeys(RandomStringUtils.randomAlphabetic(6));
        return this;
    }

    @Step("Set sex in registration")
    public SignUpPage clickSexCheckBox() {
        logger.info("set sex in registration");
        sleep(1000);
        getSignUpSex().click();
        return this;
    }

    @Step("Set user passport")
    public SignUpPage setPassport() {
        logger.info("set user passport");
        getSignUpId().sendKeys(RandomStringUtils.randomAlphabetic(8));
        return this;
    }

    @Step("Set user birthday")
    public SignUpPage setBirthday() {
        logger.info("set user birthday");
        getSignUpBirthday().click();
        selectYear().click();
        selectDay().click();
        return this;
    }

    @Step("Set user country")
    public SignUpPage setCountry() {
        logger.info("set user country");
        getSignUpCountry().clear();
        getSignUpCountry().sendKeys("E");
        selectSignUpCountry().click();
        return this;
    }

    @Step("Set user city")
    public SignUpPage setCity() {
        logger.info("set user city");
        getSignUpCity().sendKeys(RandomStringUtils.randomAlphabetic(5));
        return this;
    }

    @Step("Set user address")
    public SignUpPage setAddress() {
        logger.info("set user address");
        getSignUpAddress().sendKeys(RandomStringUtils.randomAlphabetic(7));
        return this;
    }

    @Step("Set currency")
    public SignUpPage setCurrency() {
        logger.info("set currency");
        getSignUpCurrency().click();
        sleep(500);
        selectCurrency().click();
        return this;
    }

    @Step("Set user phone")
    public SignUpPage setPhone() {
        logger.info("set user phone");
        getSignUpPhone().sendKeys(getGeneratePhoneNumber());
        return this;
    }

    @Step("Click agree button")
    public SignUpPage clickAgreeBtn() {
        logger.info("click agree button");
        getRegisterCheckBox().click();
        return this;
    }

    @Step("Click submit button")
    public SignUpPage clickSubmitBtn() {
        logger.info("click submit button");
        getSubmitBtn().click();
        return this;
    }

    @Step("Click sign up button")
    public SignUpPage clickSignUp() {
        logger.info("click sign up button");
        getSignUpBtn().click();
        return this;
    }

    @Step("Set account info")
    public SignUpPage setAccountInfo(String userEmail) {
        logger.info("set account info");
        setUserName();
        setEmail(userEmail);
        setEmailRepeat(userEmail);
        setPassword(UserCreations.SIGNUP_PASSWORD);
        setPasswordRepeat(UserCreations.SIGNUP_PASSWORD);
        return this;
    }

    @Step("Set personal info")
    public SignUpPage setPersonalInfo() {
        logger.info("set personal info");
        setName();
        setSurName();
        scrollPage();
        clickSexCheckBox();
        setPassport();
        setBirthday();
        setCountry();
        setCity();
        setAddress();
        setCurrency();
        setPhone();
        return this;
    }

    @Step("Set confirm password")
    public SignUpPage setConfirmPassword(String confirmPass) {
        logger.info("set confirm password");
        getConfirmPassword().sendKeys(confirmPass);
        return this;
    }

    @Step("Click already have account, log in button")
    public SignUpPage clickAlreadyHaveAccountBtn() {
        logger.info("click already have account, log in button");
        clickSignUp();
        getAlreadyHaveAccount().click();
        return this;
    }

    public SignUpPage scrollPage() {
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,350)", "");
        return this;
    }

    @Step("Set terms of service")
    public SignUpPage setTermsOfService() {
        logger.info("set terms of service");
        clickSignUp();
        getTermsOfService().click();
        return this;
    }

    @Step("Set terms of conditions")
    public SignUpPage setTermsOfConditions() {
        logger.info("set terms of conditions");
        clickSignUp();
        getTermsOfConditions().click();
        return this;
    }

    @Step("Set privacy policy")
    public SignUpPage setPrivacyPolicy() {
        logger.info("set privacy policy");
        clickSignUp();
        getPrivacyPolicy().click();
        return this;
    }

    @Step("Click clear password")
    public SignUpPage clickClearPassword() {
        logger.info("click clear password");
        getClearPassword().click();
        return this;
    }

    @Step("Click clear password repeat")
    public SignUpPage clickClearPasswordRepeat() {
        logger.info("click clear password repeat");
        getClearPasswordRepeat().click();
        return this;
    }

    @Step("set invalid UserName")
    public SignUpPage setInvalidUserName() {
        logger.info("set invalid UserName");
        getInvalidUserName().sendKeys("12");
        return this;
    }

    @Step("set invalid Password")
    public SignUpPage setInvalidPassword() {
        logger.info("set invalid Password");
        getInvalidPassword().sendKeys("1111111");
        return this;
    }

    /**
     * ****************************************** SignUp page locators ************************************************
     */

    private WebElement getSignUpUserName() {
        return getVisibilityElementByXpath("//input[@name='sign-up__username']");
    }

    private WebElement getMessageRequiredInputFieldUserName() {
        return getVisibilityElementByXpath("//div[@class='dx-item-content dx-validationsummary-item-content'][normalize-space()='Enter Username']");
    }

    private WebElement getMessageRequiredInputFieldEmail() {
        return getVisibilityElementByXpath("//div[@class='dx-item-content dx-validationsummary-item-content'][normalize-space()='Enter email']");
    }

    private WebElement getMessageRequiredInputFieldEmailRepeat() {
        return getVisibilityElementByXpath("//div[@class='signup__errors']//div[@class='dx-item dx-validationsummary-item']/div[.='E-Mail repeat failed']");
    }

    private WebElement getMessageRequiredInputFieldPassword() {
        return getVisibilityElementByXpath("//div[@class='signup__errors']//div[@class='dx-item dx-validationsummary-item']/div[.='Please enter your password']");
    }

    private WebElement getMessageRequiredInputFieldPasswordRepeat() {
        return getVisibilityElementByXpath("//div[@class='dx-item-content dx-validationsummary-item-content'][normalize-space()='Passwords do not match']");
    }

    private WebElement getMessageRequiredInputFieldFieldName() {
        return getVisibilityElementByXpath("//div[@class='dx-item-content dx-validationsummary-item-content'][normalize-space()='Please enter your name']");
    }

    private WebElement getMessageRequiredInputFieldSurName() {
        return getVisibilityElementByXpath("//div[@class='dx-item-content dx-validationsummary-item-content'][normalize-space()='Please enter your surname']");
    }

    private WebElement getMessageRequiredInputFieldID() {
        return getVisibilityElementByXpath("//div[@class='dx-item-content dx-validationsummary-item-content'][normalize-space()='ID field empty']");
    }

    private WebElement getMessageRequiredInputFieldPhoneNamber() {
        return getVisibilityElementByXpath("//div[@class='dx-item-content dx-validationsummary-item-content'][normalize-space()='Please enter your phone number']");
    }

    private WebElement getMessageRequiredInputFieldOver18Ears() {
        return getVisibilityElementByXpath("//div[@class='dx-item-content dx-validationsummary-item-content'][contains(text(),'You need to be over 18 years old to register to ou')]");
    }

    private WebElement getSignUpName() {
        return getClickableElementByXpath("//input[@name='sign-up__name']");
    }

    private WebElement getSignUpSurName() {
        return getClickableElementByXpath("//input[@name='sign-up__surname']");
    }

    private WebElement getSignUpSex() {
        return getClickableElementByXpath("//div[contains(text(),'Female')]");
    }

    private WebElement getSignUpId() {
        return getClickableElementByXpath("//input[@name='sign-up__id']");
    }

    private WebElement getSignUpBirthday() {
        return getClickableElementByXpath("//div[@class='ll-input__textbox ll-input__textbox--inside dx-show-invalid-badge dx-textbox dx-texteditor dx-editor-filled dx-widget dx-validator dx-visibility-change-handler']//input[@role='textbox']");
    }

    private WebElement selectDay() {
        return getClickableElementByXpath("//div[@aria-label='Choose Monday, May 2nd, 2005']");
    }

    private WebElement selectYear() {
        return getClickableElementByXpath("//select[@class='react-datepicker__year-select']");
    }

    private WebElement getSignUpCountry() {
        return getClickableElementByXpath("//input[@class='signup__country-picker-input dx-texteditor-input']");
    }

    private WebElement getSignUpCity() {
        return getClickableElementByXpath("//input[@name='sign-up__city']");
    }

    private WebElement getSignUpAddress() {
        return getClickableElementByXpath("//input[@name='sign-up__address']");
    }

    private WebElement getSignUpCurrency() {
        return getClickableElementByXpath("//input[@aria-autocomplete='list']");
    }

    private WebElement selectCurrency() {
        return getClickableElementByXpath("//div[@class='dx-overlay-content dx-popup-normal dx-resizable dx-dropdowneditor-overlay-flipped']//div[@class='dx-item dx-list-item']/div[.='£ GBP']");
    }

    private WebElement getSignUpPhone() {
        return getClickableElementByXpath("//input[@name='sign-up__phone']");
    }

    private WebElement getRegisterCheckBox() {
        return getClickableElementByXpath("//span[@class='dx-checkbox-icon']");
    }

    private WebElement getSubmitBtn() {
        return getClickableElementByXpath("//span[normalize-space()='Submit']");
    }

    private WebElement getSignUpBtn() {
        return getClickableElementByXpath("//div[normalize-space()='Sign up']");
    }

    private WebElement selectSignUpCountry() {
        return getClickableElementByXpath("//div[contains(text(),'England')]");
    }

    private WebElement getSignUpEmail() {
        return getVisibilityElementByXpath("//input[@name='sign-up__email']");
    }

    private WebElement getSignUpRepeatEmail() {
        return getClickableElementByXpath("//input[@name='sign-up__repeat-email']");
    }

    private WebElement getSignUpRepeatPassword() {
        return getClickableElementByXpath("//input[@name='sign-up__repeat-password']");
    }

    public WebElement getErrorMessageWithRegistrationEmail() {
        return getVisibilityElementByXpath("//div[@class='dx-item-content dx-validationsummary-item-content'][normalize-space()='E-mail exists']");
    }

    private WebElement getTermsOfConditions() {
        return getClickableElementByXpath("//span[@class='signup__footer-link']");
    }

    private WebElement getSignUpPassword() {
        return getClickableElementByXpath("//input[@name='sign-up__password']");
    }


    private WebElement getConfirmPassword() {
        return getClickableElementByXpath("");
    }

    private WebElement getAcceptPolicyNotification() {
        return getVisibilityElementByXpath("");
    }

    private WebElement getPrivacyPolicy() {
        return getClickableElementByXpath("//a[normalize-space()='Privacy Policy']");
    }

    private WebElement getTermsOfService() {
        return getClickableElementByXpath("//a[normalize-space()='Terms of Service']");
    }

    private WebElement getAlreadyHaveAccount() {
        return getClickableElementByXpath("//span[@class='signup__login-btn']");
    }

    private WebElement getMessageRules() {
        return getVisibilityElementByXpath("//div[@class='ll-modal__header-title']");
    }

    private String getValidationMessagePassword() {
        return getVisibilityElementByXpath("//div[@class='dx-item-content dx-validationsummary-item-content'][contains(text(),'At least 1 uppercase, 1 lowercase, 1 number and mi')]").getText();
    }

    private String getValidationMessageEmail() {
        return getVisibilityElementByXpath("//div[@class='dx-item-content dx-validationsummary-item-content'][normalize-space()='Please enter a valid e-mail address']").getText();
    }

    private WebElement getClearPassword() {
        return getClickableElementByXpath("//div[@id='sign-up__password']//span[@class='dx-icon dx-icon-clear']");
    }

    private WebElement getClearPasswordRepeat() {
        return getClickableElementByXpath("//div[@id='sign-up__repeat-password']//span[@class='dx-icon dx-icon-clear']");
    }

    private String getMessagePasswordsDoesNotMatch() {
        return getVisibilityElementByXpath("//div[@class='dx-item-content dx-validationsummary-item-content'][normalize-space()='Passwords does not match']").getText();
    }

    private String getAcceptTermsConditionsNotification() {
        return getVisibilityElementByXpath("//div[@class='dx-item-content dx-validationsummary-item-content'][contains(text(),'You need to be over 18 years old to register to ou')]").getText();
    }

    private WebElement getModalFormMemberLogin() {
        return getVisibilityElementByXpath("//div[@class='ll-modal__header-title']");
    }

    private WebElement getInvalidUserName() {
        return getVisibilityElementByXpath("//input[@name='sign-up__username']");
    }

    private WebElement getMessageRequiredInputFieldInvalidPassword() {
        return getVisibilityElementByXpath("//div[@class='dx-item-content dx-validationsummary-item-content'][contains(text(),'At least 1 uppercase, 1 lowercase, 1 number and mi')]");
    }

    private WebElement getMessageRequiredInputFieldInvalidUserName() {
        return getVisibilityElementByXpath("//div[@class='dx-item-content dx-validationsummary-item-content'][contains(text(),'Username must be at least 3 characters and maximum')]");
    }

    private WebElement getInvalidPassword() {
        return getVisibilityElementByXpath("//input[@name='sign-up__password']");
    }

    /**
     * ****************************************** SignUp page Asserts ************************************************
     */

    @Step("Assert equals check sign up validation password")
    public SignUpPage assertEqualsCheckSignUpValidationPassword() {
        logger.info("assert equals check sign up validation password");
        assertEquals(getValidationMessagePassword(), "At least 1 uppercase, 1 lowercase, 1 number and minimum 8 characters required", "message");
        return this;
    }

    @Step("Assert equals check sign up validation email")
    public SignUpPage assertEqualsCheckSignUpValidationEmail() {
        logger.info("Assert equals check sign up validation email");
        assertEquals(getValidationMessageEmail(), "Please enter a valid e-mail address");
        return this;
    }

    @Step("Assert equals check sign up mismatched passwords")
    public SignUpPage assertEqualsCheckSignUpMismatchedPasswords() {
        logger.info("assert equals check sign up mismatched passwords");
        assertEquals(getMessagePasswordsDoesNotMatch(), "Passwords does not match", "message");
        return this;
    }

    @Step("Assert equals confirmation of the terms conditions before registration")
    public SignUpPage assertEqualsConfirmationOfTheTermsConditionsBeforeRegistration() {
        logger.info("assert equals confirmation of the terms conditions before registration");
        assertEquals(getAcceptTermsConditionsNotification(), "You need to be over 18 years old to register to our website.", "message");
        return this;
    }

    @Step("Assert true check logIn button in sign up page")
    public SignUpPage assertTrueCheckLogInButtonInSignUpPage() {
        logger.info("assert true check logIn button in sign up page");
        assertTrue(CheckUtil.isPresent(getModalFormMemberLogin()), "MEMBER LOGIN");
        return this;
    }

    @Step("Assert true url contains")
    public SignUpPage asserTruetUrlContains() {
        logger.info("assert true url contains");
        assertTrue(WaitUtils.waitUrlContains(driver, "/terms"), "url is /terms");
        return this;
    }

    @Step("Assert equals massege rules")
    public SignUpPage assertEqualsMassegeRules() {
        logger.info("assert equals massege rules");
        assertEquals(getMessageRules().getText(), "RULES");
        return this;
    }

    @Step("Assert true url contains")
    public SignUpPage assertTrueUrlContains() {
        logger.info("assert true url contains");
        assertTrue(WaitUtils.waitUrlContains(driver, "/privacy"), "url is /privacy");
        return this;
    }

    @Step("Assert true get error message with registration email")
    public SignUpPage assertTrueGetErrorMessageWithRegistrationEmail() {
        logger.info("assert true get error message with registration email");
        assertTrue(CheckUtil.isPresent(getErrorMessageWithRegistrationEmail()), "E-mail exists");
        return this;
    }

    @Step("Assert true is present sign up button")
    public SignUpPage assertTrueIsPresentSignUpBtn() {
        logger.info("assert true is present sign up button");
        assertTrue(CheckUtil.isPresent(getSignUpBtn()), "button is present");
        return this;
    }

    @Step("Assert display warning in required input field UserName")
    public SignUpPage assertEqualsDisplayWarningInRequiredInputFieldUserName() {
        logger.info("assert display warning in required input field UserName");
        assertEquals(getMessageRequiredInputFieldUserName().getText(), "Enter Username");
        return this;
    }

    @Step("Assert equals display warning in required input field Email")
    public SignUpPage assertDisplayWarningInRequiredInputFieldEmail() {
        logger.info("assert equals display warning in required input field Email");
        assertEquals(getMessageRequiredInputFieldEmail().getText(), "Enter email");
        return this;
    }

    @Step("Assert equals display warning in required input field Email repeat")
    public SignUpPage assertDisplayWarningInRequiredInputFieldEmailRepeat() {
        logger.info("assert equals display warning in required input field Email repeat");
        assertEquals(getMessageRequiredInputFieldEmailRepeat().getText(), "E-Mail repeat failed");
        return this;
    }

    @Step("Assert equals display warning in required input field Password")
    public SignUpPage assertDisplayWarningInRequiredInputFieldPassword() {
        logger.info("assert equals display warning in required input field Password");
        assertEquals(getMessageRequiredInputFieldPassword().getText(), "Please enter your password");
        return this;
    }

    @Step("Assert equals display warning in required input field Password Repeat")
    public SignUpPage assertDisplayWarningInRequiredInputFieldPasswordRepeat() {
        logger.info("assert equals display warning in required input field Password Repeat");
        assertEquals(getMessageRequiredInputFieldPasswordRepeat().getText(), "Passwords do not match");
        return this;
    }

    @Step("Assert equals display warning in required input field Field Name")
    public SignUpPage assertDisplayWarningInRequiredInputFieldName() {
        logger.info("assert equals display warning in required input field Field Name");
        assertEquals(getMessageRequiredInputFieldFieldName().getText(), "Please enter your name");
        return this;
    }

    @Step("Assert equals display warning in required input field Sur Name")
    public SignUpPage assertDisplayWarningInRequiredInputFieldSurName() {
        logger.info("assert equals display warning in required input field Sur Name");
        assertEquals(getMessageRequiredInputFieldSurName().getText(), "Please enter your surname");
        return this;
    }

    @Step("Assert equals display warning in required input field ID")
    public SignUpPage assertDisplayWarningInRequiredInputFieldID() {
        logger.info("assert equals display warning in required input field ID");
        assertEquals(getMessageRequiredInputFieldID().getText(), "ID field empty");
        return this;
    }

    @Step("Assert equals display warning in required input field Phone Namber")
    public SignUpPage assertDisplayWarningInRequiredInputFieldPhoneNamber() {
        logger.info("assert equals display warning in required input field Phone Namber");
        assertEquals(getMessageRequiredInputFieldPhoneNamber().getText(), "Please enter your phone number");
        return this;
    }

    @Step("Assert equals display warning in required input field over 18 ears")
    public SignUpPage assertDisplayWarningInRequiredInputFieldOver18Ears() {
        logger.info("assert equals display warning in required input field over 18 ears");
        assertEquals(getMessageRequiredInputFieldOver18Ears().getText(), "You need to be over 18 years old to register to our website.");
        return this;
    }

    @Step("Assert display warning in required invalid UserName")
    public SignUpPage assertDisplayWarningInRequiredInvalidUserName() {
        logger.info("assert display warning in required invalid UserName");
        assertEquals(getMessageRequiredInputFieldInvalidUserName().getText(), "Username must be at least 3 characters and maximum 17 characters");
        return this;
    }

    @Step("Assert display warning in required invalid Password")
    public SignUpPage assertDisplayWarningInRequiredInvalidPassword() {
        logger.info("assert display warning in required invalid Password");
        assertEquals(getMessageRequiredInputFieldInvalidPassword().getText(), "At least 1 uppercase, 1 lowercase, 1 number and minimum 8 characters required");
        return this;
    }
}