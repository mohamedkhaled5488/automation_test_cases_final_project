package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;

public class D01_registerStepDef {

    P01_register Reg = new P01_register();

    SoftAssert soft = new SoftAssert();

    Faker fake = new Faker();

    @When("User click on RegisterIcon")
    public void RegisterIcon() {
        Reg.RegisterIcon.click();
    }

    @And("User select Gender")
    public void userSelectGender() {
        Reg.Gender.click();
    }


    @And("User enter FirstName {string}")
    public void userEnterFirstName(String FName) {
        Reg.FirstName.sendKeys(FName);
    }


    @And("User enter LastName  {string}")
    public void userEnterLastName(String LName) {
        Reg.LastName.sendKeys(LName);
    }

    @And("User select DateOfBirth")
    public void userSelectDateOfBirth() {
        Reg.Day.get(18).click();
        Reg.Month.get(4).click();
        Reg.Year.get(66).click();
    }

    @And("User enter Email")
    public void userEnterEmail() {
        String email = fake.internet().safeEmailAddress();
        Reg.Email.sendKeys(email);
    }

    @And("User enter CompanyName")
    public void userEnterCompanyName() {
        Reg.CompanyName.sendKeys("AMIT");
    }


    @And("User enter Password & ConfirmationPassword")
    public void userEnterPasswordConfirmationPassword() {
        String pass = fake.internet().password();
        Reg.Password.sendKeys(pass);
        Reg.ConfirmationPassword.sendKeys(pass);
    }

    @And("User click on RegisterButton")
    public void userClickOnRegisterButton() {
        Reg.RegisterButton.click();
    }


    @Then("User create new account successfully")
    public void userCreateNewAccountSuccessfully() {
        String ActualText = driver.findElement(By.cssSelector("div[class=\"result\"]")).getText();
        String ExpectedText = "Your registration completed";
        soft.assertTrue(ActualText.contains(ExpectedText));


        boolean continueButton = Reg.ContinueButton.isDisplayed();
        soft.assertTrue(continueButton);


        boolean registerButton = Reg.AssertRegisterButton.isEmpty();
        soft.assertTrue(registerButton);


        String ActualURl = driver.getCurrentUrl();
        String ExpectedURl = "https://demo.nopcommerce.com/registerresult/1?returnUrl=/";
        soft.assertEquals(ActualURl, ExpectedURl);


        String ActualColor = driver.findElement(By.cssSelector("div[class=\"result\"]")).getCssValue("color");
        String ExpectedColor = "rgba(76, 177, 124, 1)";
        soft.assertEquals(ActualColor, ExpectedColor);


        String actualColor = Color.fromString(driver.findElement(By.cssSelector("div[class=\"result\"]")).getCssValue("color")).asHex();
        soft.assertEquals(actualColor, "#4cb17c");


        soft.assertEquals(Reg.AssertRegisterButton.size(), 0);

        soft.assertAll();
    }

}

