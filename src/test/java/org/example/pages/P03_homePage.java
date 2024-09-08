package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class P03_homePage extends P00_Base {

    //F03 Currencies

    @FindBy(id = "customerCurrency")
    public WebElement Currencies;


    @FindBy(css = "span[class=\"price actual-price\"]")
    public List<WebElement> Symbols;

///////////////////////////////////////////////////////////////////////


    //    F04 Search
    @FindBy(id = "small-searchterms")
    public WebElement SearchBar;


    @FindBy(css = "button[type=\"submit\"]")
    public WebElement Searchbotton;


    @FindBy(css = "h2[class=\"product-title\"]>a")
    public List<WebElement> SearchResults;


////////////////////////////////////////////////////////////////////////

    // F05 Hover
    @FindBy(css = "a[href=\"/computers\"]")
    public WebElement Computers;

    @FindBy(css = "a[href=\"/electronics\"]")
    public WebElement Electronics;

    @FindBy(css = "a[href=\"/apparel\"]")
    public WebElement Apparel;


    @FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[1]/a")
    public WebElement Desktop;


    @FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
    public WebElement Notebooks;

    @FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[3]/a")
    public WebElement Software;


    @FindBy(css = "div[class=\"page-title\"]>h1")
    public WebElement PapgeSubTitle;

    ///////////////////////////////////////////////////////////////////

// F06_HomeSliders

    @FindBy(css = "div[class=\"nivo-controlNav\"]>a")
    public List<WebElement> IconHome;

    @FindBy(css = "div[id=\"nivo-slider\"]>a")
    public List<WebElement> Slider;

///////////////////////////////////////////////////////////////////////////

// F07_FollowUs Feature

    @FindBy(css = "ul[class=\"networks\"]>li>a")
    public List<WebElement> SocialMedia;


    // F07_FollowUs create return method by Non-Page Factory
    public WebElement NetworkIcons(String networks) {
        return driver.findElement(By.cssSelector("li[class=" + networks + "]>a"));
    }

//////////////////////////////////////////////////////
// F08_WishList Feature

@FindBy (css = "button[class=\"button-2 add-to-wishlist-button\"]")
    public List<WebElement> Wishlist;


@FindBy (css = "div[class=\"bar-notification success\"]")
    public WebElement SuccessMessage;


@FindBy (css = "span[class=\"wishlist-label\"]")
    public WebElement WishlistIcon;

@FindBy (css = "input[class=\"qty-input\"]")
    public WebElement WishlistQuantity;

}
