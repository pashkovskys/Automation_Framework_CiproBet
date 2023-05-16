package pages.signUpPage;

import common.Base;
import common.LoginAndRegisterCommon;
import helper.UserCreations;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.utils.CheckUtil;
import pages.utils.WaitUtils;
import static helper.UserCreations.getGeneratePhoneNumber;
import static org.testng.Assert.assertTrue;

public class SignUpPage extends LoginAndRegisterCommon {

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
        clickSubmitBtn();
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
        clickAgreeBtn();
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

    @Step("Assert equals check sign up validation password")
    public SignUpPage assertEqualsCheckSignUpValidationPassword() {
        logger.info("assert equals check sign up validation password");
        new SignUpPage(driver);
        Assert.assertEquals(getValidationMessagePassword(), "At least 1 uppercase, 1 lowercase, 1 number and minimum 8 characters required", "message");
        return this;
    }

    @Step("Assert equals check sign up validation email")
    public SignUpPage assertEqualsCheckSignUpValidationEmail() {
        logger.info("Assert equals check sign up validation email");
        new SignUpPage(driver);
        Assert.assertEquals(getValidationMessageEmail(), "Please enter a valid e-mail address");
        return this;
    }

    @Step("Assert equals check sign up mismatched passwords")
    public SignUpPage assertEqualsCheckSignUpMismatchedPasswords() {
        logger.info("assert equals check sign up mismatched passwords");
        new SignUpPage(driver);
        Assert.assertEquals(getMessagePasswordsDoesNotMatch(), "Passwords does not match", "message");
        return this;
    }

    @Step("Assert equals confirmation of the terms conditions before registration")
    public SignUpPage assertEqualsConfirmationOfTheTermsConditionsBeforeRegistration() {
        logger.info("assert equals confirmation of the terms conditions before registration");
        new SignUpPage(driver);
        Assert.assertEquals(getAcceptTermsConditionsNotification(), "You need to be over 18 years old to register to our website.", "message");
        return this;
    }

    @Step("Assert true check logIn button in sign up page")
    public SignUpPage assertTrueCheckLogInButtonInSignUpPage() {
        logger.info("assert true check logIn button in sign up page");
        new SignUpPage(driver);
        assertTrue(CheckUtil.isPresent(getModalFormMemberLogin()), "MEMBER LOGIN");
        return this;
    }

    @Step("Assert true url contains")
    public SignUpPage asserTruetUrlContains() {
        logger.info("assert true url contains");
        new SignUpPage(driver);
        assertTrue(WaitUtils.waitUrlContains(driver, "/terms"), "url is /terms");
        return this;
    }

    @Step("Assert equals massege rules")
    public SignUpPage assertEqualsMassegeRules() {
        logger.info("assert equals massege rules");
        new SignUpPage(driver);
        Assert.assertEquals(getMessageRules().getText(), "RULES");
        return this;
    }

    @Step("Assert true url contains")
    public SignUpPage assertTrueUrlContains() {
        logger.info("assert true url contains");
        new SignUpPage(driver);
        assertTrue(WaitUtils.waitUrlContains(driver, "/privacy"), "url is /privacy");
        return this;
    }

    @Step("Assert true get error message with registration email")
    public SignUpPage assertTrueGetErrorMessageWithRegistrationEmail() {
        logger.info("assert true get error message with registration email");
        new SignUpPage(driver);
        assertTrue(CheckUtil.isPresent(getErrorMessageWithRegistrationEmail()), "E-mail exists");
        return this;
    }

    @Step("Assert true is present sign up button")
    public SignUpPage assertTrueIsPresentSignUpBtn() {
        logger.info("assert true is present sign up button");
        new SignUpPage(driver);
        assertTrue(CheckUtil.isPresent(getSignUpBtn()), "button is present");
        return this;
    }
}
