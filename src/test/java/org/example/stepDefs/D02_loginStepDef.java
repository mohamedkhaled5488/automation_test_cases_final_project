package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;

public class D02_loginStepDef {
    P02_login Reg = new P02_login();
    SoftAssert soft = new SoftAssert();


    @When("User click on LoginIcon")
    public void LoginIcon() {
        Reg.LoginIcon.click();
    }


    @And("User enter ValidEmail {string}")
    public void userEnterValidEmail(String email) {
        Reg.Email.sendKeys(email);
    }


    @And("User enter ValidPassword {string}")
    public void userEnterValidPassword(String pass) {
        Reg.Password.sendKeys(pass);
    }


    @And("User click on LoginButton")
    public void userClickOnLoginButton() {
        Reg.LoginButton.click();
    }

    @Then("User successfully login to their account")
    public void userSuccessfullyLoginToTheirAccount() {
        String ActualURl = driver.getCurrentUrl();
        String ExpectedURL = "https://demo.nopcommerce.com/";
        soft.assertEquals(ActualURl, ExpectedURL);

        boolean myAccount = Reg.MyAccount.isDisplayed();
        soft.assertTrue(myAccount);

        boolean loginButton = Reg.AssertLoginButton.isEmpty();
        soft.assertTrue(loginButton);

        soft.assertEquals(Reg.AssertLoginButton.size(), 0);

        soft.assertAll();
    }

    @And("User enter InvalidEmail {string}")
    public void userEnterInvalidEmail(String invalidEmail) {
        Reg.Email.sendKeys(invalidEmail);
    }

    @Then("User failed login to their account")
    public void userFailedLoginToTheirAccount() {
        String ActualURl = driver.getCurrentUrl();
        String ExpectedURL = "https://demo.nopcommerce.com/login?returnurl=%2F";
        soft.assertEquals(ActualURl, ExpectedURL);

        boolean LoginButton = Reg.LoginButton.isDisplayed();
        soft.assertTrue(LoginButton);


        String ActualText = driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]")).getText();
        String ExpectedText = "Login was unsuccessful";
        soft.assertTrue(ActualText.contains(ExpectedText));


        String ActualColor = Color.fromString(driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]")).getCssValue("color")).asHex();
        soft.assertEquals(ActualColor, "#e4434b");

        soft.assertEquals(Reg.AssertLoginButton.size(), 1);


        soft.assertAll();
    }
}
