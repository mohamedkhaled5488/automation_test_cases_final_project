package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class P01_register extends P00_Base {

    @FindBy(css = "a[href=\"/register?returnUrl=%2F\"]")
    public WebElement RegisterIcon;

    @FindBy(id = "gender-male")
    public WebElement Gender;

    @FindBy(id = "FirstName")
    public WebElement FirstName;

    @FindBy(id = "LastName")
    public WebElement LastName;

    @FindBy(css = "select[name=\"DateOfBirthDay\"]>option")
    public List<WebElement> Day;

    @FindBy(css = "select[name=\"DateOfBirthMonth\"]>option")
    public List<WebElement> Month;


    @FindBy(css = "select[name=\"DateOfBirthYear\"]>option")
    public List<WebElement> Year;

    @FindBy(id = "Email")
    public WebElement Email;

    @FindBy(id = "Company")
    public WebElement CompanyName;

    @FindBy(id = "Password")
    public WebElement Password;

    @FindBy(id = "ConfirmPassword")
    public WebElement ConfirmationPassword;

    @FindBy(id = "register-button")
    public WebElement RegisterButton;


    @FindBy(id = "register-button")
    public List<WebElement> AssertRegisterButton;

    @FindBy(css = "a[class=\"button-1 register-continue-button\"]")
    public WebElement ContinueButton;

}
