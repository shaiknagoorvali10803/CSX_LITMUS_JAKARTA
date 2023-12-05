package com.csx.page.objects;

import jakarta.inject.Singleton;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Singleton
public class HRMAdminPageObjects {
    @FindBy(id = "menu_admin_viewAdminModule")
    public WebElement admin_link;

    @FindBy(id = "menu_admin_employmentStatus")
    public WebElement users;

    @FindBy(id = "menu_admin_Job")
    public WebElement employmentStatus;

    @FindBy(id = "btnAdd")
    public WebElement addbtn;

    @FindBy(id = "empStatus_name")
    public WebElement empStatus_name;

    @FindBy(id = "btnSave")
    public WebElement save_btn;

    @FindBy(xpath = "//*///div[@class='message success fadable']")
    public WebElement message_save;
}
