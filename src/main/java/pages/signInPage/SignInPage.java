package pages.signInPage;

import common.Base;
import common.LoginAndRegisterCommon;
import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import pages.home.HomePage;
import static org.testng.Assert.assertTrue;

public class SignInPage extends LoginAndRegisterCommon {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        openUrl(Base.env);
    }

    @Step("Sign in user")
    public HomePage signInUser(String userName, String password) {
        logger.info("sign in user");
        open();
        clickLoginBtn();
        setLoginName(userName);
        setPassword(password);
        clickSignInBtn();
        return new HomePage(driver);
    }

    @Step("Set user name in login")
    public SignInPage setLoginName(String userName) {
        logger.info("set user name in login");
        getLoginUserName().sendKeys(userName);
        return new SignInPage(driver);
    }

    @Step("Set password in login")
    public SignInPage setPassword(String password) {
        logger.info("set password in login");
        getLoginPassword().sendKeys(password);
        return new SignInPage(driver);
    }

    @Step("Click Sign In button")
    public SignInPage clickSignInBtn() {
        logger.info("click Sign In button");
        getSignInBtn().click();
        return this;
    }

    @Step("Click Login button")
    public SignInPage clickLoginBtn() {
        logger.info("click Login button");
        getLoginBtn().click();
        return this;
    }

    @Step("Click Not Have Account button")
    public SignInPage clickNotHaveAccountBtn() {
        getNotHaveAccountBtn().click();
        return this;
    }

    @Step("Sign in user without authentication code")
    public SignInPage signInUserWithoutCode(String email, String password) {
        open();
        clickLoginBtn();
        setLoginName(email);
        setPassword(password);
        clickSignInBtn();
        return new SignInPage(driver);
    }

    @Step("Get text from the error message")
    public String getErrorMessageText() {
        try {
            return getErrorMessage();
        } catch (TimeoutException e) {
            return "";
        }
    }

    public WebElement getNotHaveAccountBtn() {
        return getClickableElementByXpath("//span[@class='login-form__signup-link']");
    }

    public SignInPage setForgotThePasswordLink() {
        getForgotThePasswordLink().click();
        return this;
    }

    public WebElement getNotificationMessage() {
        return getVisibilityElementByXpath("//div[@class='login-form__error']");
    }

    public WebElement getModalFormMemberLogin() {
        return getVisibilityElementByXpath("//div[@class='ll-modal__header-title']");
    }

    @Step("Assert equals get info massage registration form")
    public SignInPage assertEqualsGetInfoMassageRegistrationForm() {
        logger.info("assert equals get info massage registration form");
        new SignInPage(driver);
        AssertJUnit.assertEquals(getInfoMassageRegistrationForm().getText(), "Registration form");
        return this;
    }

    @Step("Assert equals get info message fargot password")
    public SignInPage assertEqualsGetInfoMessageFargotPassword() {
        logger.info("assert equals get info message fargot password");
        new SignInPage(driver);
        AssertJUnit.assertEquals(getInfoMessageFargotPassword().getText(), "PASSWORD RESET");
        return this;
    }

    @Step("Assert equals get login user name placeholder")
    public SignInPage assertEqualsGetLoginUserNamePlaceholder() {
        logger.info("assert equals get login user name placeholder");
        new SignInPage(driver);
        AssertJUnit.assertEquals(getLoginUserName().getAttribute("placeholder"), "Username", "Username");
        return this;
    }

    @Step("Assert equals get login password placeholder")
    public SignInPage assertEqualsGetLoginPasswordPlaceholder() {
        logger.info("assert equals get login password placeholder");
        new SignInPage(driver);
        AssertJUnit.assertEquals(getLoginPassword().getAttribute("placeholder"), "Password", "Password");
        return this;
    }

    @Step("Assert equals get notification message")
    public SignInPage assertEqualsGetNotificationMessage() {
        logger.info("assert equals get notification message");
        new SignInPage(driver);
        AssertJUnit.assertEquals(getNotificationMessage().getText(), "Wrong username or password!");
        return this;
    }

    @Step("Assert equals get error message text")
    public SignInPage assertEqualsGetErrorMessageText() {
        logger.info("assert equals get error message text");
        new SignInPage(driver);
        Assert.assertEquals(getErrorMessageText(), "Wrong username or password!",
                "Correct message");
        return this;
    }

    @Step("Assert true isDisplayed user name")
    public SignInPage assertTrueIsDisplayedUserName() {
        logger.info("assert true isDisplayed user name");
        new SignInPage(driver);
        assertTrue(isDisplayedUserName(), "Validation registration fields");
        return this;
    }
}
