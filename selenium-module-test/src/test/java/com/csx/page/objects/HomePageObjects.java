package com.csx.page.objects;


import jakarta.inject.Singleton;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Singleton
public class HomePageObjects {

    @FindBy(name = "q")
    public WebElement searchBox;
    @FindBy(name = "btnK")
    public List<WebElement> searchBtns;

}
