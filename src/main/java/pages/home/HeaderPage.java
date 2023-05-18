package pages.home;

import common.Base;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AbstractBasePage;
import pages.utils.WaitUtils;

public class HeaderPage extends AbstractBasePage {

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    private final String LOG_OUT = "//span[normalize-space()='Logout']";

    @Override
    public void open() {
        logger.info("open url");
        driver.get(Base.env);
        WaitUtils.forPageLoaded(driver);
    }

    @Step("Click sign in button in header")
    public HeaderPage clickSignInBtn() {
        logger.info("click sign in button in header");
        getSignInBtn().click();
        WaitUtils.forPageLoaded(driver);
        return this;
    }

    @Step("Click sign up button in header")
    public HeaderPage clickSignUpBtn() {
        logger.info("click sign up button in header");
        getSignUpBtn().click();
        return this;
    }

    @Step("Click ciprobet button")
    public HeaderPage clickCiproBetBtn() {
        logger.info("click ciprobet button");
        getCiproBetBtn().click();
        return this;
    }

    @Step("Set login button")
    public HeaderPage setLoginBtn() {
        logger.info("set login button");
        getLoginBtn().click();
        return this;
    }

    @Step("Click change language button")
    public HeaderPage clickChangeLanguageBtn() {
        logger.info("Click change language button");
        getChangeLanguageBtn().click();
        return this;
    }

    @Step("Clouse member login icon")
    public HeaderPage clouseMemberLoginIcon() {
        logger.info("clouse member login icon");
        getMemberLoginIcon().click();
        return this;
    }

    @Step("Set sign up button")
    public HeaderPage setSignUpBtn() {
        logger.info("set sign up button");
        getSignUpBtn().click();
        return this;
    }

    /**
     * **************************************** Header page locators ***************************************************
     */

    private WebElement getSignInBtn() {
        return getClickableElementByXpath("//button[@class='ll-btn2 ll-header-btn']//div[@class='ll-btn__content active'][normalize-space()='Login']");
    }

    public WebElement getNameBtn() {
        return getVisibilityElementByXpath("//button[@class='ll-btn2 ll-header-btn ll-header-btn--user-name']//div[@class='ll-btn__content active']");
    }

    public WebElement getSignUpBtn() {
        return getClickableElementByXpath("//div[normalize-space()='Sign up']");
    }

    public WebElement getLogOutBtn() {
        return getClickableElementByXpath(LOG_OUT);
    }

    public WebElement getLogOut() {
        return findElementByXpath(LOG_OUT);
    }

    public WebElement getCiproBetBtn() {
        return getVisibilityElementByXpath("//a[@class='ll-header__logo']");
    }

    public WebElement getChangeLanguageBtn() {
        return getVisibilityElementByXpath("//img[@class='ll-language-picker__flag']");
    }

    public WebElement getLoginBtn() {
        return getVisibilityElementByXpath("//div[normalize-space()='Login']");
    }

    private WebElement getLanguageLogo() {
        return getVisibilityElementByXpath("//p[@class='ll-language-picker__text']");
    }

    private WebElement getMemberLogin() {
        return getVisibilityElementByXpath("//div[@class='ll-modal__header-title'][contains(text(),\"Member Login\")]");
    }

    private WebElement getMemberLoginIcon() {
        return getClickableElementByXpath("//i[@class='doruk-close ll-modal__close-button-icon']");
    }

    private WebElement getRegistrationForm() {
        return getVisibilityElementByXpath("//p[normalize-space()='Registration form']");
    }

    /**
     * *******************************************  Header page Asserts ***********************************************
     */

    @Step("Assert equals get language logo")
    public HeaderPage assertEqualsGetLanguageLogo() {
        logger.info("assert equals get language logo");
        Assert.assertEquals(getLanguageLogo().getText(), "ENGLISH");
        return this;
    }

    @Step("Assert true url contains")
    public HeaderPage assertTrueUrlContains() {
        logger.info("assert true url contains");
        return this;
    }

    @Step("Assert equals get member login")
    public HeaderPage assertEqualsGetMemberLogin() {
        logger.info("assert equals get member login");
        Assert.assertEquals(getMemberLogin().getText(), "MEMBER LOGIN");
        return this;
    }

    @Step("Assert equals get registration form")
    public HeaderPage assertEqualsGetRegistrationForm() {
        logger.info("assert equals get registration form");
        Assert.assertEquals(getRegistrationForm().getText(), "Registration form");
        return this;
    }

    @Step("Assert true wait url contains")
    public HeaderPage assertEqualsGetMemberLogitScreenText() {
        logger.info("assert true wait url contains");
        Assert.assertEquals(getMemberLogin().getText(), "MEMBER LOGIN");
        return this;
    }

    @Step("Assert true url contains sign up")
    public HeaderPage assertTrueUrlContainsSignUp() {
        logger.info("assert true url contains sign up");
        Assert.assertEquals(getRegistrationForm().getText(), "Registration form");
        return this;
    }
}
