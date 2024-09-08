package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.example.stepDefs.Hooks.driver;


public class D06_homeSlidersStepDef {
    P03_homePage home = new P03_homePage();
    SoftAssert soft = new SoftAssert();


    @When("User select on First Slider home page")
    public void SelectFirstSlide() {
        home.IconHome.get(0).click();
    }


    @And("User click on First selected slider")
    public void userClickOnFirstSelectedSlider() {
        home.Slider.get(0).click();
//        WebDriverWait Explicit = new WebDriverWait(driver, Duration.ofSeconds(7));
//        Explicit.until(ExpectedConditions.numberOfWindowsToBe(2));
    }


    @Then("User should direct into First product link")
    public void userShouldDirectIntoFirstProductLink() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/nokia-lumia-1020");
    }


    @When("User select on Second Slider home page")
    public void userSelectOnSecondSliderHomePage() {
        home.IconHome.get(1).click();
    }


    @And("User click on Second selected slider")
    public void userClickOnSecondSelectedSlider() {
        home.Slider.get(1).click();
//        WebDriverWait Explicit = new WebDriverWait(driver, Duration.ofSeconds(7));
//        Explicit.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    @Then("User should direct into Second product link")
    public void userShouldDirectIntoSecondProductLink() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/iphone-6");
    }


}
