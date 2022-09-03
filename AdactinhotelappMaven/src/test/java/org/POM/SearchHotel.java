package org.POM;

import java.io.IOException;

import org.Hotel.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotel extends BaseClass {
	public SearchHotel() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "location")
	private WebElement dDbLocation;
	
	@FindBy(id = "hotels")
	private WebElement dDbHotel;
	
	@FindBy(id = "room_type")
	private WebElement dDbRoomType;
	
	@FindBy(id = "room_nos")
	private WebElement dDbRoomNos;
	
	@FindBy(id = "datepick_in")
	private WebElement datePickIn;
	

	@FindBy(id = "datepick_out")
	private WebElement datePickOut;

	@FindBy(id = "adult_room")
	private WebElement dDbAdultRoom;
	
	
	@FindBy(id = "child_room")
	private WebElement dDbChildRoom;
		
	@FindBy(id = "Submit")
	private WebElement dDbSubmit;
	
	
	public WebElement getdDbLocation() {
		return dDbLocation;
	}

	public WebElement getdDbHotel() {
		return dDbHotel;
	}

	public WebElement getdDbRoomType() {
		return dDbRoomType;
	}

	public WebElement getdDbRoomNos() {
		return dDbRoomNos;
	}
	public WebElement getDatePickIn() {
		return datePickIn;
	}

	public WebElement getDatePickOut() {
		return datePickOut;
	}

	public WebElement getdDbAdultRoom() {
		return dDbAdultRoom;
	}

	public WebElement getdDbChildRoom() {
		return dDbChildRoom;
	}

	public WebElement getdDbSubmit() {
		return dDbSubmit;
	}
// -------------------------------------------------------------------------------------------------
	
	public  void serchHotelPage(String sheetname) throws IOException {
		
		elementSelectByValue(getdDbLocation(), getDataFromCell(sheetname, 1, 2));
		elementSelectByValue(getdDbHotel(), getDataFromCell(sheetname, 1, 3));
		elementSelectByValue(getdDbRoomType(), getDataFromCell(sheetname, 1, 4));
		elementSendKey(getdDbRoomNos(), getDataFromCell(sheetname, 1, 5));
		//elementSelectByValue(getdDbRoomNos(), getDataFromCell(sheetname, 1, 5));
		elementSendKey(getDatePickIn(), getDataFromCell(sheetname, 1, 6));
		
		elementSendKey(getDatePickOut(), getDataFromCell(sheetname, 1, 7));
		elementSelectByValue(getdDbAdultRoom(), getDataFromCell(sheetname, 1, 8));
		elementSelectByValue(getdDbChildRoom(), getDataFromCell(sheetname, 1, 9));
		elementClick(getdDbSubmit());
		
	}
	
	
	

}
