package tests.home;

import helper.UserCreations;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.home.HomePage;
import pages.signInPage.SignInPage;
import tests.AbstractTestBase;

public class TestHomeUI extends AbstractTestBase {

    @Test
    @Description("Sign in button in header test")
    public void checkSignInBtn() {
        HomePage homePage = new HomePage(driver);

        homePage.open();
        homePage.getHeaderPage()
                .clickSignInBtn()
                .assertEqualsGetMemberLogitScreenText();
    }

    @Test
    @Description("Sign up button in header test")
    public void checkSignUpBtn() {
        HomePage homePage = new HomePage(driver);

        homePage.open();
        homePage.getHeaderPage()
                .clickSignUpBtn()
                .assertTrueUrlContainsSignUp();
    }

    @Test
    @Description("Check button menu item")
    public void checkMenuItem() {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = new SignInPage(driver);

        signInPage.signInUser(UserCreations.USER_NAME, UserCreations.PASSWORD);
        homePage.clickMenuItemLive()
                .assertTrueIsDisplayedItemLive()
                .assertTrueUrlContainsLive();

        homePage.clickMenuItemSport()
                .assertTrueIsDisplayedItemSport()
                .assertTrueUrlContainsSport();

        homePage.clickMenuItemSlotBattle()
                .assertTrueIsDisplayedItemSlotBattle()
                .assertTrueUrlContainsSlotBattle();

        homePage.clickMenuItemSlots()
                .assertTrueIsDisplayedItemSlots()
                .assertTrueUrlContainsSlots();

        homePage.clickMenuItemCasino()
                .assertTrueIsDisplayedItemCasino()
                .assertTrueUrlContainsCasino();

        homePage.clickMenuItemBetOnGames()
                .assertTrueIsDisplayedItemBetOnGames()
                .assertTrueUrlContainsBetOnGames();

        homePage.clickMenuItemTwain()
                .assertTrueIsDisplayedItemTwain()
                .assertTrueUrlContainsTwain();

        homePage.clickMenuItemLiveGames()
                .assertTrueIsDisplayedItemLiveGames()
                .assertTrueUrlContainsLiveGames();

        homePage.clickMenuItemLottery()
                .assertTrueIsDisplayedItemLottery()
                .assertTrueUrlContainsLottery();

        homePage.ckickMenuItemTvBet()
                .assertTrueIsDisplayedItemTvBet()
                .assertTrueUrlContainsTvBet();

        homePage.clickMenuItemVirtualSports()
                .assertTrueIsDisplayedItemVirtualSports()
                .assertTrueUrlContainsVirtualSports();

        homePage.clickMenuItemAviator()
                .assertTrueIsDisplayedItemAviator()
                .assertTrueUrlContainsAviator();

        homePage.clickMenuitemPromotions()
                .assertTrueIsDisplayedItemPromotions()
                .assertTrueUrlContainsPromotions();
    }
}
