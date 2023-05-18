package tests.signIn;

import helper.UserCreations;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.signInPage.SignInPage;
import tests.AbstractTestBase;

public class TestValidationSignIn extends AbstractTestBase {

    @Test
    @Description("Check login with unregistered user name")
    public void checkLoginUnregisteredEmail() {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signInUserWithoutCode(UserCreations.WRONG_USER_NAME, UserCreations.PASSWORD)
                  .assertEqualsGetErrorMessageText();
    }

    @Test
    @Description("Check login with not valid password")
    public void checkLoginWithInvalidPassword() {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signInUserWithoutCode(UserCreations.USER_NAME, UserCreations.PASSWORD + "@")
                  .assertEqualsGetErrorMessageText();
    }

    @Test
    @Description("Check valid login")
    public void checkValidLogin() {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signInUserWithoutCode(UserCreations.USER_NAME, UserCreations.PASSWORD)
                  .assertTrueIsDisplayedUserName();
    }
}
