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
                .assertTrueUrlContainsAboutus()
                .clickFAQBtn()
                .assertEqualsGetNotificationMessageFaq()
                .clickCloseInformationWindow()
                .clickRulesBtn()
                .assertEqualsGetNotificationMessageRules()
                .clickCloseInformationWindow()
                .clickContactUsBtn()
                .assertTrueUrlContainsContactUs();
    }


    @Test
    @Description("Test bettings information in footer")
    public void checkBettingsInFooter() {
        FooterPage footerPage = new FooterPage(driver);
        footerPage.open();

        footerPage.clickSportBettingBtn()
                .assertTrueUrlContainsSport1()
                .clickLiveBettingBtn()
                .assertEqualsGetNotificationMessageLive()
                .clickVirtualSportsBtn()
                .assertTrueUrlContainsVirtual();
    }

    @Test
    @Description("Test casino information in footer")
    public void checkCasinoInFooter() {
        FooterPage footerPage = new FooterPage(driver);

        footerPage.open();
        footerPage.clickLiveCasinoBtn()
                .assertTrueUrlContainsCasino()
                .clickLiveBingoBtn()
                .assertTrueUrlContainsliveGames()
                .clickCloseInformationWindow()
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
}
