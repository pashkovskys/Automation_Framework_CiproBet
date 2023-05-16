package pages.home;

import common.Base;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AbstractBasePage;
import pages.utils.WaitUtils;
import static org.testng.Assert.assertTrue;

public class FooterPage extends AbstractBasePage {

    public FooterPage(WebDriver driver) {
        super(driver);
    }

    String modalIframe = "//iframe[@title=\"modal-iframe\"]";

    @Override
    public void open() {
        openUrl(Base.env);
        WaitUtils.forPageLoaded(driver);
    }

    public FooterPage scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800000)");
        sleep(2000);
        return this;
    }

    @Step("Click about us button")
    public FooterPage clickAboutUsBtn() {
        logger.info("click about us button");
        getAboutUsBtn().click();
        return this;
    }

    @Step("Click F.A.Q button")
    public FooterPage clickFAQBtn() {
        logger.info("click F.A.Q button");
        getFaqBtn().click();
        driver.switchTo().frame(driver.findElement(By.xpath(modalIframe)));
        return this;
    }

    @Step("Click rules button")
    public FooterPage clickRulesBtn() {
        logger.info("click rules button");
        getRulesBtn().click();
        driver.switchTo().frame(driver.findElement(By.xpath(modalIframe)));
        return this;
    }

    @Step("Click contact us button")
    public FooterPage clickContactUsBtn() {
        logger.info("click contact us button");
        getContactUsBtn().click();
        return this;
    }

    @Step("Click live betting button")
    public FooterPage clickLiveBettingBtn() {
        logger.info("click live betting button");
        getLiveBettingBtn().click();
        return this;
    }

    @Step("Click sport betting  button")
    public FooterPage clickSportBettingBtn() {
        logger.info("click sport betting  button");
        getSportBettingBtn().click();
        return this;
    }

    @Step("Click virtual sports button")
    public FooterPage clickVirtualSportsBtn() {
        logger.info("click virtual sports button");
        getVirtualSportsBtn().click();
        return this;
    }

    @Step("Click live casino button")
    public FooterPage clickLiveCasinoBtn() {
        logger.info("click live casino button");
        getLiveCasinoBtn().click();
        return this;
    }

    @Step("Click live bingo button")
    public FooterPage clickLiveBingoBtn() {
        logger.info("click live bingo button");
        getLiveBingoBtn().click();
        return this;
    }

    @Step("Click slots button")
    public FooterPage clickSlotsBtn() {
        logger.info("click slots button");
        sleep(500);
        getClickSlotBtn().click();
        return this;
    }

    @Step("Click bonus button")
    public FooterPage clickBonusBtn() {
        logger.info("click bonus button");
        getBonusBtn().click();
        return this;
    }

    private WebElement getAboutUsBtn() {
        return getClickableElementByXpath("//a[normalize-space()='About Us']");
    }

    private WebElement getFaqBtn() {
        return getClickableElementByXpath("//div[normalize-space()='F.A.Q.']");
    }

    public WebElement getLiveBettingBtn() {
        return getClickableElementByXpath("//a[normalize-space()='Live Betting']");
    }

    public WebElement getNotificationMessageFaq() {
        return getVisibilityElementByXpath("//h1[@class='entry-title']");
    }

    private WebElement getRulesBtn() {
        return getClickableElementByXpath("//div[normalize-space()='Rules']");
    }

    public WebElement getNotificationMessageRules() {
        return getVisibilityElementByXpath("//h1[@class='entry-title']");
    }

    private WebElement getContactUsBtn() {
        return getVisibilityElementByXpath("//a[normalize-space()='Contact Us']");
    }

    public FooterPage clickCloseInformationWindow() {
        getCloseInformationWindow().click();
        return this;
    }

    private WebElement getCloseInformationWindow() {
        return getClickableElementByXpath("//i[@class='doruk-close ll-modal__close-button-icon']");
    }

    public WebElement getSportBettingBtn() {
        return getClickableElementByXpath("//a[normalize-space()='Sport Betting']");
    }

    public WebElement getVirtualSportsBtn() {
        return getClickableElementByXpath("//a[contains(text(),'Virtual Sports')]");
    }

    public WebElement getNotificationMessageLive() {
        return getClickableElementByXpath("//div[@class='ll-header__menu--sticky slick-list__top-container--desktop']//span[@class='menu-item__label'][normalize-space()='live']");
    }

    private WebElement getLiveCasinoBtn() {
        return getClickableElementByXpath("//a[normalize-space()='Live Casino']");
    }

    private WebElement getLiveBingoBtn() {
        return getClickableElementByXpath("//a[normalize-space()='Live Bingo']");
    }

    private WebElement getClickSlotBtn() {
        return getClickableElementByXpath("//a[contains(text(),'Slots')]");
    }

    private WebElement getBonusBtn() {
        return getClickableElementByXpath("//a[normalize-space()='Bonus']");
    }

    @Step("Assert true url contains about us")
    public FooterPage assertTrueUrlContainsAboutus() {
        logger.info("assert true url contains about us");
        new FooterPage(driver);
        assertTrue(WaitUtils.waitUrlContains(driver, "/aboutus"), "url is /aboutus");
        return this;
    }

    @Step("Assert equals get notification message faq")
    public FooterPage assertEqualsGetNotificationMessageFaq() {
        logger.info("assert equals get notification message faq");
        new FooterPage(driver);
        Assert.assertEquals(getNotificationMessageFaq().getText(), "FREQUENTLY ASKED QUESTIONS");
        driver.switchTo().defaultContent();
        return this;
    }

    @Step("Assert equals get notification message rules")
    public FooterPage assertEqualsGetNotificationMessageRules() {
        logger.info("assert equals get notification message rules");
        new FooterPage(driver);
        Assert.assertEquals(getNotificationMessageRules().getText(), "General Rules");
        driver.switchTo().defaultContent();
        return this;
    }

    @Step("Assert true url contains contact us")
    public FooterPage assertTrueUrlContainsContactUs() {
        logger.info("assert true url contains contact us");
        new FooterPage(driver);
        assertTrue(WaitUtils.waitUrlContains(driver, "/contact-us"), "url is /contact-us");
        return this;
    }

    @Step("Assert true url contains sport/1")
    public FooterPage assertTrueUrlContainsSport1() {
        logger.info("assert true url contains sport/1");
        new FooterPage(driver);
        assertTrue(WaitUtils.waitUrlContains(driver, "/sport/1"), "url is /sport/1");
        return this;
    }

    @Step("Assert equals get notification message live")
    public FooterPage assertEqualsGetNotificationMessageLive() {
        logger.info("assert equals get notification message live");
        new FooterPage(driver);
        Assert.assertEquals(getNotificationMessageLive().getText(), "LIVE");
        return this;
    }

    @Step("Assert true url contains virtual")
    public FooterPage assertTrueUrlContainsVirtual() {
        logger.info("assert true url contains virtual");
        new FooterPage(driver);
        assertTrue(WaitUtils.waitUrlContains(driver, "/virtual"), "url is /virtual");
        return this;
    }

    @Step("Assert true url contains casino")
    public FooterPage assertTrueUrlContainsCasino() {
        logger.info("assert true url contains casino");
        new FooterPage(driver);
        assertTrue(WaitUtils.waitUrlContains(driver, "/casino"), "url is /casino");
        sleep(500);
        return this;
    }

    @Step("Assert true url contains live games")
    public FooterPage assertTrueUrlContainsliveGames() {
        logger.info("assert true url contains live games");
        new FooterPage(driver);
        assertTrue(WaitUtils.waitUrlContains(driver, "/live-games"), "url is /live-games");
        return this;
    }

    @Step("Assert true url contains slots")
    public FooterPage assertTrueUrlContainsSlots() {
        logger.info("assert true url contains slots");
        new FooterPage(driver);
        assertTrue(WaitUtils.waitUrlContains(driver, "/slots"), "url is /slots");
        return this;
    }

    @Step("Assert true url contains promo")
    public FooterPage assertTrueUrlContainsPromo() {
        logger.info("assert true url contains promo");
        new FooterPage(driver);
        assertTrue(WaitUtils.waitUrlContains(driver, "/promo"), "url is /promo");
        return this;
    }
}
