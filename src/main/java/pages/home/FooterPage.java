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

    @Step("Close information window")
    public FooterPage clickCloseInformationWindow() {
        logger.info("close information window");
        getCloseInformationWindow().click();
        return this;
    }

    /**
     * ****************************************** Footer page locators ************************************************
     */

    private WebElement getAboutUsBtn() {
        return getClickableElementByXpath("//a[normalize-space()='About Us']");
    }

    private WebElement getFaqBtn() {
        return getClickableElementByXpath("//div[normalize-space()='F.A.Q.']");
    }

    private WebElement getLiveBettingBtn() {
        return getClickableElementByXpath("//a[normalize-space()='Live Betting']");
    }

    private WebElement getNotificationMessageFaq() {
        return getVisibilityElementByXpath("//h1[@class='entry-title']");
    }

    private WebElement getRulesBtn() {
        return getClickableElementByXpath("//div[normalize-space()='Rules']");
    }

    private WebElement getNotificationMessageRules() {
        return getVisibilityElementByXpath("//h1[@class='entry-title']");
    }

    private WebElement getContactUsBtn() {
        return getVisibilityElementByXpath("//a[normalize-space()='Contact Us']");
    }


    private WebElement getCloseInformationWindow() {
        return getClickableElementByXpath("//i[@class='doruk-close ll-modal__close-button-icon']");
    }

    private WebElement getSportBettingBtn() {
        return getClickableElementByXpath("//a[normalize-space()='Sport Betting']");
    }

    private WebElement getVirtualSportsBtn() {
        return getClickableElementByXpath("//a[contains(text(),'Virtual Sports')]");
    }

    private WebElement getNotificationMessageLive() {
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

    private boolean isDisplayedBtnSlotSuperGame() {
        return getVisibilityElementByXpath("//span[contains(text(),'Slot super game - super super super super super su')]").isDisplayed();
    }

    private boolean isDisplayedLogoCiproBet() {
        return getVisibilityElementByXpath("//div[@class='ll-footer__logo']").isDisplayed();
    }

    private boolean isDisplayedBtnHelp() {
        return getVisibilityElementByXpath("//span[normalize-space()='Help']").isDisplayed();
    }

    private boolean isDisplayedBtnLiveSupport() {
        return getVisibilityElementByXpath("//span[normalize-space()='Live Support']").isDisplayed();
    }

    /**
     * ******************************************** Footer page Asserts ************************************************
     */

    @Step("Assert true url contains about us")
    public FooterPage assertTrueUrlContainsAboutus() {
        logger.info("assert true url contains about us");
        assertTrue(WaitUtils.waitUrlContains(driver, "/aboutus"), "url is /aboutus");
        return this;
    }

    @Step("Assert equals get notification message faq")
    public FooterPage assertEqualsGetNotificationMessageFaq() {
        logger.info("assert equals get notification message faq");
        Assert.assertEquals(getNotificationMessageFaq().getText(), "FREQUENTLY ASKED QUESTIONS");
        driver.switchTo().defaultContent();
        return this;
    }

    @Step("Assert equals get notification message rules")
    public FooterPage assertEqualsGetNotificationMessageRules() {
        logger.info("assert equals get notification message rules");
        Assert.assertEquals(getNotificationMessageRules().getText(), "General Rules");
        driver.switchTo().defaultContent();
        return this;
    }

    @Step("Assert true url contains contact us")
    public FooterPage assertTrueUrlContainsContactUs() {
        logger.info("assert true url contains contact us");
        assertTrue(WaitUtils.waitUrlContains(driver, "/contact-us"), "url is /contact-us");
        return this;
    }

    @Step("Assert true url contains sport/1")
    public FooterPage assertTrueUrlContainsSport1() {
        logger.info("assert true url contains sport/1");
        assertTrue(WaitUtils.waitUrlContains(driver, "/sport/1"), "url is /sport/1");
        return this;
    }

    @Step("Assert equals get notification message live")
    public FooterPage assertEqualsGetNotificationMessageLive() {
        logger.info("assert equals get notification message live");
        Assert.assertEquals(getNotificationMessageLive().getText(), "LIVE");
        return this;
    }

    @Step("Assert true url contains virtual")
    public FooterPage assertTrueUrlContainsVirtual() {
        logger.info("assert true url contains virtual");
        assertTrue(WaitUtils.waitUrlContains(driver, "/virtual"), "url is /virtual");
        return this;
    }

    @Step("Assert true url contains casino")
    public FooterPage assertTrueUrlContainsCasino() {
        logger.info("assert true url contains casino");
        assertTrue(WaitUtils.waitUrlContains(driver, "/casino"), "url is /casino");
        sleep(500);
        return this;
    }

    @Step("Assert true url contains live games")
    public FooterPage assertTrueUrlContainsliveGames() {
        logger.info("assert true url contains live games");
        assertTrue(WaitUtils.waitUrlContains(driver, "/live-games"), "url is /live-games");
        return this;
    }

    @Step("Assert true url contains slots")
    public FooterPage assertTrueUrlContainsSlots() {
        logger.info("assert true url contains slots");
        assertTrue(WaitUtils.waitUrlContains(driver, "/slots"), "url is /slots");
        return this;
    }

    @Step("Assert true url contains promo")
    public FooterPage assertTrueUrlContainsPromo() {
        logger.info("assert true url contains promo");
        assertTrue(WaitUtils.waitUrlContains(driver, "/promo"), "url is /promo");
        return this;
    }

    @Step("Assert true is displayed button slot super game")
    public FooterPage assertTrueIsDisplayedBtnSlotSuperGame() {
        logger.info("assert true is displayed button slot super game");
        assertTrue(isDisplayedBtnSlotSuperGame(), "Slot super game - super super super super super su");
        return this;
    }

    @Step("Assert true is displayed logo CiproBet")
    public FooterPage assertTrueIsDisplayedLogoCiproBet() {
        logger.info("Assert true is displayed logo CiproBet");
        assertTrue(isDisplayedLogoCiproBet());
        return this;
    }

    @Step("Assert true is displayed button Help")
    public FooterPage assertTrueIsDisplayedBtnHelp() {
        logger.info("assert true is displayed button Help");
        assertTrue(isDisplayedBtnHelp(), "Help");
        return this;
    }

    @Step("Assert true is displayed button Live Support")
    public FooterPage assertTrueIsDisplayedBtnLiveSupport() {
        logger.info("assert true is displayed button Live Support");
        assertTrue(isDisplayedBtnLiveSupport(), "Live Support");
        return this;
    }
}
