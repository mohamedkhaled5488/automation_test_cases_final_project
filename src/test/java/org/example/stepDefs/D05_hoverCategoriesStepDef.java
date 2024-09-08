package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class D05_hoverCategoriesStepDef {
    P03_homePage home = new P03_homePage();
    SoftAssert soft = new SoftAssert();

    List<WebElement> SubCategories = new ArrayList<>();

    @When("User select random from three main category")
    public void SelectRandom() throws InterruptedException {
        List<WebElement> Categories = new ArrayList<>();
        Categories.add(home.Computers);
        Categories.add(home.Electronics);
        Categories.add(home.Apparel);

        int min = 0;
        int max = Categories.size()-1;
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);

// Class under name "Actions" : It's function to make hover
        Actions action = new Actions(driver);
        action.moveToElement(Categories.get(random_int)).perform();
        Thread.sleep(3000);

        Actions action2 = new Actions(driver);
        action2.moveToElement(Categories.get(0)).perform();
        Thread.sleep(3000);
    }


    @And("User hover and select random from sub main categories")
    public void userHoverAndSelectRandomFromSubMainCategories() throws InterruptedException {
        SubCategories.add(home.Desktop);
        SubCategories.add(home.Notebooks);
        SubCategories.add(home.Software);

        int min = 0;
        int max = SubCategories.size()-1;
        int randoms_int = (int)Math.floor(Math.random() * (max - min + 1) +min);


        SubCategories.get(0).click();
        Thread.sleep(3000);

    }

    @Then("User should redirect to new sub-category page")
    public void userShouldRedirectToNewSubCategoryPage() {
        String ActualSubCategory = SubCategories.get(0).getText().toLowerCase().trim();
        String ExpectedSubCategory = home.PapgeSubTitle.getText().toLowerCase().trim();
        Assert.assertTrue(ExpectedSubCategory.contains(ActualSubCategory));
    }
}
