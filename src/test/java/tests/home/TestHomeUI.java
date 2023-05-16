package tests.home;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.home.HomePage;
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
}
