package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.time.Duration;

import static org.example.stepDefs.Hooks.driver;


public class D08_WishlistStepDef {
    P03_homePage home = new P03_homePage();

    SoftAssert soft = new SoftAssert();



    @When("User clicks on wishlist button on HTC product")
    public void WishlistButton () {
    home.Wishlist.get(2).click();
    }

    @Then("Verify that success message will be displayed and color of wishlist")
    public void verifyThatSuccessMessageWillBeDisplayedAndColorOfWishlist() {
    soft.assertTrue(home.SuccessMessage.isDisplayed());

    soft.assertTrue(home.SuccessMessage.getText().contains("The product has been added to your wishlist"));


    String RGBAColor = home.SuccessMessage.getCssValue("background-color");
    String HEXColor = Color.fromString(RGBAColor).asHex();
    soft.assertEquals(HEXColor, "#4bb07a");

    soft.assertAll();
    }




    @And("User clicks on wishlist icon on the top of the page")
    public void userClicksOnWishlistIconOnTheTopOfThePage() {
        WebDriverWait Explicit = new WebDriverWait(driver, Duration.ofSeconds(7));
        Explicit.until(ExpectedConditions.invisibilityOf(home.SuccessMessage));
        home.WishlistIcon.click();
    }

    @Then("Verify that quantity value is increased")
    public void verifyThatQuantityValueIsIncreased() {
    String Quantity = home.WishlistQuantity.getAttribute("value");
    soft.assertTrue(Integer.parseInt(Quantity)>0);

    }
}
