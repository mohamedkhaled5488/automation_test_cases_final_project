package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;

public class D03_currenciesStepDef {
    P03_homePage home = new P03_homePage();
    SoftAssert soft = new SoftAssert();


    @When("User select currency {string}")
    public void userSelectCurrency(String currency) throws InterruptedException {
        Select select = new Select(home.Currencies);
        select.selectByVisibleText(currency);
        Thread.sleep(3000);
    }

    @Then("The products displayed in home page with prices shown as {string} of currency")
    public void theProductsDisplayedInHomePageWithPricesShownAsOfCurrency(String symbol) {

        //1- first way > 4 assertions
        String product0 = home.Symbols.get(0).getText();
        soft.assertTrue(product0.contains(symbol));

        String product1 = home.Symbols.get(1).getText();
        soft.assertTrue(product1.contains(symbol));

        String product2 = home.Symbols.get(2).getText();
        soft.assertTrue(product2.contains(symbol));

        String product3 = home.Symbols.get(3).getText();
        soft.assertTrue(product3.contains(symbol));

        //2- for loop to count list of web element
        for (int i = 0; i < home.Symbols.size(); i++) {
            String sign = home.Symbols.get(i).getText();
            Assert.assertTrue(sign.contains(symbol));
        }

        //3- enhanced for loop
        for (WebElement PriceSign : home.Symbols) {
            String Sign = PriceSign.getText();
            Assert.assertTrue(Sign.contains(symbol));
        }
    }
}
