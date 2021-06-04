package br.com.prova.qa.lab.pageObjects;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PageObjects {
	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"ibm-universal-nav\"]/nav/div[2]/ul/li[1]/button")
	WebElement click1;
	
	@FindBy(xpath = "//*[@id=\"ibm-signin-minimenu-container\"]/li[1]/a")
	WebElement click2;
	
	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "continue-button")
	WebElement continueButton;
	
	@FindBy(id = "signinbutton")
	WebElement loginButton;
	
	
	public PageObjects(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
		}

	public WebElement click1() {
		return (click1);
	}
	public WebElement click2() {
		return (click2);
	}
	public WebElement username() {
		return (username);
	}
	public WebElement password() {
		return (password);
	}
	public WebElement continueButton() {
		return (continueButton);
	}
	public WebElement loginButton() {
		return (loginButton);
	}

}
