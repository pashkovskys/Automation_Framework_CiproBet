package tests.signIn;

import helper.UserCreations;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.home.HeaderPage;
import pages.signInPage.SignInPage;
import tests.AbstractTestBase;
import static org.testng.Assert.assertTrue;
import static pages.utils.CheckUtil.isPresent;


public class TestSignIn extends AbstractTestBase {
    @Test
    @Description("Check if the login is working")
    public void checkLogin() {
        SignInPage signInPage = new SignInPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        signInPage.signInUser(UserCreations.USER_NAME, UserCreations.PASSWORD);

        assertTrue(isPresent(headerPage.getNameBtn()), "user name button is present");
    }

    @Test
    @Description("Click 'Do not have an account? Sign Up' test")
    public void checkRedirectToSignUpPage() {
        SignInPage signInPage = new SignInPage(driver);

        signInPage.open();
        signInPage.clickLoginBtn()
                .clickNotHaveAccountBtn()
                .assertEqualsGetInfoMassageRegistrationForm();
    }

    @Test
    @Description("Check if the recovery password is working")
    public void checkForgotThePasswordLink() {
        SignInPage signInPage = new SignInPage(driver);

        signInPage.open();
        signInPage.clickLoginBtn()
                .setForgotThePasswordLink()
                .assertEqualsGetInfoMessageFargotPassword();
    }

    @Test
    @Description("Check the presence of a placeholder in the element")
    public void checkPlaceholder() {
        SignInPage signInPage = new SignInPage(driver);

        signInPage.open();
        signInPage.clickLoginBtn()
                .assertEqualsGetLoginUserNamePlaceholder()
                .assertEqualsGetLoginPasswordPlaceholder();
    }

    @Test
    @Description("Login to blocked account")
    public void checkBlockedUser() {
        SignInPage signInPage = new SignInPage(driver);
        String blockedEmail = "stab.testqa+W001Blocked@kajdgzyg.mailosaur.net";

        signInPage.signInUserWithoutCode(blockedEmail, UserCreations.PASSWORD)
                .assertEqualsGetNotificationMessage();
    }
}
