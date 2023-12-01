package com.csx.page.actions;

import jakarta.enterprise.context.ApplicationScoped;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


@ApplicationScoped
public class CsxDemoPageObjects {

  @FindBy(how = How.XPATH, using = "//*[@id=\"header_logo\"]/a/img")
  WebElement csxImage;
}
