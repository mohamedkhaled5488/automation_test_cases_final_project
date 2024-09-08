package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;


public class P02_login extends P00_Base {

    @FindBy(css = "a[href=\"/login?returnUrl=%2F\"]")
    public WebElement LoginIcon;


    @FindBy(id = "Email")
    public WebElement Email;


    @FindBy(id = "Password")
    public WebElement Password;


    @FindBy(css = "button[type=\"submit\"][class=\"button-1 login-button\"]")
    public WebElement LoginButton;


    @FindBy(css = "button[type=\"submit\"][class=\"button-1 login-button\"]")
    public List<WebElement> AssertLoginButton;


    @FindBy(css = "a[href=\"/customer/info\"]")
    public WebElement MyAccount;


    @FindBy(css = "div[class=\"message-error validation-summary-errors\"]")
    public WebElement ErrorMessage;


}
