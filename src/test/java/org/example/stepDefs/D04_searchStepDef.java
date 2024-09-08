package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;
import org.example.pages.P03_homePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;


public class D04_searchStepDef {
    P03_homePage home = new P03_homePage();
    SoftAssert soft = new SoftAssert();

    @When("User enter product name {string}")
    public void userEnterProductName(String PName) throws InterruptedException {
        home.SearchBar.sendKeys(PName);
        home.Searchbotton.click();
        Thread.sleep(3000);
    }

    @Then("All products contains {string} appear in search")
    public void allProductsContainsAppearInSearch(String PName) {
        String CurrentURl = driver.getCurrentUrl();
        String ExpectedURL = "https://demo.nopcommerce.com/search?q=";
        soft.assertTrue(CurrentURl.contains(ExpectedURL));


        for (int i = 0; i < home.SearchResults.size(); i++) {
            String ProductSearch = home.SearchResults.get(i).getText().toLowerCase().trim();
            Assert.assertTrue(ProductSearch.contains(PName.toLowerCase()));
        }

        soft.assertAll();
    }


    @When("User enter product sku {string}")
    public void userEnterProductSku(String PSKU) throws InterruptedException {
        home.SearchBar.sendKeys(PSKU);
        home.Searchbotton.click();
        Thread.sleep(3000);
    }

    @Then("All products contains SKU {string} appear in search")
    public void allProductsContainsSKUAppearInSearch(String PSKU) {
        String CurrentURl = driver.getCurrentUrl();
        String ExpectedURL = "https://demo.nopcommerce.com/search?q=";
        soft.assertTrue(CurrentURl.contains(ExpectedURL));

    }
}
