package tests.home;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.home.HeaderPage;
import tests.AbstractTestBase;
import static org.testng.Assert.assertTrue;
import static pages.utils.CheckUtil.isPresent;


public class TestHeader extends AbstractTestBase {

    @Test
    @Description("Verification header buttons test")
    public void verifyHeaderButtons() {
        HeaderPage headerPage = new HeaderPage(driver);

        headerPage.open();

        assertTrue(isPresent(headerPage.getCiproBetBtn()));
        assertTrue(isPresent(headerPage.getChangeLanguageBtn()));
        assertTrue(isPresent(headerPage.getLoginBtn()));
        assertTrue(isPresent(headerPage.getSignUpBtn()));
    }

    @Test
    @Description("Test button information in header")
    public void checkHeaderButtons() {
        HeaderPage headerPage = new HeaderPage(driver);

        headerPage.open();
        headerPage.clickCiproBetBtn()
                .assertTrueUrlContains()
                .clickChangeLanguageBtn()
                .assertEqualsGetLanguageLogo()
                .setLoginBtn()
                .assertEqualsGetMemberLogin()
                .clouseMemberLoginIcon()
                .setSignUpBtn()
                .assertEqualsGetRegistrationForm();
    }
}
