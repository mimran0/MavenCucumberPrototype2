package com.cucumber.MavenCucumberPrototype;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.os.WindowsUtils;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class StepDefinition_MC extends CommonAPI {
	WebDriver driver = null;

	// This method will Open Given Browser and Navigate to Mortgage Calculator
	// web site.
	@Given("^Open Browser MC - \"([^\"]*)\"$")
	public void open_Browser_MC(String BrowserName) throws Throwable {
		String vBaseURL = "https://www.mortgagecalculator.org/";
		CommonAPI CommonAPI = new CommonAPI();
		driver = CommonAPI.getDriver(BrowserName, vBaseURL);
		waitTime(15000);
	}

	@Then("^Enter \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" in the calculator and click on calculate button$")
	public void enter_Many_Data_in_the_calculator_and_click_on_calculate_button(String vhomevalue, String vprincipal,
			String vinterestRate, String vterm, String vproperty_tax, String vpmi, String vhoi) throws Throwable {
		scrolldown(driver, 300);
		driver.findElement(By.name("param[homevalue]")).sendKeys(vhomevalue);
		driver.findElement(By.name("param[principal]")).sendKeys(vprincipal);
		driver.findElement(By.name("param[interest_rate]")).sendKeys(vinterestRate);
		driver.findElement(By.name("param[term]")).sendKeys(vterm);
		driver.findElement(By.name("param[property_tax]")).sendKeys(vproperty_tax);
		driver.findElement(By.name("param[pmi]")).sendKeys(vpmi);
		driver.findElement(By.name("param[hoi]")).sendKeys(vhoi);
		waitTime(2000);
		driver.findElement(By.name("cal")).click();
		waitTime(17000);
		scrolldown(driver, 300);
	}

	// This method will compare Expected Mortgage Payment with Actual Mortgage
	// Payment in AUT.
	@Then("^Check \"([^\"]*)\" with Actual Payment$")
	public void check_Expected_Payment_with_Actual_Payment(String vExpectedPayment) throws Throwable {
		String vOutput = driver
				.findElement(By
						.xpath("//*[@id=\"calc\"]/form/section/section[2]/div/div/div[1]/div/div/div[3]/div[2]/div[2]/div[1]/div[1]/h3"))
				.getText();
		System.out.println(vOutput);
		try {
			Assert.assertEquals(vOutput, vExpectedPayment);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed because" + e);
		}
	}
	
	// This method will always be executed before EACH Cucumber Test Scenario.
		@Before
		public void CloseBrowsers_BeforeEachTestScenario() {
			WindowsUtils.killByName("chromedriver.exe");
			WindowsUtils.killByName("IEDriverServer.exe");
			WindowsUtils.killByName("geckodriver.exe");
			WindowsUtils.killByName("MicrosoftWebDriver.exe");
			WindowsUtils.killByName("MicrosoftEdge.exe");
		}

		// This method will always be executed after EACH Cucumber Test Scenario.
		@After
		public void CloseBrowsers_AfterEachTestScenario() {
			WindowsUtils.killByName("chromedriver.exe");
			WindowsUtils.killByName("IEDriverServer.exe");
			WindowsUtils.killByName("geckodriver.exe");
			WindowsUtils.killByName("MicrosoftWebDriver.exe");
			WindowsUtils.killByName("MicrosoftEdge.exe");
		}
}
