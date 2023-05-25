package pages.home;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractBasePage;
import pages.utils.WaitUtils;
import static org.testng.Assert.assertTrue;

public class HomePage extends AbstractBasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HeaderPage getHeaderPage() {
        return new HeaderPage(driver);
    }

    @Override
    public void open() {
        openUrl(env);
    }

    @Step("Click button sport menu item")
    public HomePage clickMenuItemSport() {
        logger.info("click button sport menu item");
        getMenuItemSport().click();
        return this;
    }

    @Step("Click button live menu item ")
    public HomePage clickMenuItemLive() {
        logger.info("click button live menu item");
        getMenuItemLive().click();
        return this;
    }

    @Step("Click button slot battle menu item ")
    public HomePage clickMenuItemSlotBattle() {
        logger.info("click button slot battle menu item");
        getMenuItemSlotBattle().click();
        return this;
    }

    @Step("Click menu item slots")
    public HomePage clickMenuItemSlots() {
        logger.info("click menu item slots");
        getMenuItemSlots().click();
        return this;
    }

    @Step("Click menu item casino")
    public HomePage clickMenuItemCasino() {
        logger.info("click menu item casino");
        getMenuItemCasino().click();
        return this;
    }

    @Step("Click menu item bet on games")
    public HomePage clickMenuItemBetOnGames() {
        logger.info("click menu item bet on games");
        getMenuItemBetOnGames().click();
        return this;
    }

    @Step("click menu item Live Games")
    public HomePage clickMenuItemLiveGames() {
        logger.info("click menu item Live Games");
        getMenuItemLiveGames().click();
        return this;
    }

    @Step("Click menu item Twain")
    public HomePage clickMenuItemTwain() {
        logger.info("click menu item twain");
        getMenuItemTwain().click();
        return this;
    }

    @Step("Click menu item Lottery")
    public HomePage clickMenuItemLottery() {
        logger.info("click menu item lottery");
        getMenuItemLottery().click();
        return this;
    }

    @Step("Ckick menu item TvBet")
    public HomePage ckickMenuItemTvBet() {
        logger.info("ckick menu item tvBet");
        getMenuItemTvBet().click();
        return this;
    }

    @Step("Click menu item Virtual Sports")
    public HomePage clickMenuItemVirtualSports() {
        logger.info("click menu item Virtual Sports");
        getMenuItemVirtualSports().click();
        return this;
    }

    @Step("Click menu item Aviator")
    public HomePage clickMenuItemAviator() {
        logger.info("click menu item Aviator");
        getMenuItemAviator().click();
        closeModalIcon().click();
        return this;
    }

    @Step("Click menu item Promotions")
    public HomePage clickMenuitemPromotions() {
        logger.info("click menu item Promotions");
        getMenuItemPromotions().click();
        return this;
    }

    /**
     * ****************************************** Home page locators ************************************************
     */

    private WebElement getMenuItemPromotions() {
        return getClickableElementByXpath("//span[normalize-space()='promotions']");
    }

    private WebElement getMenuItemAviator() {
        return getClickableElementByXpath("//span[normalize-space()='aviator']");
    }

    private WebElement getMenuItemVirtualSports() {
        return getClickableElementByXpath("//span[normalize-space()='Virtual Sports']");
    }

    private WebElement getMenuItemTvBet() {
        return getClickableElementByXpath("//span[normalize-space()='TVBET']");
    }

    private WebElement getMenuItemLottery() {
        return getClickableElementByXpath("//span[normalize-space()='lottery']");
    }

    private WebElement getMenuItemTwain() {
        return getClickableElementByXpath("//span[normalize-space()='Twain']");
    }

    private WebElement getMenuItemLiveGames() {
        return getClickableElementByXpath("//span[normalize-space()='livegames']");
    }

    private WebElement closeModalIcon() {
        return getClickableElementByXpath("//i[@class='doruk-close ll-modal__close-button-icon']");
    }

    private WebElement getMenuItemBetOnGames() {
        return getClickableElementByXpath("//span[normalize-space()='bet on games']");
    }

    private WebElement getMenuItemCasino() {
        return getClickableElementByXpath("//span[normalize-space()='Casino']");
    }

    private WebElement getMenuItemSport() {
        return getClickableElementByXpath("//div[@id='slick-list__slider']//a[@href='/sport/1']/span[@class='menu-item__label']");
    }

    private WebElement getMenuItemLive() {
        return getClickableElementByXpath("//span[normalize-space()='live']");
    }

    private WebElement getMenuItemSlotBattle() {
        return getClickableElementByXpath("//span[normalize-space()='Slot battle']");
    }

    private WebElement getMenuItemSlots() {
        return getClickableElementByXpath("//span[normalize-space()='Slots']");
    }

    /**
     * ****************************************** Home page Asserts ************************************************
     */

    @Step("Assert true url contains Sport")
    public HomePage assertTrueUrlContainsSport() {
        logger.info("assert true url contains sport");
        assertTrue(WaitUtils.waitUrlContains(driver, "/sport/1"), "url is /sport/1");
        return this;
    }

    @Step("Assert true url contains Live")
    public HomePage assertTrueUrlContainsLive() {
        logger.info("assert true url contains live");
        assertTrue(WaitUtils.waitUrlContains(driver, "/sport/live"), "/sport/live");
        return this;
    }

    @Step("Assert true url contains Slot battle")
    public HomePage assertTrueUrlContainsSlotBattle() {
        logger.info("assert true url contains slot battle");
        assertTrue(WaitUtils.waitUrlContains(driver, "/slots-battles"), "/slots-battles");
        return this;
    }

    @Step("Assert true is displayed item Sport")
    public HomePage assertTrueIsDisplayedItemSport() {
        logger.info("assert true isDisplayed item sport");
        assertTrue(getMenuItemSport().isDisplayed());
        return this;
    }

    @Step("Assert true is displayed item Live")
    public HomePage assertTrueIsDisplayedItemLive() {
        logger.info("assert true isDisplayed item live");
        assertTrue(getMenuItemLive().isDisplayed());
        return this;
    }

    @Step("Assert true is displayed item Slot battle")
    public HomePage assertTrueIsDisplayedItemSlotBattle() {
        logger.info("assert true is displayed item slot battle");
        assertTrue(getMenuItemSlotBattle().isDisplayed());
        return this;
    }

    @Step("Assert true is displayed item Slots")
    public HomePage assertTrueIsDisplayedItemSlots() {
        logger.info("assert true is displayed item slots");
        assertTrue(getMenuItemSlots().isDisplayed());
        return this;
    }

    @Step("Assert true url contains Slots")
    public HomePage assertTrueUrlContainsSlots() {
        logger.info("assert true url contains slots");
        assertTrue(WaitUtils.waitUrlContains(driver, "/slots"), "/slots");
        return this;
    }

    @Step("Assert true is displayed item Casino")
    public HomePage assertTrueIsDisplayedItemCasino() {
        logger.info("assert true is displayed item casino");
        assertTrue(getMenuItemCasino().isDisplayed());
        return this;
    }

    @Step("Assert true url contains Casino")
    public HomePage assertTrueUrlContainsCasino() {
        logger.info("assert true url contains casino");
        assertTrue(WaitUtils.waitUrlContains(driver, "/casino"), "/casino");
        return this;
    }

    @Step("Assert true is displayed item Bet on games")
    public HomePage assertTrueIsDisplayedItemBetOnGames() {
        logger.info("assert true is displayed item bet on games");
        assertTrue(getMenuItemBetOnGames().isDisplayed());
        return this;
    }

    @Step("Assert true url contains Bet on games")
    public HomePage assertTrueUrlContainsBetOnGames() {
        logger.info("assert true url contains item bet on games");
        assertTrue(WaitUtils.waitUrlContains(driver, "/bet-games"), "/bet-games");
        return this;
    }

    @Step("Assert true is displayed item Twain")
    public HomePage assertTrueIsDisplayedItemTwain() {
        logger.info("assert true is displayed item twain");
        assertTrue(getMenuItemTwain().isDisplayed());
        return this;
    }

    @Step("Assert true url contains Twain")
    public HomePage assertTrueUrlContainsTwain() {
        logger.info("assert true url contains twain");
        assertTrue(WaitUtils.waitUrlContains(driver, "/twain"), "/twain");
        return this;
    }

    @Step("Assert true is displayed item Live Games")
    public HomePage assertTrueIsDisplayedItemLiveGames() {
        logger.info("assert true is displayed item live games");
        assertTrue(getMenuItemLiveGames().isDisplayed());
        return this;
    }

    @Step("Assert true url contains Live Games")
    public HomePage assertTrueUrlContainsLiveGames() {
        logger.info("assert true url contains live games");
        assertTrue(WaitUtils.waitUrlContains(driver, "/live-games"), "/live-games");
        return this;
    }

    @Step("Assert true is displayed item Lottery")
    public HomePage assertTrueIsDisplayedItemLottery() {
        logger.info("assert true is displayed item lottery");
        assertTrue(getMenuItemLottery().isDisplayed());
        return this;
    }

    @Step("Assert true url contains Lottery")
    public HomePage assertTrueUrlContainsLottery() {
        logger.info("assert true url contains lottery");
        assertTrue(WaitUtils.waitUrlContains(driver, "/lottery"), "/lottery");
        return this;
    }

    @Step("Assert true is displayed item TvBet")
    public HomePage assertTrueIsDisplayedItemTvBet() {
        logger.info("assert true is displayed item TvBet");
        assertTrue(getMenuItemLottery().isDisplayed());
        return this;
    }

    @Step("Assert true url contains TvBet")
    public HomePage assertTrueUrlContainsTvBet() {
        logger.info("assert true url contains TvBet");
        assertTrue(WaitUtils.waitUrlContains(driver, "/tvbet"), "/tvbet");
        return this;
    }

    @Step("Assert true is displayed item Virtual Sports")
    public HomePage assertTrueIsDisplayedItemVirtualSports() {
        logger.info("assert true is displayed item Virtual Sports");
        assertTrue(getMenuItemVirtualSports().isDisplayed());
        return this;
    }

    @Step("Assert true url contains Virtual Sports")
    public HomePage assertTrueUrlContainsVirtualSports() {
        logger.info("assert true url contains Virtual Sports");
        sleep(500);
        assertTrue(WaitUtils.waitUrlContains(driver, "/virtual"), "/virtual");
        return this;
    }

    @Step("Assert true is displayed item Aviator")
    public HomePage assertTrueIsDisplayedItemAviator() {
        logger.info("assert true is displayed item Aviator");
        assertTrue(getMenuItemAviator().isDisplayed());
        return this;
    }

    @Step("Assert true url contains Aviator")
    public HomePage assertTrueUrlContainsAviator() {
        logger.info("assert true url contains Aviator");
//        assertTrue(WaitUtils.waitUrlContains(driver, "/aviator"), "/aviator");
        return this;
    }

    @Step("Assert true is displayed item Promotions")
    public HomePage assertTrueIsDisplayedItemPromotions() {
        logger.info("assert true is displayed item Promotions");
        assertTrue(getMenuItemPromotions().isDisplayed());
        return this;
    }

    @Step("Assert true url contains Promotions")
    public HomePage assertTrueUrlContainsPromotions() {
        logger.info("assert true url contains Promotions");
        assertTrue(WaitUtils.waitUrlContains(driver, "/promo"), "/promo");
        return this;
    }
}