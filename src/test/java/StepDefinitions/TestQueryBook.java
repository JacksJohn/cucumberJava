package StepDefinitions;

import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.*;
import junit.framework.*;



public class TestQueryBook {
	
	private static final String[] MKPage = null;
    WebDriver driver=null;
	String url="https://www.tmsandbox.co.nz";
	
	//utility Dr=new utility(driver);
	
	
	public void iDriver ()
	{
		WebDriver driver=null;
		String projPath=System.getProperty("user.dir");
		System.out.println("Project Path: "+projPath);
		System.setProperty("webdriver.edge.driver", projPath+"/Driver/msedgedriver.exe");
		this.driver=new EdgeDriver();	
	}
	
	public void urlLaunch()
	{driver.navigate().to(url);}
	
	public void pLoadWait ()
	{   driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);}
	
	public void winResize ()
	{driver.manage().window().maximize();}
	
	
	
	
	//Trade Me Webpage load Check
	@Given("The Trademe Sandbox Page is open")
	public void the_trademe_sandbox_page_is_open() throws InterruptedException 
	{
		String FirstPageCheck="Trade Me";
		iDriver();
		urlLaunch();
		winResize();	    
		pLoadWait();
		Thread.sleep(3000);
	    String TM=driver.findElement(By.linkText("Trade Me")).getText();
	    Assert.assertEquals(FirstPageCheck, TM);
	    System.out.println("Trademe Page Load Successful");
	}

	//Market Place WebPage Load Check
	@When("the user clicks on Market Place")
	public void the_user_clicks_on_market_place() throws InterruptedException 
	{
		
		String MKPageCheck="All categories";
		driver.findElement(By.id("SearchTabs1_MarketplaceLink")).click();
		pLoadWait();
		Thread.sleep(3000);
	    String MKPage= driver.findElement(By.id("SearchType")).getText();
	    
	    assertTrue(MKPage.contains(MKPageCheck));
	    System.out.println("Market Place Page Load Successful");
	}
	

	//User action-2 to Click on Books
	@And("clicks on the Books")
	public void clicks_on_the_Books() throws InterruptedException 
	{
		String Bookvalidate="Books";
		Thread.sleep(3000);
		driver.findElement(By.linkText("Books")).click();
		pLoadWait();
	    String PgTxt= driver.findElement(By.id("PageHeading")).getText();
	    Assert.assertEquals(Bookvalidate,PgTxt);
	    System.out.println("All Books Listing Successful");	 
	    
	}
			
	    
	//User action-3 to Select Used category
	@And("filters with condition as Used")
	public void filters_with_condition_as_Used() throws InterruptedException {
		String UsedBtnValidate="Used";
		Thread.sleep(3000);
		driver.findElement(By.linkText("Used")).click();
		pLoadWait();
	    String UsebtnCheck=driver.findElement(By.id("ListingsTitle_allnewused_used_link")).getText();
	    Assert.assertEquals(UsedBtnValidate,UsebtnCheck);
	    System.out.println("Used Books Listing Successful");
	}

	
	@And("clicks the book of choice")
	public void clicks_the_book_of_choice() throws InterruptedException {
		
		String BkLdPgcheck="Description";
		driver.findElement(By.className("image")).click();
		pLoadWait();
		Thread.sleep(3000);
		String PageDesc=driver.findElement(By.id("DetailTabs_descriptionTabLink")).getText();
		Assert.assertEquals(BkLdPgcheck,PageDesc);
	    System.out.println("Page Load successful with text display: "+PageDesc);
	}

	@Then("the books details are displayed")
	public void the_books_details_are_displayed() {
		String ListNum=driver.findElement(By.className("listing-id")).getText();
		assertNotNull(ListNum);
		System.out.println("The listing Number is: "+ListNum);
		
		String BuyNow=driver.findElement(By.id("BuyNow_BuyNow")).getText();
		assertNotNull(BuyNow);
		System.out.println("The Buy Now Price is: "+BuyNow);
		
		String StartPr=driver.findElement(By.id("Bidding_CurrentBidValue")).getText();
		assertNotNull(StartPr);
		System.out.println("The Start Price is: "+StartPr);
		
		String Desc=driver.findElement(By.id("DetailTabs_mainListingDetailTabContentBoxdescription")).getText();
		assertNotNull(Desc);
		System.out.println("Book Title is: "+Desc);
		
		
		
		String selLoc=driver.findElement(By.id("ShippingDetails_SellerLocation")).getText();
		assertNotNull(selLoc);
		System.out.println("Loc: "+selLoc);
		
		
		driver.close();
		driver.quit();
	}


}
