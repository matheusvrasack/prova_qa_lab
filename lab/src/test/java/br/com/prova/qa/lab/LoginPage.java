package br.com.prova.qa.lab;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import br.com.prova.qa.lab.pageObjects.PageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class LoginPage {
	
		@Test
		public void testeRegressao() throws InterruptedException {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("https://www.ibm.com/br-pt");
			
			WebDriverWait wait = new WebDriverWait (driver,10);
			WebDriver frame1 = driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='TrustArc Cookie Consent Manager']")));
			frame1.findElement(By.xpath("/html/body/div[8]/div[1]/div/div[3]/a[1]")).click();
			PageObjects object = new PageObjects(driver);
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			object.click1().click();
			object.click2().click();
			object.username().sendKeys("wilson@email.com");
			object.continueButton().click();
			object.password().sendKeys("wilson1234567890");
			object.loginButton().click();
			
			String errorMessage = "Incorrect IBMid or password. Please try again!";
			WebDriverWait waitText = new WebDriverWait (driver,10);
			WebElement text = waitText.until(ExpectedConditions.elementToBeClickable(By.id("password-error-msg")));
			String message = driver.findElement(By.id("password-error-msg")).getText();
			Assert.assertEquals(errorMessage,message);
			
			driver.close();
			driver.quit();
		}
	


}
