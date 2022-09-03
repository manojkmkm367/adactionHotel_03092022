package org.POM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.Hotel.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CancelBooking extends BaseClass {
	
	public CancelBooking() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//a[contains(text(),'Booked Itinerary')]")
	private WebElement linkItinerary;
	
	@FindBy(xpath = "//input[@name='ids[]']/following::td[1]//following::input[1]")
	private List<WebElement> totId;

	public WebElement getLinkItinerary() {
		return linkItinerary;
	}

	public List<WebElement> getTotId() {
		return totId;
	}
	
	
	public void cancleOrderId(String sheetName) throws InterruptedException, IOException {
		
		String orderId = getDataFromCell(sheetName, 1, 18);
		System.out.println("want to cancel this :"+orderId);
		
		
		elementClick(getLinkItinerary());		
		Thread.sleep(4000);		
		List<WebElement> totId2 = getTotId();
		
		for (WebElement temp : totId2) {				
			String orderList = temp.getAttribute("value");			
			if(orderList.endsWith(orderId)) {
				System.out.println("cancelingg... "+ orderId);
				elementClick(temp);
				System.out.println("Your Booking Cancelled Successfully...");
			}else {
				continue;
			}
		}
		
		Alert alert = driver.switchTo().alert();
		alert.accept();

	
		
		
	}
	
	
}
