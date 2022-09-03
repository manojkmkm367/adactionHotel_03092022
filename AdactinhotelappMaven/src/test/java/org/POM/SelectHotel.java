package org.POM;

import org.Hotel.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotel extends BaseClass {
	public SelectHotel() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "radiobutton_0")
	private WebElement btnRadiobutton;

	@FindBy(id="continue")
	private WebElement btnContinue;

	public WebElement getBtnRadiobutton() {
		return btnRadiobutton;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}
	
	
//=====================================================================
	
	public void selectingOneHotel() {
		
		elementClick(getBtnRadiobutton());
		elementClick(getBtnContinue());
		

	}
	
	
	
	
	
	
	
	
	
	
	
}
