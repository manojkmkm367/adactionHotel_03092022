package org.POM;

import java.io.IOException;

import org.Hotel.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookAHotel extends BaseClass {
	public BookAHotel() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "first_name")
	private WebElement txtFirstName;
	
	@FindBy(id = "last_name")
	private WebElement txtLastName;
	
	@FindBy(id = "address")
	private WebElement txtAddress;
	
	@FindBy(id = "cc_num")
	private WebElement txtCCNum;
	
	@FindBy(id = "cc_type")
	private WebElement dDnCCType;
	
	@FindBy(id = "cc_exp_month")
	private WebElement dDnCCExpMoth;
	
	@FindBy(id = "cc_exp_year")
	private WebElement dDnCCExpYear;
	
	@FindBy(id = "cc_cvv")
	private WebElement txtCcCvv;

	@FindBy(id = "book_now")
	private WebElement btnBook;
	
	
	@FindBy(id = "order_no")
	private WebElement txtOrderId;
	

	public WebElement getTxtOrderId() {
		return txtOrderId;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCCNum() {
		return txtCCNum;
	}

	public WebElement getdDnCCType() {
		return dDnCCType;
	}

	public WebElement getdDnCCExpMoth() {
		return dDnCCExpMoth;
	}

	public WebElement getdDnCCExpYear() {
		return dDnCCExpYear;
	}

	public WebElement getTxtCcCvv() {
		return txtCcCvv;
	}

	public WebElement getBtnBook() {
		return btnBook;
	}
	
	
	
//======================================================================================================================
	
	
	public void bookHotelWithDetailes(String sheetName) throws IOException, InterruptedException {
		
		elementSendKey(getTxtFirstName(),  getDataFromCell(sheetName, 1, 10));
		elementSendKey(getTxtLastName(),  getDataFromCell(sheetName, 1, 11));
		elementSendKey(getTxtAddress(),  getDataFromCell(sheetName, 1, 12));
		elementSendKey(getTxtCCNum(),  getDataFromCell(sheetName, 1, 13));
		elementSelectByValue(getdDnCCType(), getDataFromCell(sheetName, 1, 14));
		elementSelectByValue(getdDnCCExpMoth(), getDataFromCell(sheetName, 1, 15));
		elementSelectByValue(getdDnCCExpYear(), getDataFromCell(sheetName, 1, 16));
		elementSendKey(getTxtCcCvv(),  getDataFromCell(sheetName, 1, 17));
		elementClick(getBtnBook());

		Thread.sleep(10000);
		String orderID = elementGetAttribute(getTxtOrderId());
		System.out.println("My Booking order id :"+orderID);
		putDataToCell(sheetName, 1, 18, orderID);
		
	}
	
	
	
	
	

}
