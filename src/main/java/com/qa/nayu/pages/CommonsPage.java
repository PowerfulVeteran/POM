package com.qa.nayu.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.nayu.utils.ElementUtil;

public class CommonsPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	// 1. private By locators:
	
//	private By componentsLink = By.linkText("Components");
//	private By tabletLink = By.linkText("Tablets");
//	private By softwareLink = By.linkText("Software");
//	private By monitorLink = By.xpath("//a[contains(text(),'Monitor')]");		
	
	private By menuLinks = By.xpath("//div[contains(@class,'navbar-collapse')]/ul/li/a");		 
	// 2. constructors
	public CommonsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	// 3. public Page actions (methods)

	public void selectSubMenu(String parentMenu, String subMenu) {
		Actions action = new Actions(driver);
		
		By parentMenuLocator = By.xpath("//a[contains(text(),'"+parentMenu+"')]");
		By subMenuLocator = By.xpath("//a[contains(text(),'"+subMenu+"')]");		
		action.moveToElement(elementUtil.getElement(parentMenuLocator)).perform();
		elementUtil.waitForElementToBeClickable(5,subMenuLocator).click();
		
//		By parentMenuLocator = By.xpath("//a[contains(text(),'"+parentMenu+"')]");
//		By subMenuLocator = By.xpath("//a[contains(text(),'"+subMenu+"')]");		
//		action.moveToElement(elementUtil.getElement(parentMenuLocator)).perform();
//		elementUtil.waitForElementPresence(subMenuLocator, 5).click();
	}

	public List<String> getMenuLinksList() {
		List<WebElement> menuList = elementUtil.getElements(menuLinks);
		List<String> menuTextList = new ArrayList<String>();

		for (WebElement e : menuList) {
			menuTextList.add(e.getText().trim());
		}
		return menuTextList;
	}

}
