package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;

import static org.example.stepDefs.Hooks.driver;

public class D07_followUsStepDef {
    P03_homePage home = new P03_homePage();
    SoftAssert soft = new SoftAssert();



@When("User scroll down and click on FacebookIcon")
    public void FacebookIcon () throws InterruptedException {
    home.SocialMedia.get(0).click();
    Thread.sleep(3000);

}


    @Then("User should be directed to Facebook Website")
    public void userShouldBeDirectedToFacebookWebsite() {
        WebDriverWait Explicit = new WebDriverWait(driver, Duration.ofSeconds(7));
        Explicit.until(ExpectedConditions.numberOfWindowsToBe(2));

        ArrayList<String> Tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(Tabs.get(1));

        soft.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/nopCommerce");
}



    @When("User scroll down and click on TwitterIcon")
    public void userScrollDownAndClickOnTwitterIcon() throws InterruptedException {
    home.SocialMedia.get(1).click();
    Thread.sleep(3000);
    }

    @Then("User should be directed to Twitter Website")
    public void userShouldBeDirectedToTwitterWebsite() {
    WebDriverWait Explicit = new WebDriverWait(driver,Duration.ofSeconds(7));
    Explicit.until(ExpectedConditions.numberOfWindowsToBe(2));

    ArrayList<String> Tabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(Tabs.get(1));

    soft.assertEquals(driver.getCurrentUrl(),"https://twitter.com/nopCommerce");
    }



    @When("User scroll down and click on RSSIcon")
    public void userScrollDownAndClickOnRSSIcon() throws InterruptedException {
    home.SocialMedia.get(2).click();
    Thread.sleep(3000);
    }

    @Then("User should be directed to RSS Website")
    public void userShouldBeDirectedToRSSWebsite() {
    WebDriverWait Explicit = new WebDriverWait(driver,Duration.ofSeconds(7));
    Explicit.until(ExpectedConditions.numberOfWindowsToBe(2));

    ArrayList<String> Tabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(Tabs.get(1));

    soft.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/new-online-store-is-open");
    }



    @When("User scroll down and click on YouTubeIcon")
    public void userScrollDownAndClickOnYouTubeIcon() throws InterruptedException {
    home.SocialMedia.get(3).click();
    Thread.sleep(3000);
    }

    @Then("User should be directed to YouTube Website")
    public void userShouldBeDirectedToYouTubeWebsite() {
    WebDriverWait Explicit = new WebDriverWait(driver,Duration.ofSeconds(7));
    Explicit.until(ExpectedConditions.numberOfWindowsToBe(2));


    ArrayList<String> Tabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(Tabs.get(1));

    soft.assertEquals(driver.getCurrentUrl(),"https://www.youtube.com/user/nopCommerce\"");
    }




    @When("User scroll down and click on {string} icons")
    public void userScrollDownAndClickOnIcons(String networks) {
    home.NetworkIcons(networks).click();

    }

    @Then("User redirected to social networks {string}")
    public void userRedirectedToSocialNetworks(String links) {
    WebDriverWait Explicit = new WebDriverWait(driver,Duration.ofSeconds(7));
    Explicit.until(ExpectedConditions.numberOfWindowsToBe(2));

    ArrayList<String> Tabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(Tabs.get(1));

    String CurrentURL =driver.getCurrentUrl();
    soft.assertEquals(CurrentURL,links);

    soft.assertAll();
    }

}
