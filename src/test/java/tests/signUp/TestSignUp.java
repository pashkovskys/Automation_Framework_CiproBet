package tests.signUp;

import helper.UserCreations;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.signUpPage.SignUpPage;
import tests.AbstractTestBase;

public class TestSignUp extends AbstractTestBase {

    @Test
    @Description("Registration new user")
    public void checkRegistrationUser() {
        SignUpPage signUpPage = new SignUpPage(driver);

        String email = UserCreations.getRandomUserEmail();
        signUpPage.registrationUser(email)
                  .clickAgreeBtn()
                  .clickSubmitBtn()

                  .assertTrueIsPresentSignUpBtn();
    }

    @Test
    @Description("Sign Up with registration email")
    public void checkSignUpWithRegistrationEmail() {
        SignUpPage signUpPage = new SignUpPage(driver);

        String email = UserCreations.USER_EMAIL;
        signUpPage.registrationUser(email)
                  .assertTrueGetErrorMessageWithRegistrationEmail();
    }

    @Test
    @Description("Check Log In button in sign up page")
    public void checkRedirectToLogin() {
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.open();
        signUpPage.clickAlreadyHaveAccountBtn()
                  .assertTrueCheckLogInButtonInSignUpPage();
    }

    @Test
    @Description("Check Terms Of Service button in sign up page")
    public void checkTermsOfService() {
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.open();
        signUpPage.setTermsOfService()

                  .asserTruetUrlContains();
    }

    @Test
    @Description("Check Terms & Conditions button in sign up page")
    public void checkTTermsOfConditions() {
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.open();
        signUpPage.setTermsOfConditions()

                  .assertEqualsMassegeRules();
    }

    @Test
    @Description("Check Privacy Policy button in sign up page")
    public void checkPrivacyPolicy() {
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.open();
        signUpPage.setPrivacyPolicy()

                  .assertTrueUrlContains();
    }
}
