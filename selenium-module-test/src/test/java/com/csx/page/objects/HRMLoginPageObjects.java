package com.csx.page.objects;

import jakarta.inject.Singleton;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Singleton
public class HRMLoginPageObjects {
    @FindBy(name="username")
    public WebElement txtUsername;

    @FindBy(name="password")
    public WebElement txtPassword;

    @FindBy(xpath="//button[normalize-space()='Login']")
    public WebElement btnLogin;

    @FindBy(xpath = "//p[text()='Invalid credentials']")
    public WebElement lblInvalidCredentials;

    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    public WebElement lblWelcome;


    @FindBy(xpath="//li/a[text()='Logout']")
    public WebElement lnkLogout;

    @FindBy(xpath="//div[@class='orangehrm-login-branding']//img")
    public WebElement imgLogo;
}
