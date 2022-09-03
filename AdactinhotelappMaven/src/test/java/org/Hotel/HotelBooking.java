package org.Hotel;

import java.io.IOException;

import org.POM.BookAHotel;
import org.POM.CancelBooking;
import org.POM.LoginPage;
import org.POM.SearchHotel;
import org.POM.SelectHotel;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;



public class HotelBooking extends BaseClass {

	
	@BeforeClass
	public static void openingBrowser() {
		System.out.println("Browser opening...");
		launchChromeBrowser();
		navigateToUrl("http://adactinhotelapp.com/");

	}
	
	
	@Test 
	public  void test1() throws IOException {
		System.out.println("Login page running...");
		LoginPage loginPage = new LoginPage();
		loginPage.login("hotel1");
	}
	
	
	@Test
	public void test2() throws IOException {
		System.out.println("Serching Hotel.....");
		SearchHotel hotel= new SearchHotel();
		hotel.serchHotelPage("hotel1");
	}
	
	
	@Test
	public void test3() {
		System.out.println("conforming HotelPage....");
		SelectHotel hotel= new SelectHotel();
				hotel.selectingOneHotel();

	}
	
	@Test
	public void test4() throws IOException, InterruptedException {
		System.out.println("Booking a hotel......");
		BookAHotel aHotel = new BookAHotel();
		aHotel.bookHotelWithDetailes("hotel1");

	}
	
	@Test
	public void test5() throws InterruptedException, IOException {
		System.out.println("Process to canceling Your Order...");
		CancelBooking booking = new CancelBooking();
		booking.cancleOrderId("hotel1");
	
	}
	
	
	@AfterClass
	public static void closeingBrowser() throws InterruptedException {
		Thread.sleep(5000);
		closeBrowser();
		System.out.println("Browser closed");

	}

}
