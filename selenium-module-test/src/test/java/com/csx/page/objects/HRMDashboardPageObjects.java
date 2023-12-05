package com.csx.page.objects;

import jakarta.inject.Singleton;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Singleton
public class HRMDashboardPageObjects {
    @FindBy(xpath="//h6[normalize-space()='Dashboard']")
    public WebElement dashboard_menu;

    @FindBy(xpath="//li/a[text()='Logout']")
    public WebElement lnkLogout;

    @FindBy(xpath="//button[@title='Assign Leave']")
    public WebElement assignleave_link;

    @FindBy(xpath="//a[text()='Assign Leave']")
    public WebElement assignleave_menu;

    @FindBy(xpath="//button[@title='Leave List']")
    public WebElement leavelist_link;

    @FindBy(xpath="//a[text()='Leave List']")
    public WebElement leavelist_menu;

}
