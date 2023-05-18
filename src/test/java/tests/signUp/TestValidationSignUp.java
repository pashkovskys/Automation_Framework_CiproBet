package tests.signUp;

import helper.UserCreations;
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
                  .assertEqualsCheckSignUpValidationPassword();

        signUpPage.clickClearPassword()
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

    @Test
    @Description("Checking required fields on the registration page")
    public void checkRequiredFieldsOnTheRegistrationPage(){
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.open();
        signUpPage.clickSignUp()
                  .clickSubmitBtn()

                  .assertEqualsDisplayWarningInRequiredInputFieldUserName()
                  .assertDisplayWarningInRequiredInputFieldEmail()
                  .assertDisplayWarningInRequiredInputFieldEmailRepeat()
                  .assertDisplayWarningInRequiredInputFieldPassword()
                  .assertDisplayWarningInRequiredInputFieldPasswordRepeat()
                  .assertDisplayWarningInRequiredInputFieldName()
                  .assertDisplayWarningInRequiredInputFieldSurName()
                  .assertDisplayWarningInRequiredInputFieldID()
                  .assertDisplayWarningInRequiredInputFieldPhoneNamber()
                  .assertDisplayWarningInRequiredInputFieldOver18Ears();
    }

    @Test
    @Description("Check registration without agreeing to the Terms & Conditions")
    public void checkRegistrationWithoutAgreeingToTheTermsConditions(){
        SignUpPage signUpPage = new SignUpPage(driver);

        String email = UserCreations.getRandomUserEmail();
        signUpPage.registrationUser(email)
                  .clickSubmitBtn()
                  .assertEqualsConfirmationOfTheTermsConditionsBeforeRegistration();
    }

    @Test
    @Description("Check registrations with invalid username")
    public void checkRegistrationsWithInvalidUserName(){
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.open();
        signUpPage.clickSignUp()
                  .setInvalidUserName()
                  .clickSubmitBtn()
                  .assertDisplayWarningInRequiredInvalidUserName();
    }

    @Test
    @Description("Check registrations with invalid Password")
    public void checkRegistrationsWithInvalidPassword(){
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.open();
        signUpPage.clickSignUp()
                  .setInvalidPassword()
                  .clickSubmitBtn()
                  .assertDisplayWarningInRequiredInvalidPassword();
    }
}
