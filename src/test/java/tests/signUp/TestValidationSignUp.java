package tests.signUp;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.signUpPage.SignUpPage;
import tests.AbstractTestBase;

public class TestValidationSignUp extends AbstractTestBase {

    @Test
    @Description("Validation email in registration")
    public void checkSignUpValidationEmail() {
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.open();
        signUpPage.clickSignUp()
                .setEmail("TestEmail2023!" + "gmail.com")
                .clickAgreeBtn()
                .clickSubmitBtn()
                .assertEqualsCheckSignUpValidationEmail();
    }

    @Test
    @Description("Validation password in registration")
    public void checkSignUpValidationPassword() {
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.open();
        signUpPage.clickSignUp()
                .setEmail(getRandomNumber() + "@gmail.com")
                .setEmailRepeat(getRandomNumber() + "@gmail.com")
                .setPassword("Test123")
                .setPasswordRepeat("Test123")
                .clickAgreeBtn()
                .clickSubmitBtn()
                .assertEqualsCheckSignUpValidationPassword()
                .clickClearPassword()
                .setPassword("12345678")
                .clickClearPasswordRepeat()
                .setPasswordRepeat("12345678")
                .assertEqualsCheckSignUpValidationPassword();
    }

    @Test
    @Description("Registration with mismatched passwords")
    public void checkSignUpMismatchedPasswords() {
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.open();
        signUpPage.clickSignUp()
                .setPassword("TestPassword2022!")
                .setPasswordRepeat("TestPassword2022")
                .clickAgreeBtn()
                .clickSubmitBtn()
                .assertEqualsCheckSignUpMismatchedPasswords();
    }

    @Test
    @Description("Validation confirmation of the Terms & Conditions before registration")
    public void checkNoAcceptTermsConditionsNotification() {
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.open();
        signUpPage.clickSignUp()
                .clickSubmitBtn()
                .assertEqualsConfirmationOfTheTermsConditionsBeforeRegistration();
    }
}
