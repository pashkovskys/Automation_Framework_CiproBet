package tests.home;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.home.FooterPage;
import tests.AbstractTestBase;

public class TestFooter extends AbstractTestBase {

    @Test
    @Description("Test ciprobet information in footer")
    public void checkCiprobetInFooter() {
        FooterPage footerPage = new FooterPage(driver);

        footerPage.open();
        footerPage.clickAboutUsBtn()
                  .assertTrueUrlContainsAboutus();

        footerPage.clickFAQBtn()
                  .assertEqualsGetNotificationMessageFaq();

        footerPage.clickCloseInformationWindow()
                  .clickRulesBtn()
                  .assertEqualsGetNotificationMessageRules();

        footerPage.clickCloseInformationWindow()
                  .clickContactUsBtn()
                  .assertTrueUrlContainsContactUs();
    }


    @Test
    @Description("Test bettings information in footer")
    public void checkBettingsInFooter() {
        FooterPage footerPage = new FooterPage(driver);

        footerPage.open();
        footerPage.clickSportBettingBtn()
                  .assertTrueUrlContainsSport1();

        footerPage.clickLiveBettingBtn()
                  .assertEqualsGetNotificationMessageLive();

        footerPage.clickVirtualSportsBtn()
                  .assertTrueUrlContainsVirtual();
    }

    @Test
    @Description("Test casino information in footer")
    public void checkCasinoInFooter() {
        FooterPage footerPage = new FooterPage(driver);

        footerPage.open();
        footerPage.clickLiveCasinoBtn()
                  .assertTrueUrlContainsCasino();

        footerPage.clickLiveBingoBtn()
                  .assertTrueUrlContainsliveGames();

        footerPage.clickCloseInformationWindow()
                  .clickSlotsBtn()
                  .assertTrueUrlContainsSlots();
    }

    @Test
    @Description("Test short cuts information in footer")
    public void checkShortcutsFooter() {
        FooterPage footerPage = new FooterPage(driver);

        footerPage.open();
        footerPage.clickBonusBtn()
                  .assertTrueUrlContainsPromo();
    }

    @Test
    @Description("Check footer wrapper isDisplayed")
    public void checkFooterWrapperIsDisplayed() {
        FooterPage footerPage = new FooterPage(driver);

        footerPage.open();
        footerPage.assertTrueIsDisplayedBtnSlotSuperGame()
                  .assertTrueIsDisplayedLogoCiproBet()
                  .assertTrueIsDisplayedBtnHelp()
                  .assertTrueIsDisplayedBtnLiveSupport();
    }
}
