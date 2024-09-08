package org.example.pages;
import static org.example.stepDefs.Hooks.driver;

import org.openqa.selenium.support.PageFactory;

public class P00_Base {
    public P00_Base (){PageFactory.initElements(driver, this);}
}
